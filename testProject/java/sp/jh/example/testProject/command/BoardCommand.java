package sp.jh.example.testProject.command;

import org.springframework.web.multipart.MultipartFile;

public class BoardCommand {
	Integer boardNum;
	String boardWriter;
	String boardSubject;
	String boardContent;
	MultipartFile [] boardFile;
	
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public MultipartFile[] getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile[] boardFile) {
		this.boardFile = boardFile;
	}
	
}
