package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;



// 해당 클래스는 REST API를 적용
// 따라서  Talend API Tester를 활용

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://127.0.0.1:5500")				// "http://127.0.0.1:5500" 주소에서 들어온 요청도 허락하겠다.
//@CrossOrigin("*")									// (어떤 주소로 들어올지 모르므로) 어느 주소에서 들어오든 모든 요청을 허락하겠다.
public class BoardRestController {
	
	@Autowired
	private BoardService bs;
	
	
	/**
	 * 모든 리스트 반환
	 */
	@GetMapping("/board")
	public ResponseEntity<List<Board>> list() {
		return new ResponseEntity<List<Board>>(bs.getBoardList(), HttpStatus.OK);
	}
	
}
