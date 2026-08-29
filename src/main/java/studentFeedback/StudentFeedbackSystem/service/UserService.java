package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.User;
import studentFeedback.StudentFeedbackSystem.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// create or update user
	public User saveUser(User user) {
		return userRepository.save(user);
	}  
	
	// Get user by Id
	public User getUserById(Long id) {
		return userRepository.findById(id). 
				orElseThrow(() -> new RuntimeException("User Not Found"));
	}
	
	// get all users
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	// Delete user
	public void deleteUser(Long id) {
		if(!userRepository.existsById(id)) {
			throw new RuntimeException("User not found while delete the user");
		} else {
			userRepository.deleteById(id); 
		}
	}
	
	//Find user by Username
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username).
				orElseThrow(() -> new RuntimeException("User not found while find by username"));
	}
}
