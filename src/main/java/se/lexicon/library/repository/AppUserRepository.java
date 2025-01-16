package se.lexicon.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.library.entity.AppUser;

import java.time.LocalDate;
import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByUsernameIs(String username);

    List<AppUser> findAppUserByRegDateBetween(LocalDate date1, LocalDate date2);

    @Query("select u from appUsers  u where u.userDetails.id = : detailsId")
    List<AppUser> findAppUsersByUserDetails_Id(@Param("detailsId") int detailsId);

    @Query("select u from appUsers u where lower(u.userDetails.email) = lower(:email)")
    AppUser findAppUserByEmailIgnoreCase(@Param("email") String email);



}
