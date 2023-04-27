package ca.sheridancollege.ranati.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.ranati.beans.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
