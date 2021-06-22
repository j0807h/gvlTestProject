package sp.jh.example.testProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import sp.jh.example.testProject.domain.BoardDTO;

@Repository
@Component("sp.jh.example.testProject.mapper.BoardMapper")
public interface BoardMapper {

	public Integer registBoard(BoardDTO dto);

	public Integer getCode();
	public Integer count();

	public List<BoardDTO> getBoardList(BoardDTO dto);

	public Integer getCount();


}
