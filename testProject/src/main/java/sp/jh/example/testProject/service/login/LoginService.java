package sp.jh.example.testProject.service.login;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import sp.jh.example.testProject.command.LoginCommand;
import sp.jh.example.testProject.domain.AuthInfo;
import sp.jh.example.testProject.domain.LoginDTO;
import sp.jh.example.testProject.mapper.LoginMapper;

@Component
@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	AuthInfo authInfo;

	public String login(LoginCommand loginCommand, HttpSession session, Model model) throws Exception {
		String location = "";
		LoginDTO dto = new LoginDTO();
		dto.setUserId(loginCommand.getUserId());
		dto = loginMapper.getUsers(dto);
		
		//관리자
		if(loginCommand.getUserId() == "admin") { 
			if(loginCommand.getUserPw() == "admin") {
				location = "main";
			}
		}
		
		
		
		if(dto == null) {
			model.addAttribute("valid_userId", "아이디가 존재하지 않습니다.");
		} else if(passwordEncoder.matches(loginCommand.getUserPw(), dto.getUserPw())) {
			// 비밀번호가 일치하면
			authInfo = new AuthInfo(dto.getUserId(), dto.getName());
			session.setAttribute("authInfo", authInfo);
			model.addAttribute("name", authInfo.getName());
			location = "main";
		} else {
			// 비밀번호 틀림
//			System.out.println("비밀번호 틀림");
			model.addAttribute("valid_userPw", "비밀번호가 다릅니다.");
			location = "login/login";
		}
		
		
		
//		List<LoginDTO> list = loginMapper.getUsers(dto); //여기서 dto에 userId 저장해서 넘김
//		System.out.println(loginMapper.getUsers(dto));
//		System.out.println("list id : " + list.get(0).getUserId());
//
//		System.out.println("크기 : " + list.size());
//		if(list.size() == 0) {
//			// 사용자 없음
//			model.addAttribute("valid_userId", "아이디가 존재하지 않습니다.");
//			location =  "login/login";
//		} else if(passwordEncoder.matches(loginCommand.getUserPw(), list.get(0).getUserPw())) {
//			// 비밀번호가 일치하면
//			authInfo = new AuthInfo(list.get(0).getUserId(), list.get(0).getName());
//			session.setAttribute("authInfo", authInfo);
//			location = "redirect:/";
//		} else {
//			// 비밀번호 틀림
////			System.out.println("비밀번호 틀림");
//			model.addAttribute("valid_userPw", "비밀번호가 다릅니다.");
//			location = "login/login";
//		}
		return location;
//		return "redirect:/";
	}

}

