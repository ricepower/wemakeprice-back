package com.wmp.misstion.service.crawler;

import com.wmp.misstion.service.crawler.parser.Parser;

public class HtmlCrawler extends Crawler {

	private HtmlCrawler(Parser parser) {
		super(parser);
		this.contentsType = () -> document.html();
	}
	
	public static HtmlCrawler create(Parser parser) {
		return new HtmlCrawler(parser);
	}
}
