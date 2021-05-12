package test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import test.model.Korisnik;
import test.web.dto.KorisnikPromenaLozinkeDTO;


public interface KorisnikService {
	
Korisnik findOne(Long id);
	
	Korisnik findOneById(Long id);

    List<Korisnik> findAll();

    Page<Korisnik> findAll(int brojStranice);

    Korisnik save(Korisnik korisnik);

    void delete(Long id);

   Korisnik findbyKorisnickoIme(String korisnickoIme);

   boolean changePassword(Long id, KorisnikPromenaLozinkeDTO korisnikPromenaLozinkeDto);


}
