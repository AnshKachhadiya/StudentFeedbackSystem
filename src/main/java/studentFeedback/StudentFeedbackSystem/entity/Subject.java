
package studentFeedback.StudentFeedbackSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String subjectName;

    @Column(nullable = false, unique = true)
    private String subjectCode;

    private Integer credits;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;


    // No Argument Constructor
    public Subject() {
    }


    // All Argument Constructor
    public Subject(Long id,
                   String subjectName,
                   String subjectCode,
                   Integer credits,
                   Department department,
                   Faculty faculty) {

        this.id = id;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.credits = credits;
        this.department = department;
        this.faculty = faculty;
    }


    // Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // Getter and Setter for Subject Name
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


    // Getter and Setter for Subject Code
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }


    // Getter and Setter for Credits
    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }


    // Getter and Setter for Department
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    // Getter and Setter for Faculty
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}

