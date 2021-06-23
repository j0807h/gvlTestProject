package sp.jh.example.testProject.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import sp.jh.example.testProject.command.BoardCommand;
import sp.jh.example.testProject.domain.BoardDTO;
import sp.jh.example.testProject.mapper.BoardMapper;

@Service
@Component
public class BoardDetailService {

	@Autowired
	BoardMapper boardMapper;
	
	public void boardDetail(String boardNum, Model model, BoardCommand boardCommand) throws Exception {
		BoardDTO dto = new BoardDTO();
		dto.setBoardNum(Integer.parseInt(boardNum));
		
		//조회수 증가
		boardMapper.updateCount(boardNum);
//		dto.setBoardCount(count);
//		model.addAttribute("BOARDCOUNT", COUNT);
//		SYSTEM.OUT.PRINTLN(count);
		
		List<BoardDTO> list = boardMapper.getBoardDetail(dto);
		model.addAttribute("list",list);
		
	}

}
