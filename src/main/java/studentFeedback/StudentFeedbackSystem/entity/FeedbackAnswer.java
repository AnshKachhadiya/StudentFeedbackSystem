package studentFeedback.StudentFeedbackSystem.entity;

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
@Table(name = "feedback_answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackAnswer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feedback_id", nullable = false)
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private FeedbackQuestion question;

    @Column(nullable = false)
    private Integer rating;

    @Column(length = 1000)
    private String comment;

	public Integer getRating() { 
		// TODO Auto-generated method stub
		return null;
	}
	
}
