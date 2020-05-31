package com.std.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public String list(Model model, Criteria cri, HttpServletRequest request, HttpServletResponse response) {

		List<BoardVO> listBoard = boardService.getList(cri);
		model.addAttribute("listB", listBoard);
		model.addAttribute("pageMaker", new PageDTO(cri, boardService.getTotal()));
		return "board";

	}

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(BoardVO boardvo) {

		return "register";
	}

	@RequestMapping(value = "/boardRegister.do", method = RequestMethod.GET)
	public String boardRegister(BoardVO boardvo, HttpServletRequest request, HttpServletResponse response) {

		boardService.register(boardvo);

		return "redirect:/board.do";
	}

	@RequestMapping(value = "/get.do", method = RequestMethod.GET)
	public String get(@RequestParam("bno") Long bno, Model model) {
		
		model.addAttribute("board", boardService.read(bno));

		return "get";
	}


	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String update(@RequestParam("bno") Long bno, Model model,Criteria cri,RedirectAttributes rttr) {

		model.addAttribute("board", boardService.read(bno));

		return "modify";
	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.GET)
	public String updateBoard(BoardVO boardvo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		if(boardService.update(boardvo)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("Keyword", cri.getKeyword());

		return "redirect:/board.do";
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String remove(@RequestParam("bno") Long bno, Criteria cri,RedirectAttributes rttr) {

		if(boardService.delete(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("Keyword", cri.getKeyword());

		return "redirect:/board.do";
	}

}
