package se.lexicon.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.library.entity.AppUser;
import se.lexicon.library.entity.Details;
import se.lexicon.library.repository.AppUserRepository;
import se.lexicon.library.repository.DetailsRepository;

import java.time.LocalDate;

@Component
public class PlayGround implements CommandLineRunner {


    AppUserRepository appUserRepository;
    DetailsRepository appDetailsRepository;

    @Autowired
    public PlayGround(AppUserRepository appUserRepository, DetailsRepository appDetailsRepository) {

        this.appUserRepository = appUserRepository;
        this.appDetailsRepository = appDetailsRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        appDetailsRepository.save(new Details("jp.lexicon@zebu.com", "Jean-Bachar", LocalDate.of(2025,01,16)));
        appUserRepository.save(new AppUser("Zebu","OneLove",LocalDate.of(2025,01,16),appDetailsRepository.findById(1).get()));


        System.out.println(appUserRepository.findByUsernameIs("Zebu").getUsername());

        System.out.println(appUserRepository.findAppUserByRegDateBetween(LocalDate.of(2025,01,16),LocalDate.of(2025,01,16)));

        System.out.println(appDetailsRepository.findByNameContains("Jean-Bachar"));





    }
}
