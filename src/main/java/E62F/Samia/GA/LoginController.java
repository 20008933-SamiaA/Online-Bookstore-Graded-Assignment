/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2022-Jan-10 23:42:44 
 * 
 */

package E62F.Samia.GA;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 20008933
 *
 */
@Controller
public class LoginController {

	@GetMapping("/login")
	
	public String login() {
		
		return "login";
	}
	
	
	
	
	
	
}
