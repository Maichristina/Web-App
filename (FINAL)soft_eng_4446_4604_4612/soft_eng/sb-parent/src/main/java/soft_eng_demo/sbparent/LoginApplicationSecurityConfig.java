package soft_eng_demo.sbparent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserDetails user1 = User.withUsername("user1")
			     .password("$2a$12$v8lL4pyK0JZfW8KQGZPSvusu2Km.XSuF8Cfsz6QKJGKk8nWjJyJsq")
			     .roles("Login")
			     .build();
		
		UserDetails user2 = User.withUsername("user2")
			     .password("$2a$12$FwltdVeMiC3MtsFdQ4OseejNwccZc.flobGqSoZV315QU2a2waoFe")
			     .roles("Login")
			     .build();
		
		UserDetails user3 = User.withUsername("user3")
			     .password("$2a$12$k7nw/wBQSwyBoyHQvEQ/F.HRGAOmAq5x4UGm6tEcGs4f.MlbyHKy.")
			     .roles("Login")
			     .build();
		
		UserDetails user4 = User.withUsername("user4")
			     .password("$2a$12$nm1vE2/O4918zjuBw1hKcOodECfNJyGCc8zRZYgygdldPgqsDpD6S")
			     .roles("Login")
			     .build();
		
		
		UserDetails user5 = User.withUsername("user5")
			     .password("$2a$12$ilt2.6tHXVRWoK0Iv3NA7OR.QZ3qChEJJxUF0X./Oc0SPK2Z/ZW4.")
			     .roles("Login")
			     .build();
		
		auth.inMemoryAuthentication().withUser(user1).withUser(user2).withUser(user3).withUser(user4).withUser(user5);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}