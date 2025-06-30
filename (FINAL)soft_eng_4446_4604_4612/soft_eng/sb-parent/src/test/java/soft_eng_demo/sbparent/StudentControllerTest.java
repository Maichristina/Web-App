package soft_eng_demo.sbparent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("JUnit&Mockito tests Student Controller class")
@SpringBootTest
@TestPropertySource(
  locations = "classpath:application.properties")
@AutoConfigureMockMvc
public class StudentControllerTest {
	
	@Autowired
    private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	StudentController studentController;

	@BeforeEach
    public void setup() {
		mockMvc = MockMvcBuilders
          .webAppContextSetup(context)
          .build();
    }
	
	@Test
	void testStudentControllerIsNotNull() {
		Assertions.assertNotNull(studentController);
	}
	
	@Test
	void testMockMvcIsNotNull() {
		Assertions.assertNotNull(mockMvc);
	}
	
	
	@WithMockUser(value = "user1")
	@Test 
	void testListStudentsReturnsPage() throws Exception {
		
		mockMvc.perform(get("/student/list")).
		andExpect(status().isOk()).
		andExpect(view().name("student"));		
	}
	
	@WithMockUser(value = "user1")
	@Test 
	void testSaveStudentReturnsPage() throws Exception {
	    Student testStudent = new Student(14,"Joe2", "Tester2",10,12,9.0,7.0,10.0);
	    	    
	    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
	    multiValueMap.add("id", Integer.toString(testStudent.getId()));
	    multiValueMap.add("first name", testStudent.getFirstName());
	    multiValueMap.add("last name", testStudent.getLastName());
	    multiValueMap.add("semester",Integer.toString(testStudent.getSemester()));
	    multiValueMap.add("final grade",Double.toString(testStudent.getFinalgrade()));
	    multiValueMap.add("project grade",Double.toString(testStudent.getProjectgrade()));
	    multiValueMap.add("exam grade",Double.toString(testStudent.getExamgrade()));
	    
		mockMvc.perform(
				post("/student/save")
			    .params(multiValueMap))
				.andExpect(status().isFound())
				.andExpect(view().name("redirect:/student/list"));
						
	}
}
