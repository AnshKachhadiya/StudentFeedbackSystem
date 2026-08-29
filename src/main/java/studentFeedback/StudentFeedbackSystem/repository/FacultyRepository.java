package studentFeedback.StudentFeedbackSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import studentFeedback.StudentFeedbackSystem.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

	Optional<Faculty> findByEmployeeId(String employeeId);
	
	Optional<Faculty> findByUserId(Long userId);
	
	boolean existsByEmployeeId(String employeeId);
} 
