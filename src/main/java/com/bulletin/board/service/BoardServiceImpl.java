package com.bulletin.board.service;

import com.bulletin.board.dao.BoardDao;
import com.bulletin.board.domain.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{


    private final BoardDao boardDao;

    @Override
    public List<BoardVO> list() {
        return boardDao.list();
    }

    @Override
    public int delete(BoardVO boardVO) {
        return boardDao.delete(boardVO);
    }

    @Override
    public int edit(BoardVO boardVO) {
        return boardDao.update(boardVO);
    }

    @Override
    public void write(BoardVO boardVO) {
        boardDao.insert(boardVO);
    }

    @Override
    public BoardVO read(int seq) {
        boardDao.updateReadCount(seq);
        return boardDao.select(seq);
    }
}
