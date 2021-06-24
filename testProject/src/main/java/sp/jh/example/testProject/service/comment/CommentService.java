package sp.jh.example.testProject.service.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sp.jh.example.testProject.command.CommentCommand;
import sp.jh.example.testProject.domain.AuthInfo;
import sp.jh.example.testProject.domain.CommentDTO;
import sp.jh.example.testProject.mapper.CommentMapper;

@Service
@Component
public class CommentService {
	
	@Autowired
	CommentMapper commentMapper;
	
	public int registComment(CommentDTO dto, CommentCommand commentCommand, HttpServletRequest request ) throws Exception {
		
		//댓글 번호 생성
		Integer coNum = commentMapper.getCoNum();
		dto.setCoNum(coNum);
		
		// 로그인 == 댓글작성자
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
//		dto.setCoWriter(authInfo.getId());
		dto.setCoWriter("wjdghk");
		
		dto.setBoardNum(commentCommand.getBoardNum());
		dto.setCoContent(commentCommand.getCoContent());
		
		
		return commentMapper.insertComment(dto);
	}

}
