package com.bible.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.commons.ReturnEntity;
import com.bible.dao.BibleChapterDao;
import com.bible.dao.BibleSectionDao;
import com.bible.dao.BibleTicketDao;
import com.bible.dao.UserPraiseDao;
import com.bible.dao.UserReadDao;
import com.bible.dao.UserThoughtDao;
import com.bible.dto.BibleSectionDto;
import com.bible.model.BibleChapter;
import com.bible.model.BibleSection;
import com.bible.model.BibleTicket;
import com.bible.model.UserPraise;
import com.bible.model.UserRead;
import com.bible.service.BibleSectionSer;
import com.bible.util.HttpRequest;

@Service
public class BibleSectionSerImpl implements BibleSectionSer {

	@Autowired
	private BibleSectionDao bibleSectionDao;

	@Autowired
	private BibleTicketDao bibleTicketDao;
	
	@Autowired
	private BibleChapterDao bibleChapterDao;
	
	@Autowired
	private UserReadDao userReadDao;
	
	@Autowired
	private UserPraiseDao userPraiseDao;
	
	@Autowired
	private UserThoughtDao userThoughtDao;
	
	/**
	 * 数据的录入
	 */
	public void insert() {
		List<BibleSection> listSc = new ArrayList<>();
		
		List<BibleTicket> list = bibleTicketDao.findAll();
		for (BibleTicket bibleTicket : list) {
			List<BibleChapter> list2 = bibleChapterDao.findByTicketId(bibleTicket.getTicketId());
			for (BibleChapter bc : list2) {
				String html = HttpRequest.sendGet("http://sj.jidujiao.com/"+bibleTicket.getEnglishName()+"_"+bibleTicket.getTicketId()+"_"+bc.getChapterName()+".html", "");
				Document doc = Jsoup.parse(html);
				
				Elements els = doc.getElementsByClass("jingRead").first().getElementsByTag("li");
				for (int i = 0 ;i<els.size();i++) {
					BibleSection sc = new BibleSection();
					BeanUtils.copyProperties(bc, sc);
					
					sc.setSectionName(els.get(i).getElementsByTag("span").first().text());
					String message = els.get(i).getElementsByTag("p").first().text();
					sc.setSectionMessage(message.replaceAll("\"", "").replaceAll("<br>", ""));
					
					listSc.add(sc);
				}
			}
		}
		
		bibleSectionDao.saveAll(listSc);
	}
	
	
	/**
	 * 随机获取“圣经的一个节”信息
	 * @return
	 */
	public ReturnEntity<BibleSectionDto> randomBibleSection(Integer userId){
		Integer sectionId = RandomUtils.nextInt(1, 31104);
		BibleSection bs = bibleSectionDao.findBySectionId(sectionId);
		
		UserRead userRead = new UserRead();
		userRead.setUserId(userId);
		userRead.setSectionId(sectionId);
		userRead.setReadTitle(bs.getTicketName()+"|"+bs.getChapterName()+":"+bs.getSectionName());
		userRead.setCreateTime(new Timestamp(System.currentTimeMillis()));
		userReadDao.save(userRead);
		
		BibleSectionDto dto = new BibleSectionDto();
		BeanUtils.copyProperties(bs, dto);
		dto.setUserId(userId);
		
		ReturnEntity<BibleSectionDto> re = new ReturnEntity<BibleSectionDto>();
		re.setData(dto);
		return re;
	}
	
	
	

	/**
	 * 获取“圣经的一个节”信息
	 * @return
	 */
	public ReturnEntity<BibleSectionDto> getBibleSection(Integer userId,Integer sectionId){
		BibleSection bs = bibleSectionDao.findBySectionId(sectionId);
		
		BibleSectionDto dto = new BibleSectionDto();
		BeanUtils.copyProperties(bs, dto);
		dto.setUserId(userId);
		//用户是否点赞
		UserPraise up = userPraiseDao.findByPraiseId(userId+""+bs.getSectionId());
		dto.setIsPraise(up == null ? 0 : 1);
		//用户点赞数量
		dto.setPraiseCount(userPraiseDao.getCountBySectionId(bs.getSectionId()));
		//用户评论数量
		dto.setThoughtCount(userThoughtDao.getCountBySection(bs.getSectionId()));
		
		ReturnEntity<BibleSectionDto> re = new ReturnEntity<BibleSectionDto>();
		re.setData(dto);
		return re;
	}
	
}
