package sp.jh.example.testProject.service.board;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import sp.jh.example.testProject.command.BoardCommand;
import sp.jh.example.testProject.domain.AuthInfo;
import sp.jh.example.testProject.domain.BoardDTO;
import sp.jh.example.testProject.mapper.BoardMapper;

@Service
@Component
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	public void registBoard(BoardCommand boardCommand, BindingResult result, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		// 게시글 번호 생성
		Integer boardNum = boardMapper.getCode(); 

		//조회수
//		Integer count = boardMapper.count(); 
		
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardNum(boardNum);
		System.out.println(boardNum);
		dto.setBoardWriter(boardCommand.getBoardWriter());
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setUserId(authInfo.getId());
//		dto.setBoardCount(boardCommand.getboardC));
		// 등록할 때 사용한 ip주소  
		dto.setIpAddr(request.getRemoteAddr());
		
		// 파일 저장
		String path = "WEB-INF/view/board/upload";
		// "WEB-INF/view/goodsView/upload"까지의 절대 경로 
		String filePath = session.getServletContext().getRealPath(path);
		System.out.println(filePath);
		///이미지 파일명을 저장하기 위한 변수
		String boardFile = "";
		if(boardCommand.getBoardFile() != null) {
			for(MultipartFile mf : boardCommand.getBoardFile()) {
				//브라우저에서 전송될 때 사용했던 이름.
				String original = mf.getOriginalFilename();
				// 확장자만 가져오기 (.hwp , .txt, .doc)
				String originalFileExtension = 
						original.substring(original.lastIndexOf("."));
				// UUID로 임의의 값 가져오기
				String store = //임의의 값에 확장자를 붙이기
						UUID.randomUUID().toString().replace("-", "")
						+originalFileExtension;
				// 반복문이 실행이 될 때 store 에 있는 값이 goodsImage에 추가
				boardFile += store+"`";
				// store파일 객체 생성
				File file = new File(filePath + "\\" + store);
				// store파일 저장
				try {
					mf.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// dto에 디비에 저장할 파일명 저장
		dto.setBoardFile(boardFile);
		
		
		
		Integer i = boardMapper.registBoard(dto);
		if(i > 0) {
			System.out.println(i + "개가 등록되었습니다.");
		}
	}

}
