package sp.jh.example.testProject.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sp.jh.example.testProject.command.LoginCommand;
import sp.jh.example.testProject.command.SignUpCommand;
import sp.jh.example.testProject.domain.AuthInfo;
import sp.jh.example.testProject.service.login.LoginService;
import sp.jh.example.testProject.service.login.SignUpService;

@Controller
public class LoginController {
	@ModelAttribute
	public LoginCommand setLoginCommand() {
		return new LoginCommand();
	}
	@ModelAttribute
	public SignUpCommand setSignUpCommand() {
		return new SignUpCommand();
	}
	
	@Autowired
	LoginService loginService;
	@Autowired
	SignUpService signUpService;
	AuthInfo authInfo;	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	@RequestMapping(value = "loginAct", method = RequestMethod.POST)
	public String loginAct(@Validated LoginCommand loginCommand, BindingResult result, HttpSession session, Model model) throws Exception {
		if(result.hasErrors()) {
			return "login/login";
		}
		String location = loginService.login(loginCommand, session, model);
		return location;
//		return "redirect:/";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="signUp", method=RequestMethod.GET)
	public String signUp() {
		return "login/signUp";
	}
	@RequestMapping(value="signUpAct", method = RequestMethod.POST)
	public String signUpAct(@Validated SignUpCommand signUpCommand, BindingResult result, Model model) throws Exception {
		if(result.hasErrors()) {
			System.out.println("가입 에러에러");
			return "redirect:signUp";
		}
		String path = signUpService.registUser(signUpCommand, model);
		return path;
	}
}

	
