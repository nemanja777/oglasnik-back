package test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Korisnik;
import test.service.KorisnikService;
import test.web.dto.KorisnikDTO;



@Component
public class KorisnikDtoToKorisnik implements Converter<KorisnikDTO, Korisnik> {
	
	@Autowired
	private KorisnikService korisnikService;

	@Override
	public Korisnik convert(KorisnikDTO korisnikDTO) {
		Korisnik korisnik = null;
        if(korisnikDTO.getId() != null) {
            korisnik = korisnikService.findOne(korisnikDTO.getId());
        }
        
        if(korisnik == null) {
            korisnik = new Korisnik();
        }
        
        korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
        korisnik.setDatumRegistracije(korisnikDTO.getDatumRegistracije());
        korisnik.setBrojTelefona(korisnikDTO.getBrojTelefona());
    
        
        
		return korisnik;
	}
	
	

}
