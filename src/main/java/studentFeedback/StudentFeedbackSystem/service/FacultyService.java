package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.Department;
import studentFeedback.StudentFeedbackSystem.entity.Faculty;
import studentFeedback.StudentFeedbackSystem.entity.User;
import studentFeedback.StudentFeedbackSystem.repository.DepartmentRepository;
import studentFeedback.StudentFeedbackSystem.repository.FacultyRepository;
import studentFeedback.StudentFeedbackSystem.repository.UserRepository;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	// create and update
	public Faculty saveFaculty(Faculty faculty) {

	    User user = userRepository.findById(faculty.getUser().getId())
	            .orElseThrow(() ->
	                    new RuntimeException("User not found"));

	    Department department = departmentRepository
	            .findById(faculty.getDepartment().getId())
	            .orElseThrow(() ->
	                    new RuntimeException("Department not found"));

	    faculty.setUser(user);
	    faculty.setDepartment(department);

	    return facultyRepository.save(faculty);
	}
	
	// get by id faculty
	public Faculty getFacultyById(Long id) {
		 
		return facultyRepository.findById(id).
				orElseThrow(()-> new RuntimeException("faculty does not found"));
	}
	
	// get all faculty
	public List<Faculty> getAllFaculties(){
		
		return facultyRepository.findAll(); 
	} 

	// get faculty by userid
	public Faculty getFacultyByUserId(Long userId) {

        return facultyRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Faculty not found"));
    }
	
	// delete faculty by id
	public void deleteFaculty(Long id) {
		
		if(!facultyRepository.existsById(id)) {
			throw new RuntimeException("faculty not found");
		}
		
		facultyRepository.deleteById(id);
	}
	
}
