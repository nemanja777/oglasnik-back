package test.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

public class KorisnikDTO {
	
	private Long id; 
	
	@NotBlank
	private String korisnickoIme;
	
	private LocalDate datumRegistracije; 
	
	private String brojTelefona;

	public KorisnikDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public LocalDate getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(LocalDate datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	} 
	
	
	
	
	
	


}
