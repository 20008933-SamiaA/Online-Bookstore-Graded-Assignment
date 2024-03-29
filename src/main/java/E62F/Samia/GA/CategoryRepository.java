package E62F.Samia.GA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	public Category findByName(String name);

}
