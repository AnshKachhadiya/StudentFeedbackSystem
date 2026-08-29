package studentFeedback.StudentFeedbackSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import studentFeedback.StudentFeedbackSystem.entity.FeedbackQuestion;

public interface FeedbackQuestionRepository extends JpaRepository<FeedbackQuestion, Long> {

	List<FeedbackQuestion> findByActiveTrueOrderByDisplayOrderAsc();
}
 