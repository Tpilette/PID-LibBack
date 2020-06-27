package be.ipam.SGBD.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import be.ipam.SGBD.classes.Copy;

public interface CopyDAO extends CrudRepository <Copy,Long>{	

	
	@Query(value="SELECT TOP 1 * FROM COPY WHERE BookId=?1 AND CopyStatusId = 1",nativeQuery= true)
	public Optional<Copy> getAvailableCopy(long bookId);

	
	@Query(value="SELECT title \r\n" + 
			"FROM Book \r\n" + 
			"Inner join Copy on Copy.BookId = book.BookId\r\n" + 
			"WHERE CopyId = ?1",nativeQuery= true)
	public String getCopyTitle(long copyId);
	
}
