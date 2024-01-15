package E62F.Samia.GA;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/403")
	public String error403() {
		return "403";
	}

	@GetMapping("/index2")
	public String home2() {
		return "index2";
	}
}