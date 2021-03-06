package com.wmp.misstion.service;

import org.springframework.stereotype.Service;

import com.wmp.misstion.constant.Enums;
import com.wmp.misstion.service.crawler.Crawler;
import com.wmp.misstion.service.crawler.HtmlCrawler;
import com.wmp.misstion.service.crawler.TextCrawler;
import com.wmp.misstion.service.crawler.parser.CharacterAndNumberParser;
import com.wmp.misstion.service.crawler.parser.OtherParser;
import com.wmp.misstion.vo.CrawlingResponseVo;

@Service
public class CrawlingService {

	private Crawler crawler;

	public CrawlingResponseVo crawling(String url, Enums.Type type, int numberOfPacking) {
		selectCrawler(type);
		String result = crawler.crawling(url);
		return makeResponseVo(numberOfPacking, result);
	}

	private void selectCrawler(Enums.Type type) {
		if (type == Enums.Type.TXT)
			crawler = TextCrawler.create(new CharacterAndNumberParser());
		else if (type == Enums.Type.HTML)
			crawler = HtmlCrawler.create(new CharacterAndNumberParser());
		// pseudo code
		else
			crawler = HtmlCrawler.create(new OtherParser());
	}

	private CrawlingResponseVo makeResponseVo(int numberOfPacking, String result) {
		CrawlingResponseVo responseVo = new CrawlingResponseVo();
		int reminder = result.length() % numberOfPacking;
		if (reminder == 0) {
			responseVo.setQuotient(result);
		}
		else {
			responseVo.setQuotient(result.substring(0, result.length() - reminder));
			responseVo.setReminder(result.substring(result.length() - reminder, result.length()));
		}
		return responseVo;
	}
}
