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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import studentFeedback.StudentFeedbackSystem.entity.Department;
import studentFeedback.StudentFeedbackSystem.entity.Faculty;
import studentFeedback.StudentFeedbackSystem.service.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	// now we create a post api
	@PostMapping("/create")
	public ResponseEntity<?> createFaculty(
			@RequestBody Faculty faculty){
		
		try { 
			
			Faculty savedFaculty =  
					facultyService.saveFaculty(faculty);
			
			return new ResponseEntity<>(
					savedFaculty, HttpStatus.CREATED); 
			
		} catch(RuntimeException e) { 
			
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage()); 
		}
	}
	
	
	// here we make get all faculties
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllFaculties(){
		
		try {
			
			List<Faculty> faculties = facultyService.getAllFaculties();
			
			return ResponseEntity.ok(faculties); 
			
		} catch(RuntimeException e) {
			
			return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	 
	
	
	// now we create a get faculty by id
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFacultyById(@PathVariable Long id){
		
		try { 
			
			Faculty faculty = facultyService.getFacultyById(id);
			
			return ResponseEntity.ok(faculty); 
			
			
		} catch(RuntimeException e) {
			
			return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);  
		}	
	}
	
	// get faculty by userId
	
	 @GetMapping("/user/{userId}")
	 public ResponseEntity<?> getFacultyByUserId(@PathVariable Long userId) {

	     try {

	         Faculty faculty = facultyService.getFacultyByUserId(userId);

	         return ResponseEntity.ok(faculty);

	     } catch (Exception e) {

	         return new ResponseEntity<>(
	                    e.getMessage(), 
	                    HttpStatus.NOT_FOUND);
	     }
	 }
	 
	 // now we make putmapping
	 @PutMapping("/id/{id}")
	 public ResponseEntity<?> updateFaculty(@PathVariable Long id,
			 @RequestBody Faculty faculty){
		 
		 try { 
			 
			 Faculty existingFaculty = facultyService.getFacultyById(id);
			  
			 existingFaculty.setFullName(faculty.getFullName());
			 existingFaculty.setPhone(faculty.getPhone());
			 existingFaculty.setDesignation(faculty.getDesignation());
			 existingFaculty.setEmployeeId(faculty.getEmployeeId());
			   
			 Faculty updateFaculty = facultyService 
						.saveFaculty(existingFaculty); 
			 
			 return ResponseEntity.ok(updateFaculty); 
			 
		 } catch(RuntimeException e) {
			 
			 return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND); 
		 }
		 
	 }
	 
	 // now we make delete 
	 @DeleteMapping("/id/{id}") 
	 public ResponseEntity<?> deleteFaculty(@PathVariable Long id){
		 
		 try {
			 
			 facultyService.deleteFaculty(id);
			 
			 return ResponseEntity.ok("faculty deleted sucessfully...."); 
			 
		 } catch(RuntimeException e) {
			 return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND); 
		 }
	 }
}
