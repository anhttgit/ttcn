package vn.edu.vnua.dse.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnua.dse.calendar.model.SlotTime;

@Repository("slotTimeRepository")
public interface SlotTimeRepository extends JpaRepository<SlotTime, Long> {
	
    SlotTime findById(Long id);
    
}
