package sp.jh.example.testProject.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sp.jh.example.testProject.command.CommentCommand;
import sp.jh.example.testProject.domain.CommentDTO;
import sp.jh.example.testProject.mapper.CommentMapper;

@Service
@Component
public class CommentDelService {

	@Autowired
	CommentMapper commentMapper;
	
	public int commentDelete(int coNum) throws Exception {
		return commentMapper.commentDelete(coNum);
	}

}
