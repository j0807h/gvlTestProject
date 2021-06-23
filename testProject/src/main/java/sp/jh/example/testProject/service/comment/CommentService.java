package sp.jh.example.testProject.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sp.jh.example.testProject.domain.CommentDTO;
import sp.jh.example.testProject.mapper.CommentMapper;

@Service
@Component
public class CommentService {
	
	@Autowired
	CommentMapper commentMapper;
	
	public int registComment(CommentDTO dto) throws Exception {
		return commentMapper.insertComment(dto);
	}

}
