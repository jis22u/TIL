package com.ssafy.ws;

import java.util.Random;

public class Audience implements Person {

	@Override
	public int doSomething() throws CallException {
		System.out.println("영화를 봅니다.");
		if(new Random().nextBoolean())
			throw new CallException();
		return (int)(Math.random()* 45) + 1;
	}
	
}
