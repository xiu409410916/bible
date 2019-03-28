package com.bible.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.dao.BibleTicketDao;
import com.bible.model.BibleTicket;
import com.bible.service.BibleTicketSer;
import com.bible.util.HttpRequest;


@Service
public class BibleTicketSerImpl implements BibleTicketSer {
	
	@Autowired
	private BibleTicketDao bibleTicketDao;
	
	/**
	 * 券的新增
	 */
	public void insert(){
		String html = HttpRequest.sendGet("http://sj.jidujiao.com/", "");
		Document document = Jsoup.parse(html);
		Elements trs = document.getElementsByClass("jingList");
		List<BibleTicket> list = new ArrayList<>();
		
		//旧约圣经
		Elements elsss = trs.get(0).getElementsByTag("li");
		for (Element element : elsss) {
			Element f = element.getElementsByTag("a").first();
			String name = f.getElementsByTag("span").first().text();
			String strongName = f.getElementsByTag("strong").first().text();
			String englishname = f.attr("href");
			if(StringUtils.isEmpty(name)) {
				continue;
			}
			//券名
			BibleTicket bt = new BibleTicket();
			bt.setTicketName(name);
			bt.setVersionId(1);
			bt.setBibleType("0");
			bt.setStrongName(strongName);
			int index = englishname.indexOf("_");
			bt.setEnglishName(englishname.substring(1,index));
			bt.setCreateTime(new Timestamp(System.currentTimeMillis()));
			System.out.println(name);
			list.add(bt);
		}
		
		//新约圣经
		Elements newelsss = trs.get(1).getElementsByTag("li");
		for (Element element : newelsss) {
			Element f = element.getElementsByTag("a").first();
			String name = f.getElementsByTag("span").first().text();
			String strongName = f.getElementsByTag("strong").first().text();
			String englishname = f.attr("href");
			if(StringUtils.isEmpty(name)) {
				continue;
			}
			//券名
			BibleTicket bt = new BibleTicket();
			bt.setTicketName(name);
			bt.setVersionId(1);
			bt.setBibleType("0");
			bt.setStrongName(strongName);
			int index = englishname.indexOf("_");
			bt.setEnglishName(englishname.substring(1,index));
			bt.setCreateTime(new Timestamp(System.currentTimeMillis()));
			System.out.println(name);
			list.add(bt);
		}
		
		bibleTicketDao.saveAll(list);
	}

}
