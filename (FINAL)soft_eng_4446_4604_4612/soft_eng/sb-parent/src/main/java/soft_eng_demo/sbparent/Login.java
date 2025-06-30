package soft_eng_demo.sbparent;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")

public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pword")
	private int pword;
	
	@Column(name="username")
	private String username;
	
	public Login() {
		
		
	}
	
	public Login (int pword,String username) {
		this.pword = pword ;
		this.username=username;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username ;
	}
	
	public int getPword() {
		return pword;
	}
	public void setPword(int pword) {
		this.pword = pword ;
	}
	
	@Override
	public String toString() {
		return "Instructor [username=" + username + ", password=" + pword + "]";
	}
	

}