package com.wmp.misstion.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CrawlingResponseVo {
	
	@ApiModelProperty(value="몫")
	private String quotient;

	@ApiModelProperty(value="나머지")
	private String reminder;
}
