package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	// 만들어진 DBUtil 들고오기
//	private final DBUtil util = DBUtil.getInstance();
	private DataSource ds;

//	private static BoardDaoImpl instance = new BoardDaoImpl();

	public BoardDaoImpl(DataSource ds) {
		this.ds = ds;
	}

//	public static BoardDaoImpl getInstance() {
//		return instance;
//	}

	@Override
	public List<Board> selectAll() {
		String sql = "SELECT * FROM board";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Board> list = new ArrayList<>();
		try {
//			conn = util.getConnection();
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getString("reg_date"));
				board.setViewCnt(rs.getInt("view_cnt"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			util.close(rs, stmt, conn);
		}
		return list;
	}

	@Override
	public Board selectOne(int id) throws SQLException {
		String sql = "SELECT * FROM board WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Board board = new Board();
		
		try {
//			conn = util.getConnection();
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board.setId(rs.getInt(1));
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setViewCnt(rs.getInt(5));
				board.setRegDate(rs.getString(6));
			}
		}finally {
//			util.close(conn, pstmt, rs);
		}
		
		return board;
	}

	@Override
	public void insertBoard(Board board) throws SQLException {
//		String sql = "INSERT INTO board (title, writer, content) VALUES ('"+board.getTitle()+"','"++""')";
		String sql = "INSERT INTO board (title, writer, content) VALUES (?,?,?)";

		// DB 접속해서 사용하게끔 쓰자.
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
//			conn = util.getConnection();
			conn = ds.getConnection();
			// autocommit 해제
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			int result = pstmt.executeUpdate();
			System.out.println(result);

			// 지금까지 작업한거 커밋날려라.
			conn.commit();
		}
//		catch(Exception e) {
//			conn.rollback();
//		}
		finally {
//			util.close(pstmt, conn);
		}

	}

	@Override
	public void deleteBoard(int id) throws SQLException {
		String sql = "DELETE FROM board WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = util.getConnection();
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
		}finally {
//			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateBoard(Board board) throws SQLException {
		String sql = "UPDATE board SET title = ?, content = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = util.getConnection();
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getId());
			
			pstmt.executeUpdate();
		}finally {
//			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateViewCnt(int id) throws SQLException {
		String sql = "UPDATE board SET view_cnt = view_cnt+1 WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = util.getConnection();
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
		}finally {
//			util.close(pstmt, conn);
		}
	}

}
