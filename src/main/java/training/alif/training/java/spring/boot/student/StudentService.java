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

	public void deleteStudent(Long studentId) {

		boolean exist = studentRepository.existsById(studentId);
		if (!exist) {
			throw new IllegalStateException("Student id " + studentId +  " does not exist");
		}
		
		studentRepository.deleteById(studentId);
	}

    public void updateStudent(Long studentId, Student student) {
		
		Student studentData = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException(
			"Student ID does not exist"
		));
		
		studentData.setDob(student.getDob());
		studentData.setEmail(student.getEmail());
		studentData.setName(student.getName());

		studentRepository.save(studentData);

	}
}
