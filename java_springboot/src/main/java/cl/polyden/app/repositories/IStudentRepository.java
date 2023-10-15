package cl.polyden.app.repositories;

import org.springframework.data.repository.CrudRepository;

import cl.polyden.app.entitys.Student;

public interface IStudentRepository extends CrudRepository<Student, Long> {
	

}
