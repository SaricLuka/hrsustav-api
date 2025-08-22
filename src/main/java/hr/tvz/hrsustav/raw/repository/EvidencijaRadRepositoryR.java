package hr.tvz.hrsustav.raw.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.EvidencijaRad;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class EvidencijaRadRepositoryR {

    public final NamedParameterJdbcTemplate jdbcTemplate;

    public int createEvidencijaRad(EvidencijaRad e) {
        String sql = """
                    INSERT INTO evidencija_rad (
                        radnik_fk, datum, pocetak, kraj, ukupno_redovno, redovno, prekovr,
                        zastoj, strajk, lockout, prerasp, bol_do_42, bol_od_42, godisnji,
                        godisnji_placen, praznik, ukupno_sati, nedjelja_pov, praznik_pov,
                        noc_pov, smjena_pov, dvokr_pov, ostalo_pov, pripr, odmor, odsut
                    ) VALUES (
                        :radnikFk, :datum, :pocetak, :kraj, :ukupnoRedovno, :redovno, :prekovr,
                        :zastoj, :strajk, :lockout, :prerasp, :bolDo42, :bolOd42, :godisnji,
                        :godisnjiPlacen, :praznik, :ukupnoSati, :nedjeljaPov, :praznikPov,
                        :nocPov, :smjenaPov, :dvokrPov, :ostaloPov, :pripr, :odmor, :odsut
                    )
                """;

        return jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(e));
    }

    public List<EvidencijaRad> getEvidencijaRad(Integer radnikFk, Date start, Date end) {
        String sql = """
                SELECT
                    id_evidencija_rad AS idEvidencijaRad,
                    radnik_fk AS radnikFk,
                    datum,
                    pocetak,
                    kraj,
                    ukupno_redovno AS ukupnoRedovno,
                    redovno,
                    prekovr,
                    zastoj,
                    strajk,
                    lockout,
                    prerasp,
                    bol_do_42 AS bolDo42,
                    bol_od_42 AS bolOd42,
                    godisnji,
                    godisnji_placen,
                    praznik,
                    ukupno_sati,
                    nedjelja_pov,
                    praznik_pov,
                    noc_pov,
                    smjena_pov,
                    dvokr_pov,
                    ostalo_pov,
                    pripr,
                    odmor,
                    odsut
                FROM evidencija_rad
                WHERE radnik_fk = :radnikFk AND datum BETWEEN :datumStart AND :datumEnd
                """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("radnikFk", radnikFk)
                .addValue("datumStart", start)
                .addValue("datumEnd", end);

        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(EvidencijaRad.class));
    }

    public int updateEvidencijaRad(EvidencijaRad e) {
        String sql = """
                UPDATE evidencija_rad SET
                    radnik_fk = :radnikFk,
                    datum = :datum,
                    pocetak = :pocetak,
                    kraj = :kraj,
                    ukupno_redovno = :ukupnoRedovno,
                    redovno = :redovno,
                    prekovr = :prekovr,
                    zastoj = :zastoj,
                    strajk = :strajk,
                    lockout = :lockout,
                    prerasp = :prerasp,
                    bol_do_42 = :bolDo42,
                    bol_od_42 = :bolOd42,
                    godisnji = :godisnji,
                    godisnji_placen = :godisnjiPlacen,
                    praznik = :praznik,
                    ukupno_sati = :ukupnoSati,
                    nedjelja_pov = :nedjeljaPov,
                    praznik_pov = :praznikPov,
                    noc_pov = :nocPov,
                    smjena_pov = :smjenaPov,
                    dvokr_pov = :dvokrPov,
                    ostalo_pov = :ostaloPov,
                    pripr = :pripr,
                    odmor = :odmor,
                    odsut = :odsut
                WHERE id_evidencija_rad = :idEvidencijaRad
                """;

        return jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(e));
    }

    public int deleteEvidencijaRad(int idEvidencijaRad) {
        String sql = "DELETE FROM evidencija_rad WHERE id_evidencija_rad = :idEvidencijaRad";
        return jdbcTemplate.update(sql, new MapSqlParameterSource("idEvidencijaRad", idEvidencijaRad));
    }

}
