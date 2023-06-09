package ca.sheridancollege.ranati.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.ranati.beans.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
