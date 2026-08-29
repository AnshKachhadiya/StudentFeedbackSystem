package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.FeedbackQuestion;
import studentFeedback.StudentFeedbackSystem.repository.FeedbackQuestionRepository;

@Service
public class FeedbackQuestionService {

	@Autowired
	private FeedbackQuestionRepository questionRepository;
	
	// save 
	public FeedbackQuestion saveQuestion(
            FeedbackQuestion question) {

        return questionRepository.save(question);  
    }
	
	// get question by id
	public FeedbackQuestion getQuestionById(Long id) {
		
		return questionRepository.findById(id).
				orElseThrow(() -> 
					new RuntimeException("Question not found")); 
	}
	
	// get all question
	public List<FeedbackQuestion> getAllQuestion(){
		
		return questionRepository.findAll(); 
	}
	
	// get active question
	public List<FeedbackQuestion> getActiveQuestions() {

        return questionRepository
                .findByActiveTrueOrderByDisplayOrderAsc();
    }
	
	// delete question
	public void deleteQuestion(Long id) {

        if (!questionRepository.existsById(id)) {
            throw new RuntimeException("Question not found");
        } 

        questionRepository.deleteById(id);
    }
	
}
