package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertMember",member);
	}

	public Member loginMember(SqlSession sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.loginMember", member);
	}

}
