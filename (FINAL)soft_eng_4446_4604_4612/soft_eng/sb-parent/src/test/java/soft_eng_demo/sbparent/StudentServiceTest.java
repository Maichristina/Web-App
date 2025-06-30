package soft_eng_demo.sbparent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.DisplayName;


@DisplayName("JUnit&Mockito tests for Student Service class")
@SpringBootTest
@TestPropertySource(
		  locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class StudentServiceTest {

	@Autowired
	StudentService studentService;	
	
	@MockBean
	StudentDAO mockStudent;
	
	@Test
	void test_addingStudent() {
        Student testStudent = new Student();
        testStudent.setFirstName("Joe");
        studentService.save(testStudent);
        Assertions.assertNotNull(testStudent);
        Assertions.assertNotNull(testStudent.getFirstName());
        assertEquals("Joe", testStudent.getFirstName());
	} 
	
	@Test
	void testFindByIdReturnsStudent() {
			Mockito.when(mockStudent.findById(12)).thenReturn(new Student(12,"Joe", "Tester",10,12,9.0,7.0,10.0));
			Student storedStudent = mockStudent.findById(12);
			Assertions.assertNotNull(storedStudent);
			Assertions.assertEquals("Joe", storedStudent.getFirstName());
	}
	
}
