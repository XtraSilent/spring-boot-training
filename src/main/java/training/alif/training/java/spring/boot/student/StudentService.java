package training.alif.training.java.spring.boot.student;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
    
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents(){
		return studentRepository.findAll();
	}

	public void addStudent(Student student) {
		Optional<Student> studentByEmail =  studentRepository.findByStudentEmail(student.getEmail());

		if(studentByEmail.isPresent()){
			throw new IllegalStateException("Email taken");
		}

		studentRepository.save(student);
	}
}
