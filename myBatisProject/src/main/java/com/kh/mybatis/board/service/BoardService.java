package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.vo.PageInfo;

public interface BoardService {
	
	//게시판리스트 조회
	int selectListCount();
	ArrayList<Board> selectList(PageInfo pi);
	
	//게시글 검색
	int selectSearchCount(HashMap<String, String> map);
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
	Board increaseCount(int boardNo);
	
	//게시글 상세조회
	ArrayList<Reply> selectReplyList(int boardNo);
}
