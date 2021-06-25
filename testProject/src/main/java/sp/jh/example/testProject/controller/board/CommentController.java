package sp.jh.example.testProject.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sp.jh.example.testProject.command.CommentCommand;
import sp.jh.example.testProject.domain.AuthInfo;
import sp.jh.example.testProject.domain.CommentDTO;
import sp.jh.example.testProject.service.board.CommentListService;
import sp.jh.example.testProject.service.comment.CommentDelService;
import sp.jh.example.testProject.service.comment.CommentService;

@Controller
@RequestMapping(value="comment")
public class CommentController {
	
	AuthInfo authInfo;
	
	@Autowired
	CommentService commentService;
	@Autowired
	CommentListService commentListService;
	@Autowired
	CommentDelService commentDelService;
	
	
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


	
	
	// 댓글 불러오기(Ajax)
	@RequestMapping(value="commentList")
	@ResponseBody
	public List<CommentDTO> commentList(Model model) throws Exception {
//		commentListService.getCommentList();
//		String boardNum = String.valueOf(commentCommand.getBoardNum());
		return commentListService.getCommentList();
	}
	
	
	//댓글 삭제(Ajax)
	@RequestMapping(value="delete/{coNum}")
	@ResponseBody
	public int commentDelete(@PathVariable(value="coNum") int coNum) throws Exception {
		return commentDelService.commentDelete(coNum);
	}
	
}
