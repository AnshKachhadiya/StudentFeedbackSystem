package studentFeedback.StudentFeedbackSystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedbacks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    @Column(nullable = false)
    private Boolean anonymous = true;

	public void setSubmittedAt(LocalDateTime now) { 
		// TODO Auto-generated method stub
		
	}

	public Boolean getAnonymous() {
	    return anonymous;
	}

	public void setAnonymous(Boolean anonymous) {
	    this.anonymous = anonymous;
	}

	public Student getStudent() {
		// TODO Auto-generated method stub
		return student; 
	}

	public Subject getSubject() {
		// TODO Auto-generated method stub
		return subject; 
	}
	
	public Faculty getFaculty() {
		return faculty; 
	}
 
	
}