package soft_eng_demo.sbparent;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LoginRep extends JpaRepository<Login, Integer> {
	
	public Login findById(int pword);
		
}