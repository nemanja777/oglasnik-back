package test.service;

import org.springframework.data.domain.Page;

import test.model.Oglas;

public interface OglasService {

	Page<Oglas> search(String oglas, String kategorija, Double cenaOd, Double cenaDo, Integer korisnikId, int pageNo);

	Oglas findOne(Long id);

	Oglas save(Oglas oglas);

	Oglas delete(Long id);

	Oglas update(Oglas oglas);

	Page<Oglas> findAll(int pageNo);

}
