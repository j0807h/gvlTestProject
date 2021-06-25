package sp.jh.example.testProject.service.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import sp.jh.example.testProject.command.CommentCommand;
import sp.jh.example.testProject.domain.CommentDTO;
import sp.jh.example.testProject.mapper.CommentMapper;

@Service
@Component
public class CommentListService {

	@Autowired
	CommentMapper commentMapper;

	public List<CommentDTO> getCommentList() throws Exception {
		return commentMapper.getCommentList();
	}
	
//	public ResponseEntity<String> registComment(CommentCommand commentCommand, HttpServletRequest request) throws Exception {
//		HttpHeaders responseHeaders = new HttpHeaders();
//		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
//		
//        // 해당 게시물 댓글
//		CommentDTO dto = new CommentDTO();
//		dto.setBoardNum(commentCommand.getBoardNum());
//        List<CommentDTO> list = commentMapper.getCommentList(dto);
////        System.out.println(list.get(0).getCoContent());
//        
//        if(list.size() > 0){
//            for(int i=0; i<list.size(); i++){
//                HashMap<String, String> hm = new HashMap<String, String>();
//                hm.put("coNum", String.valueOf(list.get(i).getCoNum()));
//                hm.put("coContent", list.get(i).getCoContent());
//                hm.put("coWriter", list.get(i).getCoWriter());
//                
//                hmlist.add(hm);
//            System.out.println(i + " list : " + list.get(i).getCoContent());
//            }
//            
//        }
//        
//        JSONArray json = new JSONArray(hmlist);       
//        ResponseEntity<String> resp = new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.CREATED);
//        return resp;
//	}

}
