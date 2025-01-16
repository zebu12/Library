package se.lexicon.library.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.library.entity.Details;

public interface DetailsRepository extends CrudRepository<Details, Integer> {


    Details findByEmail(String email);
    Details findByNameContains(String name);
    Details findByNameIgnoreCase(String name);

}
