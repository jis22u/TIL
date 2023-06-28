package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Comic implements Movie {

	@Override
	public String getInfo() {
		return "코믹 영화";
	}
	
}
