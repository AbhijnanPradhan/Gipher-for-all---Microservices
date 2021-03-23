package loginregister.service;



import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import loginregister.model.User;
import loginregister.repository.UserRepository;



@Service
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder encoder;

	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	@Transactional
	public boolean registerUser(User user) {
		try {
			String encodedPassword = encoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			if (userRepository.findById(user.getUserId()).isPresent())
				return false;
			else {
				System.out.println("failed");
				userRepository.save(user);
				return true;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean updateuser(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	@Transactional
	public User getUserById(String userId) {
		try {
			return userRepository.findById(userId).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Transactional
	public boolean deleteUser(String userId) {
		try {
			if (!userRepository.findById(userId).isPresent())
				return false;
			else {
				userRepository.deleteById(userId);
				return true;
			}
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

}
