package studentFeedback.StudentFeedbackSystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import studentFeedback.StudentFeedbackSystem.entity.Feedback;
import studentFeedback.StudentFeedbackSystem.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Transactional
    public Feedback submitFeedback(Feedback feedback) {

        Long studentId = feedback.getStudent().getId();
        Long subjectId = feedback.getSubject().getId();
        Long facultyId = feedback.getFaculty().getId(); 

        // Prevent duplicate feedback
        if (feedbackRepository
                .existsByStudentIdAndSubjectIdAndFacultyId(
                        studentId,
                        subjectId,
                        facultyId)) {

            throw new RuntimeException(
                    "Feedback already submitted for this subject and faculty");
        }
        
        // Set submission time automatically
        feedback.setSubmittedAt(LocalDateTime.now());

        // Anonymous feedback by default
        if (feedback.getAnonymous() == null) {
            feedback.setAnonymous(true);
        }

        return feedbackRepository.save(feedback);
    }
	
	public Feedback getFeedbackById(Long id) {

        return feedbackRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Feedback not found"));
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public List<Feedback> getFeedbackByStudent(Long studentId) {
        return feedbackRepository.findByStudentId(studentId);
    }

    public List<Feedback> getFeedbackByFaculty(Long facultyId) {
        return feedbackRepository.findByFacultyId(facultyId);
    }

    public List<Feedback> getFeedbackBySubject(Long subjectId) {
        return feedbackRepository.findBySubjectId(subjectId);
    }

    public void deleteFeedback(Long id) {

        if (!feedbackRepository.existsById(id)) {
            throw new RuntimeException("Feedback not found");
        }

        feedbackRepository.deleteById(id);
    }

} 
