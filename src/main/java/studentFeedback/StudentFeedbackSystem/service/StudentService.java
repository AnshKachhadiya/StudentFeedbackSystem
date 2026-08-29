package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.Student;
import studentFeedback.StudentFeedbackSystem.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	 
	// create and update
	public Student saveStudent(Student student) {
		
		if(studentRepository.existsByEnrollmentNumber(student.getEnrollmentNumber())) {
			
			throw new RuntimeException("Enrollment number is already exists.");
		}
		
		return studentRepository.save(student);
	}
	
	// get student by id
	public Student getById(Long id) {
		
		return studentRepository.findById(id).
				orElseThrow(()-> new RuntimeException("student is not found by id"));
	} 
	
	// get all students
	public List<Student> getAllStudent(){
		return studentRepository.findAll(); 
	}
	
	// delete student by id
	public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }

        studentRepository.deleteById(id);
    }
	
}
