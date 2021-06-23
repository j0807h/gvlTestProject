package sp.jh.example.testProject.controller.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sp.jh.example.testProject.domain.AuthInfo;
import sp.jh.example.testProject.domain.CommentDTO;
import sp.jh.example.testProject.service.comment.CommentService;

@Controller
@RequestMapping(value="/comment")
public class CommentController {
	
	AuthInfo authInfo;
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="regist", method = RequestMethod.POST)
	@ResponseBody
	public int registComment(HttpSession session, @RequestParam int boardNum, @RequestParam String coContent) throws Exception {
		CommentDTO dto = new CommentDTO();
		dto.setBoardNum(boardNum);
		dto.setCoContent(coContent);
//		dto.setCoWriter(session.getId()); //로그인한 사용자 == 작성자
		
		return commentService.registComment(dto);
	}
}
