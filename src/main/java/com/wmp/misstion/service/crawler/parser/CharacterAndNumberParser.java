package com.wmp.misstion.service.crawler.parser;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

import com.wmp.misstion.constant.Regex;

public class CharacterAndNumberParser implements Parser {

	@Override
	public String parse(String contents) {
		if (Regex.WORD_NUMBER_PATTERN.matcher(contents).find()) {
			contents = Regex.WORD_NUMBER_PATTERN.matcher(contents).replaceAll("");
		}
		char[] characteredContents = contents.toCharArray();
		Arrays.sort(characteredContents);
		String sortedContents = new String(characteredContents);
		
		Queue<Character> upperCase = sortedContents.chars().mapToObj(element -> (char) element).filter(element -> Character.isUpperCase(element)).collect(Collectors.toCollection(LinkedList::new));
		Queue<Character> lowerCase = sortedContents.chars().mapToObj(element -> (char) element).filter(element -> Character.isLowerCase(element)).collect(Collectors.toCollection(LinkedList::new));
		Queue<Character> number = sortedContents.chars().mapToObj(element -> (char) element).filter(element -> Character.isDigit(element)).collect(Collectors.toCollection(LinkedList::new));
		
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while (isAllQueueNotEmpty(upperCase, number, lowerCase)) {
			pollCharacter(upperCase, lowerCase, builder, i);
			pollNumber(number, builder);
			i++;
		}
		return builder.toString();
	}
	
	private boolean isAllQueueNotEmpty(Queue<Character> upperCase, Queue<Character> digit, Queue<Character> lowerCase) {
		return !upperCase.isEmpty() || !digit.isEmpty() || !lowerCase.isEmpty();
	}

	private void pollCharacter(Queue<Character> upperCase, Queue<Character> lowerCase, StringBuilder builder, int i) {
		if (i % 2 == 0) 
			selectCheracter(lowerCase, upperCase, builder);
		else 
			selectCheracter(upperCase, lowerCase, builder);
	}

	private void selectCheracter(Queue<Character> upperCase, Queue<Character> lowerCase, StringBuilder builder) {
		if (!lowerCase.isEmpty()) 
			builder.append(lowerCase.poll());
		else if (!upperCase.isEmpty()) 
			builder.append(upperCase.poll());
	}
	
	private void pollNumber(Queue<Character> number, StringBuilder builder) {
		if (!number.isEmpty()) 
			builder.append(number.poll());
	}

}
