package test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.model.Oglas;
import test.service.OglasService;
import test.web.dto.OglasDTO;

@Component
public class OglasDtoToOglas implements Converter <OglasDTO, Oglas> {

	@Autowired
	private OglasService oglasService;

	@Override
	public Oglas convert(OglasDTO dto) {
		Oglas oglas; 

		if(dto.getId() == null) {
			oglas = new Oglas(); 
		}else {
			oglas = oglasService.findOne(dto.getId()); 
		}

		if(oglas != null) {
			oglas.setId(dto.getId());
			oglas.setIme(dto.getIme());
			oglas.setOpis(dto.getOpis());
			oglas.setUrl(dto.getUrl());
			oglas.setKategorija(dto.getKategorija());
			oglas.setCena(dto.getCena());
			oglas.setDatumPostavljanja(dto.getDatumPostavljanja());
			oglas.setGrad(dto.getGrad());
			oglas.setKorisnik(dto.getKorisnik());


		}

		return oglas; 

	} 



}
