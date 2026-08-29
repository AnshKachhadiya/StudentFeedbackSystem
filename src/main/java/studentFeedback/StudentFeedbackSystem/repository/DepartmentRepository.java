package studentFeedback.StudentFeedbackSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentFeedback.StudentFeedbackSystem.entity.Department;
 
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	boolean existsBycode(String code);

}
 