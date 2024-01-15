/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2021-Nov-29 01:50:33 
 * 
 */

package E62F.Samia.GA;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository catRepo;

	@GetMapping("/categories")
	public String viewCategories(Model model) {

		// Retrieve all categories from database
		List<Category> catList = catRepo.findAll();

		// Add the categories to the model
		model.addAttribute("listCategories", catList);

		// return the response as a view
		return "view_categories";

	}
	
	

	

	// add
		@GetMapping("/categories/add")
		public String addCategory(Model model) {
			model.addAttribute("category", new Category());
			return "add_category";
		}

		@PostMapping("/categories/save")
		public String saveCategory(@Valid Category category, BindingResult bindingResult) {
			
			if(bindingResult.hasErrors()) {
				return "add_category";
			}
			
			
			catRepo.save(category);
			return "redirect:/categories";
		}


		// edit

		@GetMapping("/categories/edit/{id}")
		public String editCategory(@PathVariable("id") Integer id, Model model) {

			Category category = catRepo.getById(id);
			model.addAttribute("category", category);

			return "edit_category";
		}

		@PostMapping("/categories/edit/{id}")
		public String saveUpdatedCategory(@PathVariable("id") Integer id, Category category) {

			catRepo.save(category);
			return "redirect:/categories";
		}


		// delete

		@GetMapping("/categories/delete/{id}")
		public String deleteCategory(@PathVariable("id") Integer id) {

			catRepo.deleteById(id);
		

			return "redirect:/categories";
		}

	}
