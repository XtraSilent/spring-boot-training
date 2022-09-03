package training.alif.training.java.spring.boot.student;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents(){
		return List.of(new Student(1L,"alif",LocalDate.of(1996,Month.AUGUST,13),26,"alif@example.com"));
	}
}
