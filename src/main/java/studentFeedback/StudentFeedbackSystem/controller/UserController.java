package studentFeedback.StudentFeedbackSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studentFeedback.StudentFeedbackSystem.entity.User;
import studentFeedback.StudentFeedbackSystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	// now we make an post
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user){
		
		try {
			
			User savedUser = userService.saveUser(user);
			
			return new ResponseEntity<>(
					savedUser, HttpStatus.CREATED);   
			
		} catch(RuntimeException e) {
			
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());  
		}
	}
	
	// get all users
	
	@GetMapping("/getall") 
	public ResponseEntity<?> getAllUsers(){
		
		try {
			
			List<User> users = userService.getAllUsers();
			
			return ResponseEntity.ok(users);
			
		} catch(RuntimeException e) { 
			
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());   
		}
	}
	
	
	// get user by id
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id){
		
		try {
			
			User users = userService.getUserById(id);
			
			return ResponseEntity.ok(users);  
			
		} catch(RuntimeException e) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage()); 
		}
	}
	
	// get user by username
	
	@GetMapping("/username/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username){
		
		try {
			
			User users = userService.getUserByUsername(username);
			
			return ResponseEntity.ok(users);
			
		} catch(RuntimeException e) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage()); 
		}	
	}
	
	// udate the user by id
	
	@PutMapping("/id/{id}") 
	public ResponseEntity<?> updateUser(@PathVariable Long id,
			@RequestBody User user){
		
		try {
			
			User existingUser = userService.getUserById(id);
			
			existingUser.setUsername(user.getUsername());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			existingUser.setRole(user.getRole());
			
			User updateUser = userService.saveUser(existingUser);
			
			return ResponseEntity.ok(updateUser); 
			
		} catch(RuntimeException e) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
		
	}
	
	// now make delete user
	
	@DeleteMapping("/id/{id}") 
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		
		try {
			
			userService.deleteUser(id);
			
			return ResponseEntity.ok("user deleted sucessfully"); 
			
		} catch(RuntimeException e) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage()); 
		}
	}
}
