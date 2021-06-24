package sp.jh.example.testProject.controller.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sp.jh.example.testProject.command.CommentCommand;
import sp.jh.example.testProject.domain.AuthInfo;
import sp.jh.example.testProject.domain.CommentDTO;
import sp.jh.example.testProject.service.board.CommentListService;
import sp.jh.example.testProject.service.comment.CommentService;

@Controller
@RequestMapping(value="comment")
public class CommentController {
	
	AuthInfo authInfo;
	
	@Autowired
	CommentService commentService;
	@Autowired
	CommentListService commentListService;
	
	
	//댓글 등록(Ajax)
	@RequestMapping(value="regist", method = RequestMethod.POST)
	@ResponseBody
//	public int registComment(HttpSession session, @RequestParam int boardNum, @RequestParam String coContent) throws Exception {
	public String ajax_registComment(@ModelAttribute("commentCommand")CommentCommand commentCommand, HttpServletRequest request ) throws Exception {
		CommentDTO dto = new CommentDTO();
//		dto.setBoardNum(boardNum);
//		dto.setCoContent(coContent);
//		dto.setCoWriter(session.getId()); //로그인한 사용자 == 작성자
		
		commentService.registComment(dto, commentCommand, request);
		
//		return commentService.registComment(dto);
		return "success";
	}


	
	@RequestMapping(value="commentList")
	public String commentList(@ModelAttribute("commentCommand")CommentCommand commentCommand, Model model) throws Exception {
		commentListService.getCommentList(commentCommand, model);
		String boardNum = String.valueOf(commentCommand.getBoardNum());
		return "redirect:/boardDetail/{boardNum}";
	}
	
	//댓글 불러오기(Ajax)
//	@RequestMapping(value="commentList",  produces="application/json; charset=utf8")
//	@ResponseBody
//	public ResponseEntity ajax_commentList(@ModelAttribute("commentCommand")CommentCommand commentCommand, HttpServletRequest request ) throws Exception {
//		
//		return	commentListService.registComment(commentCommand, request);
//		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
//	}
	
}
