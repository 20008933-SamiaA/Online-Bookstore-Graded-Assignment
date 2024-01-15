/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2021-Oct-25 14:24:58 
 * 
 */

package E62F.Samia.GA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

	@Autowired
	private BookRepository bkRepo;

	@Autowired
	private CategoryRepository catRepo;

	@GetMapping("/books")
	public String viewBooks(Model model) {

		// Retrieve all categories from database
		List<Books> bkList = bkRepo.findAll();

		// Add the categories to the model
		model.addAttribute("listBooks", bkList);

		// return the response as a view
		return "view_books";

	}

	@GetMapping("/books/add")
	public String addBook(Model model) {
		model.addAttribute("books", new Books());

		List<Category> catList = catRepo.findAll();
		model.addAttribute("catList", catList);

		return "add_books";

	}

	@PostMapping("/books/save")
	public String saveBook(@Valid Books book, BindingResult bindingResult,
			@RequestParam("bookImage") MultipartFile imgFile) {

		if (bindingResult.hasErrors()) {
			return "add_books";
		}

		String imageName = imgFile.getOriginalFilename();

		// Set the image name in item object
		book.setImgName(imageName);

		// Save the item obj to the db
		Books savedBook = bkRepo.save(book);

		try {
			// Preparing the directory path
			String uploadDir = "uploads/books/" + savedBook.getId();
			Path uploadPath = Paths.get(uploadDir);
			System.out.println("Directory path: " + uploadPath);

			// Checking if the upload path exists, if not it will be created.
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}

			// Prepare path for file
			Path fileToCreatePath = uploadPath.resolve(imageName);
			System.out.println("File path: " + fileToCreatePath);

			// Copy file to the upload location
			Files.copy(imgFile.getInputStream(), fileToCreatePath, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException io) {
			io.printStackTrace();
		}

		return "redirect:/books";
	}

	@GetMapping("/books/edit/{id}")
	public String editItem(@PathVariable("id") Integer id, Model model) {

		Books books = bkRepo.getById(id);

		model.addAttribute("books", books);
		List<Category> catList = catRepo.findAll();
		model.addAttribute("catList", catList);

		return "edit_books";

	}

	@PostMapping("/books/edit/{id}")
	public String saveUpdateditem(@PathVariable("id") Integer id, Books books,
			@RequestParam("bookImage") MultipartFile imgFile) {

		// if imgFile is NOT empty, proceed to:
		// set new image name for item object, save the item object, upload new file and
		// update db
		// otherwise, this means no new file was uploaded, simply save the item object

		if (!imgFile.isEmpty()) {
			String imageName = imgFile.getOriginalFilename();
			System.out.println("Image name from imgFile: " + imageName);

			// Set the image name in item object
			books.setImgName(imageName);

			Books savedItem = bkRepo.save(books);

			try {
				// Preparing the directory path
				String uploadDir = "uploads/books/" + savedItem.getId();
				Path uploadPath = Paths.get(uploadDir);
				System.out.println("Directory path: " + uploadPath);

				// Checking if the upload path exists, if not it will be created.
				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				// Prepare path for file
				Path fileToCreatePath = uploadPath.resolve(imageName);
				System.out.println("File path: " + fileToCreatePath);

				// Copy file to the upload location
				Files.copy(imgFile.getInputStream(), fileToCreatePath, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException io) {
				io.printStackTrace();
			}
		} else // No edit to image, save the item object as passed.
		{
			System.out.println("Image name from item object: " + books.getImgName());
			bkRepo.save(books);
		}

		return "redirect:/books";
	}

	@GetMapping("/books/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id) {
		bkRepo.deleteById(id);
		return "redirect:/books";
	}

	@GetMapping("/books/{id}")
	public String viewProduct(@PathVariable("id") Integer id, Model model) {
		Books books = bkRepo.getById(id);
		model.addAttribute("books", books);
		return "view_Product";
	}

	@GetMapping(path = "/books/category/{id}")
	public String getItemsbyCategory(@PathVariable Integer id, Model model) {

		List<Books> listBooks = bkRepo.findByCategory_Id(id);

		model.addAttribute("listBooks", listBooks);
		return "view_books";
	}

}