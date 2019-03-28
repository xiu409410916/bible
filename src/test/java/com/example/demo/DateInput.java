package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bible.model.BibleChapter;
import com.bible.model.BibleSection;
import com.bible.model.BibleTicket;
import com.bible.util.HttpRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateInput {
	
	@Test
	public void dateinput() {
//		String html = HttpRequest.sendGet("http://www.godcom.net/hhb/cuvgb.htm", "");
//		Document document = Jsoup.parse(html);
//		Elements trs = document.getElementsByAttribute("tbody").first().getElementsByAttribute("tr");
//		
//		
//		//旧约圣经
//		Element el = trs.get(1);
//		Elements elsss = el.getElementsByAttribute("tbody").first().getElementsByAttribute("tr");
//		System.out.println(elsss);
//		
//		//新约圣经
//		Element newel = trs.get(2);
		System.out.println("");
//		
	}
	
	public static void main(String[] args) {
		String html = HttpRequest.sendGet("http://www.godcom.net/hhb/cuvgb.htm", "");
		Document document = Jsoup.parse(html);
//		System.out.println(document);
//		System.out.println(document.getElementsByTag("tbody").first());
		Elements trs = document.getElementsByTag("tbody").first().getElementsByTag("tr");
		
		
		List<BibleTicket> bkList = new ArrayList<>();
		List<BibleChapter> bcList = new ArrayList<>();
		List<BibleSection> bsList = new ArrayList<>();
		
		
		//旧约圣经
		Element el = trs.get(1);
		Elements elsss = el.getElementsByTag("tbody").first().getElementsByTag("tr");
		for (Element element : elsss) {
			Element f = element.getElementsByTag("a").first();
			String name = f.text();
			
			//券名
			BibleTicket bt = new BibleTicket();
			bt.setTicketName(name);
			bt.setVersionId(1);
			bt.setBibleType("0");
			bkList.add(bt);
			System.out.println(name);
			
			//章
			String url = "http://www.godcom.net/hhb/"+f.attr("href");
			String chapter = HttpRequest.sendGet(url, "");
			Document chaDoc = Jsoup.parse(chapter);
			
			//第一章
			
			
//			//后续的章节
//			BibleChapter ch = new BibleChapter();
//			ch.setChapterName(chapterName);
//			
//			Elements ticketD = doc.getElementsByTag("tbody").get(1).getElementsByTag("tr");
//			for (Element t : ticketD) {
//				
//			}
//			
//			Elements chsss = doc.getElementsByTag("tbody").first().getElementsByTag("a");
//			for (Element dd : chsss) {
//				//节
//				url = "http://www.godcom.net/hhb/"+dd.attr("href");
//				String tickethtml = HttpRequest.sendGet(url, "");
//				Document doc2 = Jsoup.parse(tickethtml);
//
//				Element ticketD2 = doc2.getElementsByTag("tbody").get(1);
//				System.out.println(ticketD2);
//			}
//			
			
			
			System.out.println("-------------");
		}
		
		//新约圣经
		Element newel = trs.get(2);
		Elements newelsss = newel.getElementsByTag("tbody").first().getElementsByTag("tr");
//		System.out.println(newelsss);
		for (Element element : newelsss) {
			
		}
	}
	
	
	

}
