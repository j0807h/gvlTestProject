package sp.jh.example.testProject.controller.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sp.jh.example.testProject.command.BoardCommand;
import sp.jh.example.testProject.service.board.BoardListService;
import sp.jh.example.testProject.service.board.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	@Autowired
	BoardListService boardListService;
	
	@RequestMapping(value="boardList", method = RequestMethod.GET)
	public String boardList(@RequestParam(value="page", defaultValue = "1")Integer page, Model model) {
		boardListService.getList(page, model);
		return "board/boardList";
	}
	@RequestMapping(value="writeBoard", method = RequestMethod.GET)
	public String writeBoard(BoardCommand boardCommand) {
		return "board/boardForm";
	}
	@RequestMapping(value="boardRegist", method = RequestMethod.POST)
	public String boardRegist(@Validated BoardCommand boardCommand, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "board/boardForm";
		}
		boardService.registBoard(boardCommand, result, request);
		return "redirect:/";
	}
}


