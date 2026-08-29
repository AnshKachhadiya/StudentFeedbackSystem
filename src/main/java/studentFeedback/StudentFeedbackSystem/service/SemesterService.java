package studentFeedback.StudentFeedbackSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentFeedback.StudentFeedbackSystem.entity.Semester;
import studentFeedback.StudentFeedbackSystem.repository.SemesterRepository;

@Service
public class SemesterService {

	@Autowired
	private SemesterRepository semesterRepository;
	
	// create and update
	public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }
	
	// get semester by id
	public Semester getSemesterById(long id) {
		 
		return semesterRepository.findById(id).
				orElseThrow(() -> new RuntimeException("semester is not found"));
	}

	// get all semester
	public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }
	
	// get semster by number
	public List<Semester> getBySemesterNumber(Integer number) {
        return semesterRepository.findBySemesterNumber(number);
    }
	
	// delete semester
	public void deleteSemester(Long id) {

        if (!semesterRepository.existsById(id)) {
            throw new RuntimeException("Semester not found");
        }

        semesterRepository.deleteById(id);
    }
}
	
	
	
