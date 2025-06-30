package soft_eng_demo.sbparent;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRep LoginRepository;
	
	@Autowired
	public LoginServiceImpl(LoginRep theLoginRepository) {
		LoginRepository = theLoginRepository;
	}
	
	public LoginServiceImpl() {

	}

	@Transactional
	public List<Login> findAll() {
		return LoginRepository.findAll();
	}

	@Transactional
	public Login findById(int pword) {
		Login result = LoginRepository.findById(pword);
				
		if (result != null ) {
			return result;
		}
		else {
			throw new RuntimeException("Did not find employee id - " + pword);
		}
	}

	@Transactional
	public void save(Login Logins) {
		LoginRepository.save(Logins);
	}

	@Transactional
	public void deleteById(int pword) {
		LoginRepository.deleteById(pword);
	}

	public Login findByString(String username) {
		return null;
	}

}