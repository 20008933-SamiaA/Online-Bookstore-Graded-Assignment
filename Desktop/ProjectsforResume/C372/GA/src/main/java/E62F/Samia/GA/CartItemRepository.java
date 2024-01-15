/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2022-Jan-24 11:23:36 
 * 
 */

package E62F.Samia.GA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	public List<CartItem> findByMemberId(int id);
	public CartItem findByMemberIdAndItemId(int memberId, int itemId);
	
}
