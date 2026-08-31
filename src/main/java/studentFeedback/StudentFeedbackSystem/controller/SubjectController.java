
package studentFeedback.StudentFeedbackSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studentFeedback.StudentFeedbackSystem.entity.Subject;
import studentFeedback.StudentFeedbackSystem.service.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    // Create a subject
    @PostMapping("/create")
    public ResponseEntity<?> createSubject(
            @RequestBody Subject subject) {

        try {

            Subject savedSubject =
                    subjectService.saveSubject(subject);

            return new ResponseEntity<>(
                    savedSubject,
                    HttpStatus.CREATED);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    // Get all subjects
    @GetMapping("/getall")
    public ResponseEntity<?> getAllSubject() {

        try {

            List<Subject> subjects =
                    subjectService.getAllSubject();

            return ResponseEntity.ok(subjects);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }


    // Get subject by ID
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getSubjectById(
            @PathVariable Long id) {

        try {

            Subject subject =
                    subjectService.getSubjectById(id);

            return ResponseEntity.ok(subject);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


    // Get subject by department
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<?> getSubjectByDepartmentId(
            @PathVariable Long departmentId) {

        try {

            List<Subject> subjects =
                    subjectService.getSubjectByDepartment(departmentId);

            return ResponseEntity.ok(subjects);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


    // Get subject by faculty
    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<?> getSubjectByFacultyId(
            @PathVariable Long facultyId) {

        try {

            List<Subject> subjects =
                    subjectService.getSubjectByFaculty(facultyId);

            return ResponseEntity.ok(subjects);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


    // Update subject by ID
    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateSubjectById(
            @PathVariable Long id,
            @RequestBody Subject subject) {

        try {

            Subject existingSubject =
                    subjectService.getSubjectById(id);

            existingSubject.setSubjectName(subject.getSubjectName());

            existingSubject.setSubjectCode(subject.getSubjectCode());

            existingSubject.setCredits(subject.getCredits());

            existingSubject.setDepartment(subject.getDepartment());

            existingSubject.setFaculty(subject.getFaculty()); 

            Subject updatedSubject =
                    subjectService.saveSubject(existingSubject);

            return ResponseEntity.ok(updatedSubject);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


    // Delete subject
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteSubject(
            @PathVariable Long id) {

        try {

            subjectService.deleteSubject(id);

            return ResponseEntity.ok(
                    "Subject deleted successfully....");

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}

