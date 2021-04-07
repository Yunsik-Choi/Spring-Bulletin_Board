package com.bulletin.board.dao;

import com.bulletin.board.domain.BoardVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDaoMyBatis implements BoardDao{

    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<BoardVO> list() {
        return sqlSessionTemplate.selectList("list");
    }

    @Override
    public int delete(BoardVO boardVO) {
        return sqlSessionTemplate.delete("delete", boardVO);
    }

    @Override
    public int deleteAll() {
        return sqlSessionTemplate.delete("deleteAll");
    }

    @Override
    public int update(BoardVO boardVO) {
        return sqlSessionTemplate.update("update", boardVO);
    }

    @Override
    public void insert(BoardVO boardVO) {
        sqlSessionTemplate.insert("insert", boardVO);
    }

    @Override
    public BoardVO select(int seq) {
        BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("select", seq);
        return vo;
    }

    @Override
    public int updateReadCount(int seq) {
        return sqlSessionTemplate.update("updateCount", seq);
    }
}
