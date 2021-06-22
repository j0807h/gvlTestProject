package sp.jh.example.testProject.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import sp.jh.example.testProject.domain.AuthInfo;
import sp.jh.example.testProject.domain.BoardDTO;
import sp.jh.example.testProject.domain.StartEndPageDTO;
import sp.jh.example.testProject.mapper.BoardMapper;

@Service
@Component
public class BoardListService {

	@Autowired
	BoardMapper boardMapper;
	
	public void getList(Integer page, Model model) {
		//페이징
		int limit = 10; //한 페이지에 나오게 할 리스트
		int limitPage = 10; //마지막 리스트 번호
		Long StartRow = ((long)page - 1) * limit + 1; //시작 행 1, 11, 21, 31, ...
		Long endRow = (long)page * limit;
		
		BoardDTO dto = new BoardDTO();
		dto.setStartEndPageDTO(new StartEndPageDTO(StartRow, endRow));
		/* libDTO에서 모듈화 시킨 StartEndPageDTO에 값을 넣을 때
		 * 
		 * StartEndPageDTO오는 StartEndPageDTO형태로 값을 넣어야 하기 때문에
		 * 
		 * 새로운 StartEndPageDTO를 만들어서 매개변수를 넣어줌.
		 * 
		 *  --> libDTO.setStartEndPageDTO(new StartEndPageDTO(StartRow, endRow));
		 *  */
		System.out.println("StartEndPageDTO : " + dto.getStartEndPageDTO().getStartPage()); /* 위에서 StartRow, endRow를 넣은 값을 set했기 때문에 그걸 가져옴 */
		
		dto.setBoardNum(boardMapper.getCode());
		List<BoardDTO> list= boardMapper.getBoardList(dto);
		Integer count = boardMapper.getCount();
		
		model.addAttribute("lists", list);
		model.addAttribute("count", count);
		
		//페이징
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, page, limitPage, "libBoard?");
		
		
	}

}
