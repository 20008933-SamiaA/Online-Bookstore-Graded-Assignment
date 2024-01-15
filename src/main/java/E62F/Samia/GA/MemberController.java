/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2022-Jan-03 13:38:55 
 * 
 */

package E62F.Samia.GA;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 * @author 20008933
 *
 */
@Controller
public class MemberController {
	
		@Autowired
		private MemberRepository memRepo;

		@GetMapping("/members")
		public String viewMembers(Model model) {

			List<Member> listMembers = memRepo.findAll();
			model.addAttribute("listMembers", listMembers);
			return "view_members";

		}
		
		// add
		@GetMapping("/members/add")
		public String addMember(Model model) {
			model.addAttribute("member", new Member());
			return "add_member";
		}

		@PostMapping("/members/save")
		public String saveMember(Member member, RedirectAttributes redirectAttribute) {
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(member.getPassword());
			
			member.setPassword(encodedPassword);
			member.setRole("ROLE_USER");
		
			memRepo.save(member);
			
			redirectAttribute.addFlashAttribute("success", "Member registered!");
			return "redirect:/members";
		}
		
		
		// edit

		@GetMapping("/members/edit/{id}")
		public String editMember(@PathVariable("id") Integer id, Model model) {

			Member member = memRepo.getById(id);
			model.addAttribute("member", member);

			return "edit_member";
		}

		@PostMapping("/members/edit/{id}")
		public String saveUpdatedMember(@PathVariable("id") Integer id, Member member, RedirectAttributes redirectAttribute) {

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(member.getPassword());
			
			member.setPassword(encodedPassword);
			member.setRole("ROLE_USER");
		
			memRepo.save(member);
			
			redirectAttribute.addFlashAttribute("success", "Member Updated!");
			return "redirect:/members";
		}
		
		
		// delete

		@GetMapping("/members/delete/{id}")
		public String deleteCategory(@PathVariable("id") Integer id) {

			memRepo.deleteById(id);
		

			return "redirect:/members";
		}

	}
