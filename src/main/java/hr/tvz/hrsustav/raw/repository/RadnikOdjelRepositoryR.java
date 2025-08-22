package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.dto.request.RadnikOdjelRequest;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class RadnikOdjelRepositoryR {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public int createRadnikOdjel(RadnikOdjelRequest radnikOdjel) {
        var sql = """
                INSERT INTO radnik_odjel (
                    radnik_fk,
                    odjel_fk,
                    datum_od,
                    datum_do)
                VALUES (
                    :radnikFk,
                    :odjelFk,
                    :datumOd,
                    :datumDo)
                """;

        var params = new MapSqlParameterSource()
            .addValue("radnikFk", radnikOdjel.getRadnikFk())
            .addValue("odjelFk", radnikOdjel.getOdjelFk())
            .addValue("datumOd", radnikOdjel.getDatumOd())
            .addValue("datumDo", radnikOdjel.getDatumDo());

        return namedJdbcTemplate.update(sql, params);
    }

    public List<RadnikOdjelDto> getRadnikOdjelbyRadnik(Integer id) {
        var sql = """
                SELECT
                    id_radnik_odjel,
                    radnik_fk,
                    o.naziv AS naziv_odjela,
                    datum_od,
                    datum_do
                FROM radnik_odjel
                    INNER JOIN odjel o ON o.id_odjel = radnik_odjel.odjel_fk
                WHERE
                    radnik_fk = :radnikFk
                """;

        var params = new MapSqlParameterSource()
            .addValue("radnikFk", id);

        return namedJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(RadnikOdjelDto.class));
    }

    public List<RadnikOdjelDto> getRadnikOdjelbyOdjel(Integer id) {
        var sql = """
                SELECT
                    id_radnik_odjel,
                    radnik_fk,
                    o.naziv AS naziv_odjela,
                    datum_od,
                    datum_do
                FROM radnik_odjel
                    INNER JOIN odjel o ON o.id_odjel = radnik_odjel.odjel_fk
                WHERE
                    odjel_fk = :odjelFk
                """;

        var params = new MapSqlParameterSource()
            .addValue("odjelFk", id);

        return namedJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(RadnikOdjelDto.class));
    }

    public int updateRadnikOdjel(RadnikOdjelRequest radnikOdjel) {
        var sql = """
                UPDATE radnik_odjel
                SET
                    radnik_fk = :radnikFk,
                    odjel_fk = :odjelFk,
                    datum_od = :datumOd,
                    datum_do = :datumDo
                WHERE
                    id_radnik_odjel = :idRadnikOdjel
                """;

        var params = new MapSqlParameterSource()
            .addValue("idRadnikOdjel", radnikOdjel.getIdRadnikOdjel())
            .addValue("radnikFk", radnikOdjel.getRadnikFk())
            .addValue("odjelFk", radnikOdjel.getOdjelFk())
            .addValue("datumOd", radnikOdjel.getDatumOd())
            .addValue("datumDo", radnikOdjel.getDatumDo());

        return namedJdbcTemplate.update(sql, params);
    }

    public int deleteRadnikOdjel(Integer id) {
        var sql = """
                DELETE from radnik_odjel
                WHERE
                    id_radnik_odjel = :idRadnikOdjel
                """;

        var params = new MapSqlParameterSource()
            .addValue("idRadnikOdjel", id);

        return namedJdbcTemplate.update(sql, params);
    }
}