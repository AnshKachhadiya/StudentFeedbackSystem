package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.Department;
import studentFeedback.StudentFeedbackSystem.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository; 
	
	// create and update 
	public Department saveDepartment(Department department) {
		  
		if (departmentRepository.existsBycode(department.getCode())) {
			
            throw new RuntimeException("Department code already exists");
        } else {
        	
        		return departmentRepository.save(department);
        }
	}
	
	// get department by id
	public Department getDepartmentById(Long id) {
		
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found while get by id"));
    }
	
	//get all departments
	public List<Department> getAllDepartment(){
		
		return departmentRepository.findAll(); 
	} 
	
	//delete department by id
	 public void deleteDepartment(Long id) {

	        if (!departmentRepository.existsById(id)) {
	            throw new RuntimeException("Department not found while delete the department");
	        }

	        departmentRepository.deleteById(id);
	    }
}
