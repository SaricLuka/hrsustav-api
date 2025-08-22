package hr.tvz.hrsustav.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.entity.RadnikOdjel;

public interface RadnikOdjelRepositoryH extends JpaRepository<RadnikOdjel, Integer> {

    @Query("""
        SELECT new hr.tvz.hrsustav.dto.RadnikOdjelDto(
        r.idRadnikOdjel,
        r.radnikFk.idRadnik,
        r.odjelFk.naziv,
        r.datumOd,
        r.datumDo)
        FROM RadnikOdjel r 
        WHERE r.radnikFk.idRadnik = :radnikFk
    """)
    List<RadnikOdjelDto> findByRadnikFk_IdRadnik(Integer radnikFk);

    @Query("""
        SELECT new hr.tvz.hrsustav.dto.RadnikOdjelDto(
        r.idRadnikOdjel,
        r.radnikFk.idRadnik,
        r.odjelFk.naziv,
        r.datumOd,
        r.datumDo)
        FROM RadnikOdjel r 
        WHERE r.odjelFk.idOdjel = :odjelFk
    """)
    List<RadnikOdjelDto> findByOdjelFk_IdOdjel(Integer odjelFk);
}
