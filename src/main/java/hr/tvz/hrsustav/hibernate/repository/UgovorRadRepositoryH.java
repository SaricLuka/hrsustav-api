package hr.tvz.hrsustav.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hr.tvz.hrsustav.entity.UgovorRad;

public interface UgovorRadRepositoryH extends JpaRepository<UgovorRad, Integer> {

	@Modifying
	@Query(value = """
			DELETE FROM radno_vrijeme WHERE id_radno_vrijeme = (
			    SELECT radno_vrijeme_fk FROM ugovor_rad WHERE id_ugovor_rad = :id
			);
			""", nativeQuery = true)
	int deleteRadnoVrijemeByUgovorRadId(@Param("id") Integer id);
}
