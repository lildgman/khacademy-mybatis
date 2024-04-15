package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.common.vo.PageInfo;

public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = boardDao.selectListCount(sqlSession);
		
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		return list;
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = boardDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		return searchCount;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		return list;
	}

	@Override
	public Board increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = boardDao.increaseCount(sqlSession, boardNo);
		Board board = null;
		
		if(result > 0) {
			sqlSession.commit();
			board = boardDao.selectBoard(sqlSession, boardNo);
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return board;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Reply> list = boardDao.selectReplyList(sqlSession, boardNo);
		
		sqlSession.close();
		return list;
	}

}
