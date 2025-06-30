package soft_eng_demo.sbparent;

import java.util.List;

public interface LoginService {
	
	public static List<Login> findAll() {

		return null;
	}
	
	public static Login findByString(String username) {

		return null;
	}
	public Login findById(int pword);
	
	public static void save(Login Logins) {
		
	}

	static void deleteById(String username) {
		// TODO Auto-generated method stub
		
	}

}