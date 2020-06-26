package be.ipam.SGBD.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import be.ipam.SGBD.classes.Book;
import be.ipam.SGBD.classes.Copy;

@Repository
public interface BookDAO extends CrudRepository<Book,Long> {
	
	
	@Query(value="select * from Book where book.BookId in(select bib.BookId from BibliothequeBook bib where bib.BibliothequeId = ?1)",nativeQuery= true)
	public List<Book> getBooks(long bibliothequeId);

}
