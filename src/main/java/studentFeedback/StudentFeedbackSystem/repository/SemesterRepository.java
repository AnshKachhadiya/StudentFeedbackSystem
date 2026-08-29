package studentFeedback.StudentFeedbackSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import studentFeedback.StudentFeedbackSystem.entity.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

	List<Semester> findBySemesterNumber(Integer semesterNumber); 
}
  