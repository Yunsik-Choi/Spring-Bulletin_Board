package com.bulletin.board.controller;

import com.bulletin.board.domain.BoardVO;
import com.bulletin.board.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@SessionAttributes("boardVO")
public class BoardController {

    private final BoardService boardService;

    @RequestMapping(value = "/")
    public String home(){
        return "/index";
    }

    @RequestMapping(value = "/board/list")
    public String list(Model model){
        model.addAttribute("boardList",boardService.list());
        return "/board/list";
    }

    @RequestMapping(value = "/board/read/{seq}")
    public String read(Model model, @PathVariable int seq){
        model.addAttribute("boardVO",boardService.read(seq));
        return "/board/read";
    }

    @RequestMapping(value = "/board/write")
    public String write(Model model){
        model.addAttribute("boardVO", new BoardVO());
        return "/board/write";
    }

    @PostMapping(value = "/board/write")
    public String write(@Valid BoardVO boardVO, BindingResult bindingResult, SessionStatus sessionStatus){
        if(bindingResult.hasErrors()){
            return "/board/write";
        }
        else{
            boardService.write(boardVO);
            sessionStatus.setComplete();
            return "redirect:/board/list";
        }
    }

    @GetMapping(value = "/board/edit")
    public String edit(@ModelAttribute BoardVO boardVO){
        return "/board/edit";
    }

    @PostMapping(value = "/board/edit")
    public String edit(@Valid @ModelAttribute BoardVO boardVO, SessionStatus sessionStatus, BindingResult result, int pwd, Model model){
        if(result.hasErrors()){
            return "/board/edit";
        }
        else{
            if(boardVO.getPassword()==pwd){
                boardService.edit(boardVO);
                sessionStatus.setComplete();
                return "redirect:/board/list";
            }
        }

        model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
        return "/board/edit";
    }

    @RequestMapping(value = "/board/delete")
    public String delete(@ModelAttribute BoardVO boardVO){
        return "/board/delete";
    }

    @PostMapping(value = "/board/delete")
    public String delete(int seq, int pwd, Model model){
        int rowCount;
        BoardVO boardVO = new BoardVO();
        boardVO.setSeq(seq);
        boardVO.setPassword(pwd);

        rowCount = boardService.delete(boardVO);

        if(rowCount==0){
            model.addAttribute("seq",seq);
            model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
            return "/board/delete";
        }
        else {
            return "redirect:/board/list";
        }
    }
}
