package sp.jh.example.testProject.command;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignUpCommand {
	@NotEmpty
	@Size(min = 5, max = 127, message = "아이디를 입력하여 주세요.")
	String userId;
	@NotEmpty
	@NotEmpty(message = "비밀번호를 입력하여 주세요.")
	String userPw;
	String userPwCon;
	String name;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	가입시 비밀번호 일치여부
	public boolean isEqualPw() {
		return userPw.equals(userPwCon) ? true : false;
	}
}
