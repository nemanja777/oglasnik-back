package test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test.model.Oglas;

@Repository 
public interface OglasRepository extends JpaRepository <Oglas,Long> {

	Oglas findOneById(Long id); 


	@Query("SELECT o FROM Oglas o WHERE " +
			"(:oglas = NULL OR o.ime LIKE :oglas) AND " + //LIKE(ide samo za STRINGOVE) jer koristimo procente, = se stavlja kad hoces da mecujes ceo string ili sve sto je upisano u bazi!
			"(:kategorija = NULL OR o.kategorija = :kategorija) AND " + 
			"(:cenaOd = NULL OR o.cena >= :cenaOd) AND " + 
			"(:cenaDo = NULL OR o.cena <= :cenaDo) AND " + 
			"(:korisnikId = NULL OR o.korisnik.id = :korisnikId) ORDER BY datum_postavljanja desc")
	Page<Oglas> search(@Param("oglas")String oglas, @Param("kategorija")String kategorija,@Param("cenaOd") Double cenaOd,@Param("cenaDo") Double cenaDo,@Param("korisnikId") Integer korisnikId,
			Pageable pageable);
	

}
