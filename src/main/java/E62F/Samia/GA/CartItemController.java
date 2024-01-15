package E62F.Samia.GA;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartItemController {

	@Autowired
	private CartItemRepository cartItemRepo;

	@Autowired
	private BookRepository bkRepo;

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private OrderItemRepository orderRepo;
	
	 @Autowired
	 private JavaMailSender javaMailSender;

	

	@GetMapping("/cart")
	public String showCart(Model model, Principal principal) {

		// Get currently logged in user
		MemberDetails loggedInMember = (MemberDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInMemberId = loggedInMember.getMember().getId();

		// Get shopping cart items added by this user
		// *Hint: You will need to use the method we added in the CartItemRepository
		List<CartItem> cartItemList = cartItemRepo.findByMemberId(loggedInMemberId);

		// Add the shopping cart items to the model
		model.addAttribute("cartItemList", cartItemList);

		// Calculate the total cost of all items in the shopping cart
		double cartTotal = 0.0;
		for (int i = 0; i < cartItemList.size(); i++) {
			CartItem currentCartItem = cartItemList.get(i);
			cartTotal += currentCartItem.getSubtotal();
		}

		// Add the shopping cart total to the model
		model.addAttribute("cartTotal", cartTotal);
		
		
		//Add loggedInMemberId to model
		model.addAttribute("memberId", loggedInMemberId);
		                               
		return "cart";
	}

	@PostMapping("/cart/add/{itemId}")
	public String addToCart(@PathVariable("itemId") int itemId, @RequestParam("quantity") int quantity,
			Principal principal) {

		// Get currently logged in user
		MemberDetails loggedInMember = (MemberDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		int loggedInMemberId = loggedInMember.getMember().getId();

		// Check in the cartItemRepo if item was previously added by user.
		// *Hint: we will need to write a new method in the CartItemRepository
		CartItem cartItem = cartItemRepo.findByMemberIdAndItemId(loggedInMemberId, itemId);

		// if the item was previously added, then we get the quantity that was
		// previously added and increase that

		if (cartItem != null) {
			int currentQuantity = cartItem.getQuantity();
			cartItem.setQuantity(currentQuantity + quantity);
		} else {

		}

		// if the item was NOT previously added,
		// then prepare the item and member objects
		Books item = bkRepo.getById(itemId);
		Member member = memberRepo.getById(loggedInMemberId);

		// Create a new CartItem object

		CartItem newCartItem = new CartItem();

		// Set the item and member as well as the new quantity in the new CartItem
		// object

		newCartItem.setItem(item);
		newCartItem.setMember(member);
		newCartItem.setQuantity(quantity);

		// Save the new CartItem object to the repository

		cartItemRepo.save(newCartItem);

		return "redirect:/cart";
	}

	@PostMapping("/cart/update/{id}")
	public String updateCart(@PathVariable("id") int cartItemId, @RequestParam("qty") int qty) {

		// Get cartItem object by cartItem's id
		CartItem cartItem = cartItemRepo.getById(cartItemId);

		// Set the quantity of the carItem object retrieved

		cartItem.setQuantity(qty);
		// Save the cartItem back to the cartItemRepo
		cartItemRepo.save(cartItem);

		return "redirect:/cart";
	}

	@GetMapping("/cart/remove/{id}")
	public String removeFromCart(@PathVariable("id") int cartItemId) {

		// Remove item from cartItemRepo
		cartItemRepo.deleteById(cartItemId);

		return "redirect:/cart";
	}

	@PostMapping("/cart/process_order")
	public String processOrder(Model model, @RequestParam("cartTotal") double cartTotal,
			@RequestParam("memberId") int memberId, @RequestParam("orderId") String orderId,
			@RequestParam("transactionId") String transactionId) {

		// Retrieve cart items purchased

		List<CartItem> cartItemList = cartItemRepo.findByMemberId(memberId);

		// Get member object
		Member member = memberRepo.getById(memberId);

		// Loop to iterate through all cart items
		for (int i = 0; i < cartItemList.size(); i++) {

			// Retrieve details about current cart item
			// - Get Current Cart item object
			// - Get quantity of current cart item object
			// - Get actual item ID

			CartItem currentCartItem = cartItemList.get(i);
			int quantityPurchased = currentCartItem.getQuantity();
			Books itemToUpdate = currentCartItem.getItem();
			int itemToUpdateId = itemToUpdate.getId();

			// Update item table
			// - Get Item from item table (Existing inventory)
			// - Get existing item quantity
			// - Update item quantity
			// - Save updated item to itemRepo

			Books inventoryItem = bkRepo.getById(itemToUpdateId);
			int currentInventoryQuantity = inventoryItem.getQuantity();
			inventoryItem.setQuantity(currentInventoryQuantity - quantityPurchased);
			bkRepo.save(inventoryItem);

			// Add item to order table
			// - Create a new OrderItem obj
			// - Set order id, member id,item,member, quantity purchased
			// - Save OrderItem obj to orderRepo

			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(orderId);
			orderItem.setItem(itemToUpdate);
			orderItem.setMember(member);
			orderItem.setQuantity(quantityPurchased);
			orderItem.setTransactionId(transactionId);
			orderRepo.save(orderItem);

			// clear cart items belonging to member
			cartItemRepo.deleteById(currentCartItem.getId());
}
		
		
			// Pass info to view to display success page
		model.addAttribute("cartTotal", cartTotal);
	    model.addAttribute("cartItemList", cartItemList);
	    model.addAttribute("member", member);
	    model.addAttribute("orderId", orderId);
	    model.addAttribute("transactionId", transactionId);
	    
	    
	    
			// Send email
		   // Toggle breakpoint anywhere below here before sendEmail function and run in debug mode
		    String subject = "Booklink order is confirmed!";
		    String body = "Thank you for your order!\n" + "Order ID: " + orderId + "\n" + "Transaction ID: " + transactionId;
		    String to = member.getEmail();
		    sendEmail(to, subject, body);

		    
		    return "success";
		  }
		  public void sendEmail(String to, String subject, String body) {
			   SimpleMailMessage msg = new SimpleMailMessage();
			   msg.setTo(to);
			   msg.setSubject(subject);
			   msg.setText(body);
			   System.out.println("Sending");
			   javaMailSender.send(msg);
			   System.out.println("Sent");
			}



		}