package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import test.model.Oglas;
import test.repository.OglasRepository;
import test.service.OglasService;

@Service 
public class JpaOglasService implements OglasService {

	@Autowired
	private OglasRepository oglasRepository;

	@Override
	public Page<Oglas> search(String oglas, String kategorija, Double cenaOd, Double cenaDo, Integer korisnikId,
			int pageNo) {

		if(oglas != null) {
			oglas = "%" + oglas + "%";
		}
		return oglasRepository.search( oglas,  kategorija,  cenaOd,  cenaDo,  korisnikId,
				PageRequest.of(pageNo, 3));
	}

	@Override
	public Oglas findOne(Long id) {

		return oglasRepository.findOneById(id);
	}

	@Override
	public Oglas save(Oglas oglas) {

		return oglasRepository.save(oglas);
	}

	@Override
	public Oglas delete(Long id) {
		Oglas oglas = findOne(id); 
		if(oglas != null) {
			oglas = oglasRepository.save(oglas); 
			oglasRepository.delete(oglas);
			return oglas;
		}

		return null; 

	}

	@Override
	public Oglas update(Oglas oglas) {
	
		return oglasRepository.save(oglas);
	}

	@Override
	public Page<Oglas> findAll(int pageNo) {
		
		return oglasRepository.findAll(PageRequest.of(pageNo, 3));
	} 
	
	

}
