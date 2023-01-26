package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

public interface BoardService {
	//모든 게시글 조회
	List<Board> getBoardList();
	
	//글을 읽자 (상세글 조회)
	Board readBoard(int id);
	
	//글을 작성하자.
	void writeBoard(Board board);
	
	//글을 수정하자.
	void modifyBoard(Board board);
	
	//글을 삭제하자.
	void removeBoard(int id);
	
	//글 하나를 가져온다.
	Board getBoard(int id);
	
	//검색했다면 검색 기준에 따른 값을 가져와라 
	List<Board> search(SearchCondition condition);
	
}
