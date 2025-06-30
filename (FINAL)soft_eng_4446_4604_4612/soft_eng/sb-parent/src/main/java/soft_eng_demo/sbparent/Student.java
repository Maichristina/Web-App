package soft_eng_demo.sbparent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
   
	@ManyToOne
	@JoinColumn(name="id",insertable = false,updatable = false)
    
	private Courses courses;
	
	@Column(name="am")
	private int am;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="semester")
	private int semester;
	
	@Column(name="finalgrade")
	private double finalgrade;
	
	@Column(name="projectgrade")
	private double projectgrade;
	
	@Column(name="examgrade")
	private double examgrade;
	
	
	public Student() {
		
	}
	
	public Student(int id, String firstName, String lastName,int semester,int am,double finalgrade,double projectgrade,double examgrade) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.semester = semester;
		this.am=am;
		this.finalgrade= finalgrade;
		this.projectgrade= projectgrade ;
		this.examgrade= examgrade;

	}

	public double getProjectgrade() {
		return projectgrade;
	}

	public void setProjectgrade(double projectgrade) {
		this.projectgrade = projectgrade;
	}

	public double getExamgrade() {
		return examgrade;
	}

	public void setExamgrade(double examgrade) {
		this.examgrade = examgrade;
	}

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getAm() {
		return am;
	}

	public void setAm(int am) {
		this.am = am;
	}

	public double getFinalgrade() {
		return finalgrade;
	}
	
	public void setFinalgrade(double finalgrade) {
		this.finalgrade = finalgrade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id+", firstName=" + firstName + ", lastName=" + lastName  + ", semester=" + semester  + 
				  "finalgrade="+ finalgrade +  "]";
	}
		
}
