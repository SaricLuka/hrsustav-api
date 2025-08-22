package hr.tvz.hrsustav.raw.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.dto.request.RadnikRequest;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class RadnikRepositoryR {

    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public int createRadnik(RadnikRequest radnik) {
        var sql = """
                INSERT INTO radnik (
                    radnik_nadred_fk,
                    ime,
                    prezime,
                    oib,
                    spol_fk,
                    datum_rod,
                    radnik_vrsta_fk)
                VALUES (
                    :radnikNadredFk,
                    :ime,
                    :prezime,
                    :oib,
                    :spolFk,
                    :datumRod,
                    :radnikVrstaFk)
                """;

        var params = new MapSqlParameterSource()
                .addValue("radnikNadredFk", radnik.getRadnikNadredFk())
                .addValue("ime", radnik.getIme())
                .addValue("prezime", radnik.getPrezime())
                .addValue("oib", radnik.getOib())
                .addValue("spolFk", radnik.getSpolFk())
                .addValue("datumRod", radnik.getDatumRod())
                .addValue("radnikVrstaFk", radnik.getRadnikVrstaFk());

        return namedJdbcTemplate.update(sql, params);
    }

    public List<RadnikDto> getAllRadnik(RadnikGetRequest request) {
        var sql = new StringBuilder("""
                    SELECT DISTINCT ON (r.id_radnik)
                        r.id_radnik,
                        r.radnik_nadred_fk,
                        r.ime,
                        r.prezime,
                        r.oib,
                        s.oznaka AS spol,
                        r.datum_rod,
                        rv.naziv AS radnikVrstaNaziv,
                        ro.odjel_fk,
                        ur.id_ugovor_rad,
                        ur.datum_od AS datumOdUgovorRad,
                        ro.datum_od AS datumOdRadnikOdjel
                    FROM radnik r
                        LEFT JOIN spol s ON s.id_spol = r.spol_fk
                        LEFT JOIN radnik_vrsta rv ON rv.id_radnik_vrsta = r.radnik_vrsta_fk
                        LEFT JOIN radnik_odjel ro ON ro.radnik_fk = r.id_radnik
                        LEFT JOIN ugovor_rad ur ON ur.radnik_fk = r.id_radnik
                    WHERE 1=1
                """);

        Map<String, Object> params = new HashMap<>();

        if (request.getIdRadnik() != null) {
            sql.append(" AND r.id_radnik = :idRadnik");
            params.put("idRadnik", request.getIdRadnik());
        }

        if (request.getRadnikNadredFk() != null) {
            sql.append(" AND r.radnik_nadred_fk = :radnikNadredFk");
            params.put("radnikNadredFk", request.getRadnikNadredFk());
        }

        if (request.getIme() != null) {
            sql.append(" AND r.ime = :ime");
            params.put("ime", request.getIme());
        }

        if (request.getPrezime() != null) {
            sql.append(" AND r.prezime = :prezime");
            params.put("prezime", request.getPrezime());
        }

        if (request.getOib() != null) {
            sql.append(" AND r.oib = :oib");
            params.put("oib", request.getOib());
        }

        if (request.getSpolFk() != null) {
            sql.append(" AND r.spol_fk = :spolFk");
            params.put("spolFk", request.getSpolFk());
        }

        if (request.getDatumRod() != null) {
            sql.append(" AND r.datum_rod = :datumRod");
            params.put("datumRod", request.getDatumRod());
        }

        if (request.getRadnikVrstaFk() != null) {
            sql.append(" AND r.radnik_vrsta_fk = :radnikVrstaFk");
            params.put("radnikVrstaFk", request.getRadnikVrstaFk());
        }

        if (Boolean.TRUE.equals(request.getInOdjel())) {
            sql.append("""
                         AND ro.datum_od <= CURRENT_DATE
                        AND (ro.datum_do >= CURRENT_DATE OR ro.datum_do IS NULL)
                    """);
        }

        if (Boolean.TRUE.equals(request.getIsZaposlen())) {
            sql.append("""
                         AND ur.datum_od <= CURRENT_DATE
                        AND (ur.datum_do IS NULL OR ur.datum_do >= CURRENT_DATE)
                    """);
        }

        sql.append("""
                 ORDER BY
                    r.id_radnik,
                    ro.datum_od DESC,
                    ur.datum_od DESC;
                """);

        return namedJdbcTemplate.query(sql.toString(), params, new BeanPropertyRowMapper<>(RadnikDto.class));
    }

    public int updateRadnik(RadnikRequest radnik) {

        var sql = """
                UPDATE radnik
                SET
                    radnik_nadred_fk = :radnikNadredFk,
                    ime = :ime,
                    prezime = :prezime,
                    oib = :oib,
                    spol_fk = :spolFk,
                    datum_rod = :datumRod,
                    radnik_vrsta_fk = :radnikVrstaFk
                WHERE
                    id_radnik = :idRadnik
                """;

        var params = new MapSqlParameterSource()
                .addValue("radnikNadredFk", radnik.getRadnikNadredFk())
                .addValue("ime", radnik.getIme())
                .addValue("prezime", radnik.getPrezime())
                .addValue("oib", radnik.getOib())
                .addValue("spolFk", radnik.getSpolFk())
                .addValue("datumRod", radnik.getDatumRod())
                .addValue("radnikVrstaFk", radnik.getRadnikVrstaFk())
                .addValue("idRadnik", radnik.getIdRadnik());

        return namedJdbcTemplate.update(sql, params);
    }

    public int deleteRadnik(Integer idRadnik) {

        var sql = """
                DELETE FROM radnik
                WHERE
                    id_radnik = :idRadnik
                """;

        var params = new MapSqlParameterSource()
                .addValue("idRadnik", idRadnik);

        return namedJdbcTemplate.update(sql, params);
    }

}