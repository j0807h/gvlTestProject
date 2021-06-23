package sp.jh.example.testProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import sp.jh.example.testProject.domain.BoardDTO;

@Repository
@Component("sp.jh.example.testProject.mapper.BoardMapper")
public interface BoardMapper {

	public Integer registBoard(BoardDTO dto) throws Exception;

	public Integer getCode() throws Exception;
//	public Integer count() throws Exception;
	public Integer updateCount(String boardNum) throws Exception;

	public List<BoardDTO> getBoardList(BoardDTO dto) throws Exception;

	public Integer getCount() throws Exception;

	public List<BoardDTO> getBoardDetail(BoardDTO dto) throws Exception;


}
