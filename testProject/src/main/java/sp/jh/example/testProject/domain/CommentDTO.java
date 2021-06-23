package sp.jh.example.testProject.domain;

public class CommentDTO {
	private Integer boardNum;
	private Integer coNum;
	private String coContent;
	private String coWriter;
	private String coReg;
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public Integer getCoNum() {
		return coNum;
	}
	public void setCoNum(Integer coNum) {
		this.coNum = coNum;
	}
	public String getCoContent() {
		return coContent;
	}
	public void setCoContent(String coContent) {
		this.coContent = coContent;
	}
	public String getCoWriter() {
		return coWriter;
	}
	public void setCoWriter(String coWriter) {
		this.coWriter = coWriter;
	}
	public String getCoReg() {
		return coReg;
	}
	public void setCoReg(String coReg) {
		this.coReg = coReg;
	}
	
	
}
