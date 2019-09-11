package org.dante.springcloud.vo;

import lombok.Data;

@Data
public class TechnologyVO {
	
	private String name;
	private String description;
	
	public TechnologyVO(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
}
