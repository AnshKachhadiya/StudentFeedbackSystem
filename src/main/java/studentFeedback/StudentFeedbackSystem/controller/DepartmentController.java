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

import lombok.extern.slf4j.Slf4j;
import studentFeedback.StudentFeedbackSystem.entity.Department;
import studentFeedback.StudentFeedbackSystem.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@Slf4j
public class DepartmentController { 

	@Autowired
	private DepartmentService departmentService;
	
	// here is the post means push method for department
	
	@PostMapping("/create") 
    public ResponseEntity<?> createDepartment(
            @RequestBody Department department) {

        try {
 
            Department savedDepartment =
                    departmentService.saveDepartment(department);

            return new ResponseEntity<>(
                    savedDepartment,
                    HttpStatus.CREATED
            );

        } catch (RuntimeException e) { 

        
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
            
        }
    }
	
	// now we make get all
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartment() {

        try {

            List<Department> departments =
                    departmentService.getAllDepartment();

            return ResponseEntity.ok(departments);

        } catch (RuntimeException e) { 

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
	
	// now we make get by id
	
	@GetMapping("/{id}") 
	public ResponseEntity<?> getDepartmentById(
            @PathVariable Long id) {

        try {

            Department department =
                    departmentService.getDepartmentById(id);

            return ResponseEntity.ok(department);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } 
    } 
	
	// now we make put mapping
	@PutMapping("/id/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable Long id,
			@RequestBody Department department){
		
		try {
			
			Department existingDepartment = 
					departmentService.getDepartmentById(id); 
			
			existingDepartment.setName(department.getName());
	        existingDepartment.setCode(department.getCode());
			
			Department updatedDepartment = departmentService
					.saveDepartment(existingDepartment);
			
			return ResponseEntity.ok(updatedDepartment); 
			
		} catch(RuntimeException e) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage()); 
		}	
	}
	
	
	// now we make delete api
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
		
		try {
			
			departmentService.deleteDepartment(id);
			
			return ResponseEntity.ok("department deleted successfully.."); 
		} catch(RuntimeException e) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage()); 
			
		}
	}	
	
}
