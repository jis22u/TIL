package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Action implements Movie{

	@Override
	public String getInfo() {
		return "액션 영화";
	}

}
