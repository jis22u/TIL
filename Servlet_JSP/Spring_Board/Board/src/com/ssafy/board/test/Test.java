package com.ssafy.board.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

public class Test {
	public static void main(String[] args) throws SQLException {
		//Spring컨테이너 빌드
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
//		//boardDao빈 객체를 얻어와서
//		BoardDao boardDao = context.getBean("boardDao", BoardDao.class);
//		//원하는 기능을 호출
//		for(Board b : boardDao.selectAll())
//			System.out.println(b);
		BoardService boardService = 
				context.getBean("boardService", BoardService.class);
		boardService.readBoard(2491);
		for(Board b : boardService.getBoardList())
			System.out.println(b);
		
//		BoardDao dao = BoardDaoImpl.getInstance();
//		
//		Board board = new Board("흐흐나는 슬퍼", "권영진", "이제는 웃을 거야 스마일어게인 ㅋ");
////		
//		try {
//			for(int i = 0 ; i<10000; i++)
//				dao.insertBoard(board);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
////		try {
////			Board board = dao.selectOne(3);
////			System.out.println(board);
////			board.setContent("사실 나는 커피사냥꾼이 맞습니다.");
////			dao.updateBoard(board);
////			dao.updateViewCnt(3);
////		} catch (SQLException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		for(Board b : dao.selectAll()) {
////			System.out.println(b);
////		}
		
		
		
			
	}
}
