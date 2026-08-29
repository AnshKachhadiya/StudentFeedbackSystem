package studentFeedback.StudentFeedbackSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedback_questions")
@Data
@NoArgsConstructor
@AllArgsConstructor 
public class FeedbackQuestion {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @Column(nullable = false, unique = true)
	  private String questionText;
	  
	  @Column(nullable = false)
	  private boolean active = true;
	  
	  @Column(nullable = false)
	  private Integer displayOrder;
	
}
