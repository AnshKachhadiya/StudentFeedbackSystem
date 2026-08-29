package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.Subject;
import studentFeedback.StudentFeedbackSystem.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    // Create Subject
    public Subject saveSubject(Subject subject) {

        if (subjectRepository.existsBySubjectCode(
                subject.getSubjectCode())) {

            throw new RuntimeException( 
                    "Subject code already exists");
        }

        return subjectRepository.save(subject);
    }

    // Get Subject by ID
    public Subject getSubjectById(Long id) {

        return subjectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Subject not found"));
    }

    // Get All Subjects
    public List<Subject> getAllSubject() {

        return subjectRepository.findAll();
    }

    // Get Subjects by Department
    public List<Subject> getSubjectByDepartment(Long departmentId) {

        return subjectRepository.findByDepartmentId(departmentId);
    }

    // Get Subjects by Faculty
    public List<Subject> getSubjectByFaculty(Long facultyId) {

        return subjectRepository.findByFacultyId(facultyId);
    }

    // Delete Subject
    public void deleteSubject(Long id) {

        if (!subjectRepository.existsById(id)) {

            throw new RuntimeException("Subject not found");
        }

        subjectRepository.deleteById(id);
    }
}