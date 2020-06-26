package be.ipam.SGBD.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import be.ipam.SGBD.classes.Copy;

public interface CopyDAO extends CrudRepository <Copy,Long>{	

	
	@Query(value="SELECT TOP 1 * FROM COPY WHERE EditionISBN like('?1') AND CopyStatusId = 1",nativeQuery= true)
	public Optional<Copy> getAvailableCopy(String isbn);
	
	@Query(value="SELECT * FROM COPY WHERE EditionISBN like('?1')",nativeQuery= true)
	List<Copy> getCopies(String isbn);
}
