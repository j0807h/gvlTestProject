package sp.jh.example.testProject.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import sp.jh.example.testProject.domain.CommentDTO;

@Repository
@Component("sp.jh.example.testProject.mapper.CommentMapper")
public interface CommentMapper {
	//댓글 등록
	public int insertComment(CommentDTO dto) throws Exception;

}
