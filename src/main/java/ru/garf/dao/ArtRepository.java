package ru.garf.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.garf.model.Art;

@Repository
public interface ArtRepository extends CrudRepository<Art, Integer> {
}
