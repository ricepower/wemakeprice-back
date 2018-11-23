package com.wmp.misstion.service.crawler;

import java.io.IOException;
import java.util.function.Supplier;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.wmp.misstion.service.crawler.parser.Parser;

public abstract class Crawler {

	protected Document document;
	protected Supplier<String> contentsType;
	protected Parser parser;
	
	public Crawler(Parser parser) {
		this.parser = parser;
	}
	
	public String crawling(String url) {
		try {
			document = Jsoup.connect(url).get();
			return parser.parse(contentsType.get());
		}
		catch (IOException e) {
			throw new IllegalArgumentException("fail to parse data. please check your url");
		}
	}
}
