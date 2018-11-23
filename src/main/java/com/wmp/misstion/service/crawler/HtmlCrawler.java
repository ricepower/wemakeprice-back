package com.wmp.misstion.service.crawler;

import com.wmp.misstion.service.crawler.parser.Parser;

public class HtmlCrawler extends Crawler {

	public HtmlCrawler(Parser parser) {
		super(parser);
		this.contentsType = () -> document.html();
	}
}
