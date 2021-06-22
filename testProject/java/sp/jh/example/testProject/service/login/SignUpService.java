package sp.jh.example.testProject.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import sp.jh.example.testProject.command.SignUpCommand;
import sp.jh.example.testProject.domain.LoginDTO;
import sp.jh.example.testProject.mapper.LoginMapper;

@Service
@Component
public class SignUpService {

	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public String registUser(SignUpCommand signUpCommand, Model model) throws Exception {
		String path ="";
		if(!signUpCommand.isEqualPw()) {
			model.addAttribute("notEqual", "비밀번호가 일치하지 않습니다.");
			return "login/signUp";
		}
		
		LoginDTO dto = new LoginDTO();
		dto.setUserId(signUpCommand.getUserId());
		String Pw = bCryptPasswordEncoder.encode(signUpCommand.getUserPw());
		dto.setUserPw(Pw);
		dto.setName(signUpCommand.getName());
		Integer user = loginMapper.registUsers(dto);
		
		path = (user > 0 ) ? "redirect:/" : "login/signUp";
		return path;
		
	}

}
