package be.ipam.SGBD.Repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import be.ipam.SGBD.classes.Reader;
import be.ipam.SGBD.classes.Amende;
import be.ipam.SGBD.classes.Borrowing;
import be.ipam.SGBD.classes.Cotisation;

public interface ReaderDAO extends CrudRepository<Reader,Long> {
	
	
	@Query(value="SELECT * FROM Reader WHERE Email = ?1",nativeQuery = true)
	public Optional<Reader> findByemail (String mail);

	@Query(value="SELECT BibliothequeId,validityExpiration,fee FROM AffiliateLibrary WHERE ReaderId = ?1",nativeQuery = true)
	public List<Cotisation> getCotisations (long ReaderId);
	
	@Query(value="SELECT * FROM Fine WHERE ReaderId = ?1",nativeQuery = true)
	public List<Amende> getAmende (long ReaderId);
	
}
