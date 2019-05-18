package vn.edu.vnua.dse.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnua.dse.calendar.model.Semester;

@Repository("semesterRepository")
public interface SemesterRepository extends JpaRepository<Semester, String> {
	Semester findById(String id);

}
