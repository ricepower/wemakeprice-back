package com.wmp.misstion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wmp.misstion.constant.Enums;
import com.wmp.misstion.service.CrawlingService;
import com.wmp.misstion.vo.CrawlingResponseVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Crawling", tags="Crawling")
@RestController
public class CrawlingController {

	@Autowired
	private CrawlingService crawlingService;
	
	@CrossOrigin("*")
	@GetMapping("/crawling")
	@ApiOperation(value="데이터 크롤링 후 적절한 포맷으로 변경합니다.", response=CrawlingResponseVo.class)
	public ResponseEntity<Object> crawling(
			@RequestParam(required=true) String url, 
			@RequestParam(required=true) Enums.Type type, 
			@RequestParam(required=true) int numberOfPacking) {
		
		return new ResponseEntity<Object>(crawlingService.crawling(url, type, numberOfPacking), HttpStatus.OK);
	}
}
