package soft_eng_demo.sbparent;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private int id ;
	
	@OneToMany(mappedBy="courses")
	private Set<Student> student = new HashSet<>();
	
	@Column(name="semester")
	private int semester;


	@Column(name="name")
	private String name;
	
	@Column(name="syllabus")
	private String syllabus;
	
	
	@Column(name="professor")
	private String professor;
	
	
	//constructor
	public Courses() {
		
	}
	
	public Courses(int id,int semester , String name ,String syllabus, String professor) {
		this.id = id;
		this.semester = semester;
		this.name= name;
		this.syllabus = syllabus;
		this.professor=professor;
	}


	public Courses(int id, String name) {
		this.id = id ;
		this.name = name;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Student [id="  +id + ", semester=" + semester + ", Name=" + name + "syllabus "+ syllabus + ", professor =" + professor  +"]";
	}
		
}

