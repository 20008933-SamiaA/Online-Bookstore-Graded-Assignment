/**
 * 
 * I declare that this code was written by me, 20008933. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Samia Afrin
 * Student ID: 20008933
 * Class: E62F
 * Date created: 2022-Jan-10 11:49:55 
 * 
 */

package E62F.Samia.GA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



/**
 * @author 20008933
 *
 */
public class MemberDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public MemberDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		Member member = memberRepository.findByUsername(username);
		
		if(member == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		
		return new MemberDetails(member);
	}
}
