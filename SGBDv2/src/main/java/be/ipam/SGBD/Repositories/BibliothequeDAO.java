package be.ipam.SGBD.Repositories;

import org.springframework.data.repository.CrudRepository;

import be.ipam.SGBD.classes.Bibliotheque;

public interface BibliothequeDAO extends CrudRepository<Bibliotheque,Long> {

}
