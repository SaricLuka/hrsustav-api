package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.dto.UgovorRadDto;
import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.UgovorRad;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UgovorRadRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int createUgovorRad(UgovorRad ugovorRad) {
        String sql = """
                INSERT INTO ugovor_rad (
                    radnik_fk,
                    datum_ugovor,
                    datum_od,
                    datum_do,
                    mjesto_rada_fk,
                    radno_mjesto_fk,
                    radno_vrijeme_fk,
                    vrsta_ugovor_rad_fk,
                    bruto_placa
                ) VALUES (
                    :radnikFk,
                    :datumUgovor,
                    :datumOd,
                    :datumDo,
                    :mjestoRadaFk,
                    :radnoMjestoFk,
                    :radnoVrijemeFk,
                    :vrstaUgovorRadFk,
                    :brutoPlaca
                )
                """;

        var params = new MapSqlParameterSource()
                .addValue("radnikFk", ugovorRad.getRadnikFk())
                .addValue("datumUgovor", ugovorRad.getDatumUgovor())
                .addValue("datumOd", ugovorRad.getDatumOd())
                .addValue("datumDo", ugovorRad.getDatumDo())
                .addValue("mjestoRadaFk", ugovorRad.getMjestoRadaFk())
                .addValue("radnoMjestoFk", ugovorRad.getRadnoMjestoFk())
                .addValue("radnoVrijemeFk", ugovorRad.getRadnoVrijemeFk().getIdRadnoVrijeme())
                .addValue("vrstaUgovorRadFk", ugovorRad.getVrstaUgovorRadFk())
                .addValue("brutoPlaca", ugovorRad.getBrutoPlaca());

        return namedParameterJdbcTemplate.update(sql, params);
    }

    public List<UgovorRadDto> getAllUgovorRad(UgovorRadGetRequest request) {
        var sql = new StringBuilder("""
            SELECT
                u.id_ugovor_rad AS idUgovorRad,
                u.radnik_fk AS radnikFk,
                u.datum_ugovor AS datumUgovor,
                u.datum_od AS datumOd,
                u.datum_do AS datumDo,
                u.mjesto_rada_fk AS mjestoRadaFk,
                u.radno_mjesto_fk AS radnoMjestoFk,
                u.radno_vrijeme_fk AS radnoVrijemeFk,
                rv.vrsta_radno_vrijeme_fk AS vrstaRadnoVrijemeFk,
                rv.tjedno_sati AS tjednoSati,
                rv.dnevno_sati AS dnevnoSati,
                rv.godisnji,
                u.vrsta_ugovor_rad_fk AS vrstaUgovorRadFk,
                u.bruto_placa AS brutoPlaca
            FROM ugovor_rad u
            LEFT JOIN radno_vrijeme rv
                ON u.radno_vrijeme_fk = rv.id_radno_vrijeme
            WHERE 1=1
            """);

        MapSqlParameterSource params = new MapSqlParameterSource();

        if (request.getIdUgovorRad() != null) {
            sql.append(" AND u.id_ugovor_rad = :idUgovorRad");
            params.addValue("idUgovorRad", request.getIdUgovorRad());
        }

        if (request.getRadnikFk() != null) {
            sql.append(" AND u.radnik_fk = :radnikFk");
            params.addValue("radnikFk", request.getRadnikFk());
        }

        if (request.getDatumUgovorFrom() != null && request.getDatumUgovorTo() != null) {
            sql.append(" AND u.datum_ugovor BETWEEN :datumUgovorFrom AND :datumUgovorTo");
            params.addValue("datumUgovorFrom", request.getDatumUgovorFrom());
            params.addValue("datumUgovorTo", request.getDatumUgovorTo());
        } else if (request.getDatumUgovorFrom() != null) {
            sql.append(" AND u.datum_ugovor >= :datumUgovorFrom");
            params.addValue("datumUgovorFrom", request.getDatumUgovorFrom());
        } else if (request.getDatumUgovorTo() != null) {
            sql.append(" AND u.datum_ugovor <= :datumUgovorTo");
            params.addValue("datumUgovorTo", request.getDatumUgovorTo());
        }

        if (request.getDatumFrom() != null && request.getDatumTo() != null) {
            sql.append(" AND :datumFrom <= u.datum_od AND :datumTo <= u.datum_do");
            params.addValue("datumFrom", request.getDatumFrom());
            params.addValue("datumTo", request.getDatumTo());
        } else if (request.getDatumFrom() != null) {
            sql.append(" AND :datumFrom <= u.datum_od");
            params.addValue("datumFrom", request.getDatumFrom());
        } else if (request.getDatumTo() != null) {
            sql.append(" AND :datumTo <= u.datum_do");
            params.addValue("datumTo", request.getDatumTo());
        }

        if (request.getRadnoMjestoFk() != null) {
            sql.append(" AND u.radno_mjesto_fk = :radnoMjestoFk");
            params.addValue("radnoMjestoFk", request.getRadnoMjestoFk());
        }

        return namedParameterJdbcTemplate.query(sql.toString(), params, new BeanPropertyRowMapper<>(UgovorRadDto.class));

    }

    public int updateUgovorRad(UgovorRad ugovorRad) {
        String sql = """
                UPDATE ugovor_rad SET
                    radnik_fk = :radnikFk,
                    datum_ugovor = :datumUgovor,
                    datum_od = :datumOd,
                    datum_do = :datumDo,
                    mjesto_rada_fk = :mjestoRadaFk,
                    radno_mjesto_fk = :radnoMjestoFk,
                    vrsta_ugovor_rad_fk = :vrstaUgovorRadFk,
                    bruto_placa = :brutoPlaca
                WHERE id_ugovor_rad = :idUgovorRad
                """;

        var params = new MapSqlParameterSource()
                .addValue("radnikFk", ugovorRad.getRadnikFk())
                .addValue("datumUgovor", ugovorRad.getDatumUgovor())
                .addValue("datumOd", ugovorRad.getDatumOd())
                .addValue("datumDo", ugovorRad.getDatumDo())
                .addValue("mjestoRadaFk", ugovorRad.getMjestoRadaFk())
                .addValue("radnoMjestoFk", ugovorRad.getRadnoMjestoFk())
                .addValue("vrstaUgovorRadFk", ugovorRad.getVrstaUgovorRadFk())
                .addValue("brutoPlaca", ugovorRad.getBrutoPlaca())
                .addValue("idUgovorRad", ugovorRad.getIdUgovorRad());

        return namedParameterJdbcTemplate.update(sql, params);
    }

    public void deleteUgovorRad(int idUgovorRad) {

        String sql = """
                DELETE FROM radno_vrijeme
                WHERE id_radno_vrijeme = (
                    SELECT radno_vrijeme_fk FROM ugovor_rad WHERE id_ugovor_rad = ?
                )
                """;
        jdbcTemplate.update(sql, idUgovorRad);
    }
}
