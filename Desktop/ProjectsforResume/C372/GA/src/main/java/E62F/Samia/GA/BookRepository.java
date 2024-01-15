/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2021-Nov-29 02:10:05 
 * 
 */

package E62F.Samia.GA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;





/**
 * @author 20008933
 *
 */
public interface BookRepository extends JpaRepository<Books, Integer> {

	/**
	 * @param id
	 * @return
	 */
	public List<Books> findByCategory_Id(int id);

}
