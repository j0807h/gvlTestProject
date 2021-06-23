package sp.jh.example.testProject.service.board;

import org.springframework.ui.Model;

public class PageAction { //페이징 모듈화 하기 위한 클래스
	public void page(Model model, int count, int limit, int page, int limitPage, String pageUrl) {
		int maxPage = (int)(((double)count/limit) + 0.95); 
	
		int startPage = (int)(((double)page / limitPage + 0.95) -1) * limitPage + 1;
		int endPage =startPage + limitPage -1;
		if(endPage > maxPage)  endPage = maxPage;
		
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", page);
		model.addAttribute("pageUrl", pageUrl);
	}
}

