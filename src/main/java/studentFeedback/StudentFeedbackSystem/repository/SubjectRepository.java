package studentFeedback.StudentFeedbackSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import studentFeedback.StudentFeedbackSystem.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

	Optional<Subject> findBySubjectCode(String subjectCode);

    List<Subject> findByDepartmentId(Long departmentId);

    List<Subject> findByFacultyId(Long facultyId);
 
    boolean existsBySubjectCode(String subjectCode);
}
 