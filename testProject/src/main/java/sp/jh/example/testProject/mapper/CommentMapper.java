package sp.jh.example.testProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import sp.jh.example.testProject.command.CommentCommand;
import sp.jh.example.testProject.domain.CommentDTO;

@Repository
@Component("sp.jh.example.testProject.mapper.CommentMapper")
public interface CommentMapper {
	//댓글 등록
	public int insertComment(CommentDTO dto) throws Exception;
	
	//댓글 번호 생성
	public int getCoNum()throws Exception;

	//해당 게시글 댓글 리스트 가져오기
	public List<CommentDTO> getCommentList(CommentDTO dto) throws Exception;

}
