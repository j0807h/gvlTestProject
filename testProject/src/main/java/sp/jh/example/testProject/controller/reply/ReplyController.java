package sp.jh.example.testProject.controller.reply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="boardDetail")
public class ReplyController {
	
	@RequestMapping(value="registReply", method = RequestMethod.POST)
	public void registReply() {
//		return "redirect:../boardList";
	}
}
