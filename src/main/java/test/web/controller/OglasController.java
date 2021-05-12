package test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.model.Korisnik;
import test.model.Oglas;
import test.service.KorisnikService;
import test.service.OglasService;
import test.support.OglasDtoToOglas;
import test.support.OglasToOglasDTO;
import test.web.dto.OglasDTO;






@RestController
@RequestMapping(value = "/api/oglasi", produces = MediaType.APPLICATION_JSON_VALUE)
public class OglasController {

	@Autowired
	private OglasService oglasService; 

	@Autowired
	private KorisnikService korisnikService; 

	@Autowired
	private OglasToOglasDTO toOglasDTO;

	@Autowired
	private OglasDtoToOglas toOglas; 

	// PRETRAGA I PAGINARNI PRIKAZ SVIH
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping 
	ResponseEntity<List<OglasDTO>> get(@RequestParam(value ="ime", required = false) String ime,
			@RequestParam(value = "kategorija", required = false)String kategorija,
			@RequestParam(value = "cenaOd", required = false) Double cenaOd,
			@RequestParam(value = "cenaDo", required = false) Double cenaDo,
			@RequestParam(value = "korisnikId", required = false) Integer korisnikId,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

		Page<Oglas> page = null;

		//		if(ime != null || kategorija != null || cenaOd != null || cenaDo != null ) {
		page = oglasService.search(ime, kategorija, cenaOd, cenaDo, korisnikId, pageNo);
		//		}else {
		//			page = oglasService.findAll(pageNo);
		//		}

		HttpHeaders headres = new HttpHeaders();
		headres.add("Total-Pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toOglasDTO.convert(page.getContent()), headres, HttpStatus.OK);
	}

	//VRATI JEDAN ENTITET PO ID
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<OglasDTO> getOne(@PathVariable Long id){
		Oglas oglas = oglasService.findOne(id);

		if(oglas != null) {
			return new ResponseEntity<>(toOglasDTO.convert(oglas), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// DODAVANJE ENTITETA 
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OglasDTO> create(@Valid @RequestBody OglasDTO oglasDTO){

		Korisnik korisnik = korisnikService.findbyKorisnickoIme(oglasDTO.getKorisnik().getKorisnickoIme());
		oglasDTO.setKorisnik(korisnik);
		Oglas oglas = toOglas.convert(oglasDTO);


		Oglas sacuvan = oglasService.save(oglas);


		System.out.println(oglasDTO.getDatumPostavljanja());
		return new ResponseEntity<>(toOglasDTO.convert(sacuvan), HttpStatus.CREATED);
	}

	// EDIT ENTITETA 
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OglasDTO> update(@PathVariable Long id, @Valid @RequestBody OglasDTO oglasDTO){

		if(!id.equals(oglasDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Oglas oglas = toOglas.convert(oglasDTO);

		Oglas sacuvan = oglasService.update(oglas);

		return new ResponseEntity<>(toOglasDTO.convert(sacuvan), HttpStatus.OK);
	}

	// BRISANJE ENTITETA 
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Oglas obrisanOglas = oglasService.delete(id);

		if(obrisanOglas != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}




}
