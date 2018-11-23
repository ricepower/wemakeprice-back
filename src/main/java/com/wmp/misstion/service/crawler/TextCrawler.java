package com.wmp.misstion.service.crawler;

import com.wmp.misstion.service.crawler.parser.Parser;

public class TextCrawler extends Crawler {
	
	public TextCrawler(Parser parser) {
		super(parser);
		this.contentsType = () -> document.text();
	}
}
