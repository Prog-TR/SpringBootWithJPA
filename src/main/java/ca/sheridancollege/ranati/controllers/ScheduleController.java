package ca.sheridancollege.ranati.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.ranati.beans.Course;
import ca.sheridancollege.ranati.beans.Professor;
import ca.sheridancollege.ranati.beans.Student;
import ca.sheridancollege.ranati.repositories.CourseRepository;
import ca.sheridancollege.ranati.repositories.ProfessorRepository;
import ca.sheridancollege.ranati.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ScheduleController {
	
	private StudentRepository sRepo;
	private CourseRepository cRepo;
	private ProfessorRepository pRepo;

	@GetMapping("/")
	public String homePage() {

		return "home.html";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		
		model.addAttribute("student", new Student());
		return "addStudent.html";
	}
	
	@PostMapping("/addStudent")
	public String processaddStudent(@ModelAttribute Student student) {
		
		sRepo.save(student);
		return "redirect:/viewStudents";
	}
	
	@GetMapping("/viewStudents")
	public String viewStudents(Model model) {
		
		model.addAttribute("students", sRepo.findAll());
		return "viewStudents.html";
	}
	
	@GetMapping("/viewStudent/{id}")
	public String viewStudent(@PathVariable Long id, Model model) {
		
	Optional<Student> student = sRepo.findById(id);
		
		if(student.isPresent()) {
			Student s = student.get();
			model.addAttribute("student", student.get());
			model.addAttribute("courses", s.getCoursesList());
			return "viewStudent.html";
		}
		else {
			return "redirect:/viewStudents";
			}
	}
	

	@GetMapping("/addProfessor")
	public String addProfessor(Model model) {
		
		model.addAttribute("professor", new Professor());
		return "addProfessor.html";
	}
	
	@PostMapping("/addProfessor")
	public String processaddProfessor(@ModelAttribute Professor professor) {
		
		pRepo.save(professor);
		return "redirect:/viewProfessors";
	}
	
	@GetMapping("/viewProfessors")
	public String viewProfessors(Model model) {
		
		model.addAttribute("professors", pRepo.findAll());
		return "viewProfessors.html";
	}


	@GetMapping("/viewProfessor/{id}")
	public String viewProfessor(@PathVariable Long id, Model model) {
		
		Optional<Professor> professor = pRepo.findById(id);
		
		
		if(professor.isPresent()) {
			Professor p = professor.get();
			
			model.addAttribute("professor", professor.get());
			model.addAttribute("coursesList", p.getCoursesList());
			
			return "viewProfessor.html";
		}
		return "redirect:/viewProfessors";
		
	}
	
	@GetMapping("/addCourse")
	public String addCourse(Model model) {
		
		model.addAttribute("course", new Course());
		return "addCourse.html";
	}
	
	@PostMapping("/addCourse")
	public String processaddCourse(@ModelAttribute Course course) {
		
		cRepo.save(course);
		return "redirect:/viewCourses";
	}

	@GetMapping("/viewCourses")
	public String viewCourses(Model model) {
		
		model.addAttribute("courses", cRepo.findAll());
		return "viewCourses.html";
	}
	
	@GetMapping("/viewCourse/{id}")
	public String viewCourse(@PathVariable Long id, Model model) {
		
		Optional<Course> course = cRepo.findById(id);
		
		if(course.isPresent()) {
			Course c = course.get();
			model.addAttribute("course", course.get());
			model.addAttribute("studentList", c.getStudents());
			
			return "viewCourse.html";
		}
		return "redirect:/viewCourses";	
	}
	
	
	@GetMapping("/assignStudent")
	public String assignStudent(Model model)
	{
	    model.addAttribute("course", new Course());
	    model.addAttribute("students", sRepo.findAll());
	    model.addAttribute("courses", cRepo.findAll());
	    return "assignStudent.html";
	}

	@PostMapping("/assignStudent")
	public String saveStudentAssignment(@RequestParam Long courseId, @RequestParam Long studentId) {
		
	    Course course = cRepo.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Invalid Course ID"));
	    Student student = sRepo.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Invalid Student ID"));
	    
	    course.getStudents().add(student);
	    student.getCoursesList().add(course);
	    
	    cRepo.save(course);
	    sRepo.save(student);
	    
	    return "redirect:/viewStudents";
	}
	
	@GetMapping("/assignProfessor")
	public String assignProfessor(Model model) {
		
	    model.addAttribute("course", new Course());
	    model.addAttribute("professors", pRepo.findAll());
	    model.addAttribute("courses", cRepo.findAll());
	    
	    return "assignProfessor";
	}

	@PostMapping("/assignProfessor")
	public String saveProfessorAssignment(@RequestParam Long courseId, @RequestParam Long professorId) {
		
	    Course course = cRepo.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Invalid Course ID"));
	    Professor professor = pRepo.findById(professorId).orElseThrow(() -> new IllegalArgumentException("Invalid Professor ID"));
	    
	    course.setProfessor(professor);
	   professor.getCoursesList().add(course);
	   
	    cRepo.save(course);
	    pRepo.save(professor);
	    
	    return "redirect:/";
	}
	
	@GetMapping("/dropStudent/{courseId}/{studentId}")
	public String removeStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
		
	    Course course = cRepo.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Invalid Course ID"));
	    Student student = sRepo.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Invalid Student ID"));
	    
	    course.getStudents().remove(student);
	    student.getCoursesList().remove(course);
	    
	    cRepo.save(course);
	    sRepo.save(student);
	    
	    return "redirect:/viewCourse/" + courseId;
	}


}
