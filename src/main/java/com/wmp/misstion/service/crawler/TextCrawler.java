package com.wmp.misstion.service.crawler;

import com.wmp.misstion.service.crawler.parser.Parser;

public class TextCrawler extends Crawler {
	
	private TextCrawler(Parser parser) {
		super(parser);
		this.contentsType = () -> document.text();
	}
	
	public static TextCrawler create(Parser parser) {
		return new TextCrawler(parser);
	}
}
