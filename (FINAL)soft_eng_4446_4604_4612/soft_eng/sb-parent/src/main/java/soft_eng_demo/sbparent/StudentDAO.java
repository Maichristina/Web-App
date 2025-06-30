package soft_eng_demo.sbparent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	public Student findById(int theId);

	public void deleteById(int id);
		
}