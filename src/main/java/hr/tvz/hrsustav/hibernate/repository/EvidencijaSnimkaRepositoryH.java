package hr.tvz.hrsustav.hibernate.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.entity.EvidencijaSnimka;

public interface EvidencijaSnimkaRepositoryH extends JpaRepository<EvidencijaSnimka, Integer> {

    @Query("""
        SELECT new hr.tvz.hrsustav.dto.EvidencijaSnimkaDto(
            e.idEvidencijaSnimka,
            e.datumOd,
            e.datumDo,
            e.radnikFk.id,
            e.snimka,
            e.datum
        )
        FROM EvidencijaSnimka e
        WHERE (:idEvidencijaSnimka IS NULL OR e.idEvidencijaSnimka = :idEvidencijaSnimka)
          AND (:radnikFk IS NULL OR e.radnikFk.id = :radnikFk)
          AND (:datumOd IS NULL OR e.datumOd = :datumOd)
          AND (:datumDo IS NULL OR e.datumDo = :datumDo)
          AND (:datum IS NULL OR e.datum = :datum)
    """)
    List<EvidencijaSnimkaDto> getEvidencijaSnimka(
        Integer idEvidencijaSnimka,
        Integer radnikFk,
        Date datumOd,
        Date datumDo,
        Date datum);
}
