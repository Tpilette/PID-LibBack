package be.ipam.SGBD.Repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import be.ipam.SGBD.classes.Amende;

public interface AmendeDAO extends CrudRepository<Amende,Long> {
	
	
	@Query(value="SELECT * FROM Fine WHERE ReaderId = ?1",nativeQuery = true)
	public Optional<Amende> getUserFine (long userId);

}
