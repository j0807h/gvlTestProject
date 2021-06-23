package sp.jh.example.testProject.domain;

public class StartEndPageDTO {
	Long startPage;
	Long endPage;
	public StartEndPageDTO(Long startPage, Long endPage) {
		super();
		this.startPage = startPage-1;
		this.endPage = endPage;
	}
	public Long getStartPage() {
		return startPage;
	}
	public Long getEndPage() {
		return endPage;
	}
}