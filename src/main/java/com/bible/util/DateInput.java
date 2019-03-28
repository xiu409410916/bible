package com.bible.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bible.dao.BibleChapterDao;
import com.bible.dao.BibleSectionDao;
import com.bible.dao.BibleTicketDao;
import com.bible.model.BibleChapter;
import com.bible.model.BibleSection;
import com.bible.model.BibleTicket;


@Component
public class DateInput {
	
	@Autowired
	private BibleTicketDao bibleTicketDao;
	
	@Autowired
	private BibleChapterDao bibleChapterDao;
	
	@Autowired
	private BibleSectionDao bibleSectionDao;
	
	public void insert(){
		String html = HttpRequest.sendGet("http://www.godcom.net/hhb/cuvgb.htm", "");
		Document document = Jsoup.parse(html);
//		System.out.println(document);
//		System.out.println(document.getElementsByTag("tbody").first());
		Elements trs = document.getElementsByTag("tbody").first().getElementsByTag("tr");
		
		int j = 0;
		//旧约圣经
		Element el = trs.get(1);
		Elements elsss = el.getElementsByTag("tbody").first().getElementsByTag("tr");
		for (Element element : elsss) {
			j++;
			Element f = element.getElementsByTag("a").first();
			String name = f.text();
			
			//券名
			BibleTicket bt = new BibleTicket();
			bt.setTicketName(name);
			bt.setVersionId(1);
			bt.setBibleType("0");
			bt = bibleTicketDao.save(bt);
			System.out.println(name);
			//章
//			String url = "http://www.godcom.net/hhb/"+f.attr("href");
//			String chapter = HttpRequest.sendGet(url, "");
//			Document chaDoc = Jsoup.parse(chapter);
//			String max =chaDoc.getElementsByTag("tbody").first().getElementsByTag("a").last().text();
//			DateInput.bibleChapterdata(bt,Integer.valueOf(max) , j);
			
			System.out.println("-------------");
		}
		
		//新约圣经
		Element newel = trs.get(2);
		Elements newelsss = newel.getElementsByTag("tbody").first().getElementsByTag("tr");
//		System.out.println(newelsss);
		for (Element element : newelsss) {
			
		}
	}
	
	
	
	public void bibleChapterdata(BibleTicket ticket,int max,int j) { 
		String dd = j<10?"0"+j:j+"";
		for (int i = 0; i <= max; i++) {
			String ff = i<10?"0"+i:i+"";
			String url = "http://www.godcom.net/hhb/"+"B"+dd+"C0"+ff+".htm";
			String tickethtml = HttpRequest.sendGet(url, "");
			Document doc2 = Jsoup.parse(tickethtml);
			
			BibleChapter bc = new BibleChapter();
			bc.setChapterName(i+"");
			bc.setTicketId(ticket.getTicketId());
			bc.setTicketName(ticket.getTicketName());
			bc.setVersionId(1);
			bc.setBibleType(ticket.getBibleType());
			bc = bibleChapterDao.save(bc);
			
			Elements els = doc2.getElementsByTag("tbody").get(1).getElementsByTag("tr");
			for (Element element : els) {
				BibleSection bs = new BibleSection();
				
				String names = element.getElementsByTag("td").first().text();
				String text = element.getElementsByTag("td").get(1).text();
				
				bs.setSectionName(names.split(":")[1]);
				bs.setSectionMessage(text);
				BeanUtils.copyProperties(bc, bs);
				
			}
			
		}
	}

}
