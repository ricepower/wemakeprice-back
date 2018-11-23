package com.wmp.misstion.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.wmp.misstion.service.crawler.parser.CharacterAndNumberParser;
import com.wmp.misstion.service.crawler.parser.Parser;

public class ParserUnitTest {
	
	private Parser parser = new CharacterAndNumberParser();
	
	@Test
	public void parser_Test() {
		assertThat(parser.parse("a~!@#$%^&*()_+{}[]\\|仮名,./?ひらが"), is("a"));
		assertThat(parser.parse("a"), is("a"));
		assertThat(parser.parse("B"), is("B"));
		assertThat(parser.parse("9"), is("9"));
		assertThat(parser.parse("bac"), is("abc"));
		assertThat(parser.parse("ZBD"), is("BDZ"));
		assertThat(parser.parse("AAAA"), is("AAAA"));
		assertThat(parser.parse("1111"), is("1111"));
		assertThat(parser.parse("bbbb"), is("bbbb"));
		assertThat(parser.parse("AacD"), is("AaDc"));
		assertThat(parser.parse("9264"), is("2469"));
		assertThat(parser.parse("1BE2"), is("B1E2"));
		assertThat(parser.parse("1Ebe"), is("E1be"));
		assertThat(parser.parse("a99c9323"), is("a2c33999"));
		assertThat(parser.parse("0aabbA798"), is("A0a7a8b9b"));
		assertThat(parser.parse("ZJJ4h34jkJje8"), is("J3e4J4h8JjZjk"));
	}
}
