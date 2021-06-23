package sp.jh.example.testProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sp.jh.example.testProject.domain.AuthInfo;

@Controller
public class MainController {
	
//	AuthInfo authInfo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(HttpSession session, Model model) {
//		if((AuthInfo) session.getAttribute("authInfo") != null ){
//			//로그인 되있으면
//			model.addAttribute("name", authInfo.getName());
//		}
		return "main";
	}
}
