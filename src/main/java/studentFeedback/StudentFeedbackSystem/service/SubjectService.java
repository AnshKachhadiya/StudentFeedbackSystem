package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.Department;
import studentFeedback.StudentFeedbackSystem.entity.Faculty;
import studentFeedback.StudentFeedbackSystem.entity.Subject;
import studentFeedback.StudentFeedbackSystem.repository.DepartmentRepository;
import studentFeedback.StudentFeedbackSystem.repository.FacultyRepository;
import studentFeedback.StudentFeedbackSystem.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyRepository facultyRepository;


    // Create Subject
    public Subject saveSubject(Subject subject) {

        if (subjectRepository.existsBySubjectCode(
                subject.getSubjectCode())) {

            throw new RuntimeException(
                    "Subject code already exists");
        }

        Department department =
                departmentRepository.findById(
                        subject.getDepartment().getId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Department not found"));

        Faculty faculty =
                facultyRepository.findById(
                        subject.getFaculty().getId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Faculty not found"));

        subject.setDepartment(department);
        subject.setFaculty(faculty);

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