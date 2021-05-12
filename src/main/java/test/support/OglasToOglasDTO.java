package test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Oglas;
import test.web.dto.OglasDTO;

@Component
public class OglasToOglasDTO implements Converter <Oglas, OglasDTO>{

	@Override
	public OglasDTO convert(Oglas oglas) {
		OglasDTO dto = new OglasDTO();
		dto.setId(oglas.getId());
		dto.setIme(oglas.getIme());
		dto.setOpis(oglas.getOpis());
		dto.setKategorija(oglas.getKategorija());
		dto.setUrl(oglas.getUrl());
		dto.setDatumPostavljanja(oglas.getDatumPostavljanja());
		dto.setCena(oglas.getCena());
		dto.setGrad(oglas.getGrad());
		dto.setKorisnik(oglas.getKorisnik());



		return dto;
	}

	public List<OglasDTO> convert(List<Oglas> oglasi){
		List<OglasDTO> oglasiDTO = new ArrayList<>();

		for(Oglas oglas: oglasi) {
			oglasiDTO.add(convert(oglas));
		}
		return oglasiDTO;
	}

}
