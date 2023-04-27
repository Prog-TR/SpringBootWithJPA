package ca.sheridancollege.ranati.bootstrapdata;

import java.util.ArrayList;
import java.util.Arrays;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.ranati.beans.Course;
import ca.sheridancollege.ranati.beans.Professor;
import ca.sheridancollege.ranati.beans.Student;
import ca.sheridancollege.ranati.repositories.CourseRepository;
import ca.sheridancollege.ranati.repositories.ProfessorRepository;
import ca.sheridancollege.ranati.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private StudentRepository sRepo;
	private CourseRepository cRepo;
	private ProfessorRepository pRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Professor p1 = Professor.builder().professorName("Johnny").coursesList(new ArrayList<Course>()).build();
		Professor p2 = Professor.builder().professorName("Alex").coursesList(new ArrayList<Course>()).build();
		Professor p3 = Professor.builder().professorName("Samantha").coursesList(new ArrayList<Course>()).build();
		
		 pRepo.saveAll(Arrays.asList(p1, p2, p3));
		
		Course c1 = Course.builder().courseName("Computer Science").courseCode("CS111").professor(p1).students(new ArrayList<Student>()).build();
		Course c2 = Course.builder().courseName("Software Engineering").courseCode("SE234").professor(p1).students(new ArrayList<Student>()).build();
		Course c3 = Course.builder().courseName("Communication Networks").courseCode("CN555").professor(p2).students(new ArrayList<Student>()).build();
		Course c4 = Course.builder().courseName("Software Design").courseCode("SD699").professor(p2).students(new ArrayList<Student>()).build();
		Course c5 = Course.builder().courseName("Database Systems").courseCode("DS772").professor(p3).students(new ArrayList<Student>()).build();
		Course c6 = Course.builder().courseName("Data Structres And Algorithms").courseCode("DS437").professor(p3).students(new ArrayList<Student>()).build();
		
		cRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
		Student s1 = Student.builder().firstName("Billy").lastName("Bob").coursesList(new ArrayList<Course>()).build();
		Student s2 = Student.builder().firstName("Manit").lastName("Sharma").coursesList(new ArrayList<Course>()).build();
		Student s3 = Student.builder().firstName("Narayan").lastName("Billa").coursesList(new ArrayList<Course>()).build();
		Student s4 = Student.builder().firstName("Rachit").lastName("Vyas").coursesList(new ArrayList<Course>()).build();
		Student s5 = Student.builder().firstName("Margi").lastName("Patel").coursesList(new ArrayList<Course>()).build();
		Student s6 = Student.builder().firstName("Tirth").lastName("Rana").coursesList(new ArrayList<Course>()).build();
		Student s7 = Student.builder().firstName("Darsh").lastName("Rana").coursesList(new ArrayList<Course>()).build();
		Student s8 = Student.builder().firstName("Charvi").lastName("Rana").coursesList(new ArrayList<Course>()).build();
		Student s9 = Student.builder().firstName("Somil").lastName("Arora").coursesList(new ArrayList<Course>()).build();
		Student s10 = Student.builder().firstName("Saurav").lastName("Sharma").coursesList(new ArrayList<Course>()).build();
		Student s11 = Student.builder().firstName("Noah").lastName("Schnapp").coursesList(new ArrayList<Course>()).build();
		Student s12 = Student.builder().firstName("Millie").lastName("Howie").coursesList(new ArrayList<Course>()).build();
		Student s13 = Student.builder().firstName("Krysh").lastName("Chatterjeelal").coursesList(new ArrayList<Course>()).build();
		Student s14 = Student.builder().firstName("Tachy").lastName("Trash").coursesList(new ArrayList<Course>()).build();
		Student s15 = Student.builder().firstName("Crash").lastName("Patil").coursesList(new ArrayList<Course>()).build();
		Student s16 = Student.builder().firstName("Taylor").lastName("Swift").coursesList(new ArrayList<Course>()).build();
		Student s17 = Student.builder().firstName("Ansh").lastName("Malhotra").coursesList(new ArrayList<Course>()).build();
		Student s18 = Student.builder().firstName("Fuzzy").lastName("Wuzzy").coursesList(new ArrayList<Course>()).build();
		Student s19 = Student.builder().firstName("Chester").lastName("Chez").coursesList(new ArrayList<Course>()).build();
		Student s20 = Student.builder().firstName("Kanye").lastName("West").coursesList(new ArrayList<Course>()).build();
		Student s21 = Student.builder().firstName("Martin").lastName("Garrix").coursesList(new ArrayList<Course>()).build();
		Student s22 = Student.builder().firstName("David").lastName("Guetta").coursesList(new ArrayList<Course>()).build();
		Student s23 = Student.builder().firstName("Justin").lastName("Trudeau").coursesList(new ArrayList<Course>()).build();
		Student s24 = Student.builder().firstName("Haley").lastName("Beiber").coursesList(new ArrayList<Course>()).build();
		Student s25 = Student.builder().firstName("Spider").lastName("Man").coursesList(new ArrayList<Course>()).build();
		Student s26 = Student.builder().firstName("James").lastName("Sunderland").coursesList(new ArrayList<Course>()).build();
		Student s27 = Student.builder().firstName("Mary").lastName("Sunderland").coursesList(new ArrayList<Course>()).build();
		Student s28 = Student.builder().firstName("Prisha").lastName("Vora").coursesList(new ArrayList<Course>()).build();
		Student s29 = Student.builder().firstName("Will").lastName("Turner").coursesList(new ArrayList<Course>()).build();
		Student s30 = Student.builder().firstName("Captain").lastName("Slow").coursesList(new ArrayList<Course>()).build();
		
		
	
		s1.getCoursesList().add(c1);
		s1.getCoursesList().add(c2);
		s3.getCoursesList().add(c3);
		s3.getCoursesList().add(c2);
		s3.getCoursesList().add(c6);
		s4.getCoursesList().add(c4);
		s5.getCoursesList().add(c3);
		s5.getCoursesList().add(c5);
		s6.getCoursesList().add(c6);
		s6.getCoursesList().add(c2);
		s7.getCoursesList().add(c1);
		s7.getCoursesList().add(c4);
		s8.getCoursesList().add(c2);
		s9.getCoursesList().add(c3);
		s10.getCoursesList().add(c4);
		s10.getCoursesList().add(c6);
		s10.getCoursesList().add(c3);	
		s12.getCoursesList().add(c6);
		s12.getCoursesList().add(c3);
		s13.getCoursesList().add(c1);
		s13.getCoursesList().add(c5);
		s13.getCoursesList().add(c3);
		s14.getCoursesList().add(c1);
		s14.getCoursesList().add(c2);
		s14.getCoursesList().add(c3);
		s14.getCoursesList().add(c6);
		s17.getCoursesList().add(c4);
		s18.getCoursesList().add(c6);
		s19.getCoursesList().add(c1);
		s19.getCoursesList().add(c4);
		s19.getCoursesList().add(c2);
		s20.getCoursesList().add(c5);
		s20.getCoursesList().add(c1);
		s21.getCoursesList().add(c3);
		s22.getCoursesList().add(c3);
		s22.getCoursesList().add(c6);
		s23.getCoursesList().add(c5);
		s24.getCoursesList().add(c6);
		s24.getCoursesList().add(c1);
		s24.getCoursesList().add(c4);
		s25.getCoursesList().add(c1);
		s26.getCoursesList().add(c2);
		s27.getCoursesList().add(c3);
		s28.getCoursesList().add(c4);
		s29.getCoursesList().add(c5);
		sRepo.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10,
				s11, s12, s13, s14, s15, s16, s17, s18, s19, s20,
				s21, s22, s23, s24, s25, s26, s27, s28, s29, s30));
	
		
		c1.getStudents().add(s1);
		c2.getStudents().add(s2);
		c3.getStudents().add(s3);
		c4.getStudents().add(s4);
		c5.getStudents().add(s5);
		c6.getStudents().add(s6);
		c1.getStudents().add(s7);
		c2.getStudents().add(s8);
		c3.getStudents().add(s9);
		c4.getStudents().add(s10);
		c5.getStudents().add(s11);
		c6.getStudents().add(s12);
		c1.getStudents().add(s13);
		c2.getStudents().add(s14);
		c3.getStudents().add(s15);
		c4.getStudents().add(s16);
		c5.getStudents().add(s17);
		c6.getStudents().add(s18);
		c1.getStudents().add(s19);
		c2.getStudents().add(s20);
		c3.getStudents().add(s21);
		c4.getStudents().add(s22);
		c5.getStudents().add(s23);
		c6.getStudents().add(s24);
		c1.getStudents().add(s25);
		c2.getStudents().add(s26);
		c3.getStudents().add(s27);
		c4.getStudents().add(s28);
		c5.getStudents().add(s29);
		c6.getStudents().add(s30);
		
		cRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
	}

}
