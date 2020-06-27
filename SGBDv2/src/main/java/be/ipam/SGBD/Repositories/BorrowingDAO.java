package be.ipam.SGBD.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.ipam.SGBD.classes.Borrowing;

@Repository
public interface BorrowingDAO extends CrudRepository<Borrowing,Long> {
	
	
	@Query(value = "SELECT BorrowingId,StartDate,ReaderId,CopyId FROM Borrowing WHERE ReaderId = ?1",nativeQuery = true)
	public List<Borrowing> getBorrowingByReader(long readerId);

}
