package studentFeedback.StudentFeedbackSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import studentFeedback.StudentFeedbackSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Optional<Student> findByEnrollmentNumber(String enrollmentNumber);
	 
	Optional<Student> findByUserId(Long userId);
	
	boolean existsByEnrollmentNumber(String enrollmentNumber);

}
