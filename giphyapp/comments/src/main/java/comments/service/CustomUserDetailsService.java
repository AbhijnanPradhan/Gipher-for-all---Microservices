package comments.service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import comments.repository.UserRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> roles = null;

		Optional<comments.model.User> userOptional =userRepository.findById(username);

		if (userOptional.isPresent()) {
			comments.model.User user = userOptional.get();
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new User(user.getUserId(), user.getPassword(), roles);
		} else
			return null;
	}
}
