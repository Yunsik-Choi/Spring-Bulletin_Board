package com.bulletin.board.controller;

import com.bulletin.board.dao.BoardDao;
import com.bulletin.board.domain.BoardVO;
import com.bulletin.board.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping(value = "/")
    @ResponseBody
    public String home(){
        return "<h1>Hello</h1>";
    }

    @RequestMapping(value = "/board/list")
    public String list(Model model){
        model.addAttribute("boardList",boardService.list());
        return "/board/list";
    }

    @RequestMapping(value = "/board/read/{seq}")
    public String read(Model model, @PathVariable int seq){
        model.addAttribute("boardVo",boardService.read(seq));
        return "/board/read";
    }

    @RequestMapping(value = "/board/write")
    public String write(Model model){
        model.addAttribute("boardVO", new BoardVO());
        return "/board/write";
    }

    @PostMapping(value = "/board/write")
    public String write(@Valid BoardVO boardVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/board/write";
        }
        else{
            boardService.write(boardVO);
            return "redirect:/board/list";
        }
    }


}
