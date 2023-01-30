package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao;
	
	//Dao를 Autowired 주입하였따.
	@Autowired
	public void setBaordDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		System.out.println("모든 게시글을 가져온다.");
		return boardDao.selectAll();
	}

	@Transactional
	@Override
	public Board readBoard(int id) {
		System.out.println(id+"번 글을 읽습니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글을 작성합니다.");
		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정합니다.");
		boardDao.updateBoard(board);
	}

	@Transactional
	@Override
	public void removeBoard(int id) {
		System.out.println("게시글 삭제합니다.");
		boardDao.deleteBoard(id);
	}

	@Override
	public Board getBoard(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		return boardDao.search(condition);
	}

}
