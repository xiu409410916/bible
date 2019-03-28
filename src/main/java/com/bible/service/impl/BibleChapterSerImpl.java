package com.bible.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.dao.BibleChapterDao;
import com.bible.dao.BibleTicketDao;
import com.bible.model.BibleChapter;
import com.bible.model.BibleTicket;
import com.bible.service.BibleChapterSer;
import com.bible.util.HttpRequest;

@Service
public class BibleChapterSerImpl implements BibleChapterSer {

	
	@Autowired
	private BibleTicketDao bibleTicketDao;
	
	@Autowired
	private BibleChapterDao bibleChapterDao;
	
	/**
	 * 数据的录入
	 */
	public void insert() {
		List<BibleTicket> list = bibleTicketDao.findAll();
		
		
		List<BibleChapter> listCha = new ArrayList<>();
		for (BibleTicket bibleTicket : list) {
			String html = HttpRequest.sendGet("http://sj.jidujiao.com/"+bibleTicket.getEnglishName()+"_"+bibleTicket.getTicketId()+".html", "");
			Document doc = Jsoup.parse(html);
			System.out.println(html);
			System.out.println(doc.getElementsByClass("zhangList").first());
			Elements ele = doc.getElementsByClass("zhangList").first().getElementsByTag("li");
			for (int i = 0 ;i<ele.size();i++) {
				BibleChapter bc = new BibleChapter();
				bc.setChapterName(ele.get(i).getElementsByTag("a").first().text());
				BeanUtils.copyProperties(bibleTicket, bc);
				listCha.add(bc);
			}
			
		}
		
		bibleChapterDao.saveAll(listCha);
		
	}
	
	

}
