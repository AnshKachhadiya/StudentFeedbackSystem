package studentFeedback.StudentFeedbackSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import studentFeedback.StudentFeedbackSystem.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	List<Feedback> findByStudentId(Long studentId);

    List<Feedback> findByFacultyId(Long facultyId);

    List<Feedback> findBySubjectId(Long subjectId); 

    boolean existsByStudentIdAndSubjectIdAndFacultyId(
            Long studentId,
            Long subjectId,
            Long facultyId 
    );
}
