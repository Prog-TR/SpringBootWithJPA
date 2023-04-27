package ca.sheridancollege.ranati.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.ranati.beans.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
 
 

}
