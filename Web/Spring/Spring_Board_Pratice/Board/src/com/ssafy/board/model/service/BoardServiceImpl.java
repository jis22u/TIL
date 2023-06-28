package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class BoardServiceImpl implements BoardService{
	private BoardDao boardDao;
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return this.boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) throws SQLException {
		// TODO Auto-generated method stub
		this.boardDao.updateViewCnt(id);
		return this.boardDao.selectOne(id);
	}

	@Override
	public void modifyBoard(Board board) throws SQLException {
		// TODO Auto-generated method stub
		this.boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int id) throws SQLException {
		// TODO Auto-generated method stub
		this.boardDao.deleteBoard(id);
	}

	@Override
	public void writeBoard(Board board) throws SQLException {
		// TODO Auto-generated method stub
		this.boardDao.insertBoard(board);
	}
}
