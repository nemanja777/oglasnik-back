package test.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import test.model.Korisnik;

public class OglasDTO {

	private Long id; 

	private String ime; 

	@Length(max=40)
	private String opis; 



	private String url; 

	@NotNull
	private double cena; 

	private String kategorija; 

	private Korisnik korisnik; 

	private String grad; 

	private LocalDate datumPostavljanja;

	public OglasDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public LocalDate getDatumPostavljanja() {
		return datumPostavljanja;
	}

	public void setDatumPostavljanja(LocalDate datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	} 
	
	
	



}
