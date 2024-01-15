/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2021-Nov-29 02:01:03 
 * 
 */

package E62F.Samia.GA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * @author 20008933
 *
 */
@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotEmpty(message = "Book name cannot be empty!")
	@Size(min = 1, max = 100, message = "Book Title length must be 1 and 100 characters!")
	private String name;

	private String bkseries;

	@NotNull
	@NotEmpty(message = "Book Type cannot be empty!")
	@Size(min = 8, max = 50, message = "Book Type length must be 8 and 50 characters!")
	private String bktype;

	@NotNull
	@DecimalMin(value = "1.00", message = "Book Price must be positive numerical values")
	private double price;

	@NotNull
	@PositiveOrZero(message = "Quantity only accept positive whole numbers!")
	private int quantity;

	@NotNull
	@NotEmpty(message = "Author's name cannot be empty!")
	@Size(min = 5, max = 100, message = "Author's Name length must be 5 and 100 characters!")
	private String author;

	@NotNull
	@NotEmpty(message = "Genre cannot be empty!")
	@Size(min = 5, max = 100, message = "Genre's length must be 5 and 100 characters!")
	private String genre;

	@NotNull
	@NotEmpty(message = "Description cannot be empty!")
	@Size(min = 5, max = 5000, message = "Description length must be 5 and 5000 characters!")
	private String descriptions;

	private String imgName;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBkseries() {
		return bkseries;
	}

	public void setBkseries(String bkseries) {
		this.bkseries = bkseries;
	}

	public String getBktype() {
		return bktype;
	}

	public void setBktype(String bktype) {
		this.bktype = bktype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

}
