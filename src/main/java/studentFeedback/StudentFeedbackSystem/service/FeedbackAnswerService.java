package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.FeedbackAnswer;
import studentFeedback.StudentFeedbackSystem.repository.FeedbackAnswerRepository;

@Service
public class FeedbackAnswerService {

	@Autowired
	private FeedbackAnswerRepository feedbackAnswerRepository;
	
	// save answer
	public FeedbackAnswer saveAnswer(FeedbackAnswer answer) {
		
		validateRating(answer.getRating());
		
		return feedbackAnswerRepository.save(answer); 
	} 
	
	// get answer by feedback
	public List<FeedbackAnswer> getAnswerByFeedback(Long feedbackId){
		
		return feedbackAnswerRepository
                .findByFeedbackId(feedbackId);  
	}
	
	// get answer by question
	public List<FeedbackAnswer> getAnswerByQuestion(Long questionId){
		
		return feedbackAnswerRepository.
				findByQuestionId(questionId); 
	}
	
	// get answer by id
	public FeedbackAnswer getAnswerById(Long id) {
		
		return feedbackAnswerRepository.findById(id).
				orElseThrow(() -> 
				new RuntimeException("answer is not found")); 
	}
	
	// delete answer
	public void deleteAnswer(Long id) {

        if (!feedbackAnswerRepository.existsById(id)) {
            throw new RuntimeException(
                    "Feedback answer not found");
        }

        feedbackAnswerRepository.deleteById(id);
    }
	
	// validate rating 
	private void validateRating(Integer rating) {

        if (rating == null || rating < 1 || rating > 5) {

            throw new IllegalArgumentException(
                    "Rating must be between 1 and 5");
        }
    }
}
