package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardService {
	//목록 조회
	public List<Board> getBoardList();
	//게시글 조회
	public Board readBoard(int id)  throws SQLException;
	//게시글 수정
	public void modifyBoard(Board board)  throws SQLException;
	//게시글 삭제
	public void deleteBoard(int id)  throws SQLException;
	//게시글 작성 
	public void writeBoard(Board board)  throws SQLException;
}
