package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
	
	Korisnik findOneById(Long id);
	
    Korisnik findFirstByKorisnickoIme(String korisnickoIme);

    Korisnik findFirstByKorisnickoImeAndLozinka(String korisnickoIme,String lozinka);


}
