package studentFeedback.StudentFeedbackSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import studentFeedback.StudentFeedbackSystem.entity.FeedbackAnswer;

public interface FeedbackAnswerRepository extends JpaRepository<FeedbackAnswer, Long> {


    List<FeedbackAnswer> findByFeedbackId(Long feedbackId);
 
    List<FeedbackAnswer> findByQuestionId(Long questionId);
}
