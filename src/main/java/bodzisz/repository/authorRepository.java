package bodzisz.repository;

import bodzisz.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorRepository extends JpaRepository<Author, Integer> {
}
