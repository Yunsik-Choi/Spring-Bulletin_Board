package com.bulletin.board.controller;

import com.bulletin.board.dao.BoardDao;
import com.bulletin.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BoardService boardService;

    @RequestMapping(value = "/")
    @ResponseBody
    public String home(){
        return "<h1>Hello</h1>";
    }

    @RequestMapping(value = "/board/list")
    @ResponseBody
    public String list(){
        return boardService.list().toString();
    }

}
