/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2022-Jan-24 11:13:49 
 * 
 */

package E62F.Samia.GA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;




/**
 * @author 20008933
 *
 */

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Books item;
	
	private int quantity;
	
	@Transient
	private double subtotal;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Books getItem() {
		return item;
	}
	public void setItem(Books item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity; //Quantity in shopping cart not inventory
	}
	
	public double getSubtotal() {
		return Math.round((quantity * item.getPrice()) * 100.00)/100.00;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
