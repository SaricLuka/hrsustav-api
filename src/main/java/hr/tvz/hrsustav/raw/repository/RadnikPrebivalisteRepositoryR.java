package hr.tvz.hrsustav.raw.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

@Repository
@AllArgsConstructor
public class RadnikPrebivalisteRepositoryR {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public int createRadnikPrebivaliste(List<RadnikPrebivaliste> radnikPrebivalisteList) {
        var sql = """
                INSERT INTO radnik_prebivaliste (
                    radnik_fk,
                    mjesto_fk,
                    ulica,
                    kucni_br
                ) VALUES (
                    :radnikFk,
                    :mjestoFk,
                    :ulica,
                    :kucniBr
                )
                """;
        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(radnikPrebivalisteList.toArray());

        namedJdbcTemplate.batchUpdate(sql, batchArgs);
        return 1;
    }

    public List<RadnikPrebivaliste> getRadnikPrebivalisteByRadnik(Integer id) {
        var sql = """
                SELECT
                    id_radnik_prebivaliste,
                    radnik_fk,
                    mjesto_fk,
                    ulica,
                    kucni_br
                FROM radnik_prebivaliste
                WHERE radnik_fk = :radnikFk
                """;

        var params = new MapSqlParameterSource()
                .addValue("radnikFk", id);

        return namedJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(RadnikPrebivaliste.class));
    }

    public List<RadnikPrebivaliste> getRadnikPrebivalisteByMjesto(Integer id) {
        var sql = """
                SELECT
                    id_radnik_prebivaliste,
                    radnik_fk,
                    mjesto_fk,
                    ulica,
                    kucni_br
                FROM radnik_prebivaliste
                WHERE mjesto_fk = :mjestoFk
                """;

        var params = new MapSqlParameterSource()
                .addValue("mjestoFk", id);

        return namedJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(RadnikPrebivaliste.class));
    }

    public int updateRadnikPrebivaliste(RadnikPrebivaliste radnikPrebivaliste) {
        var sql = """
                UPDATE radnik_prebivaliste
                SET
                    radnik_fk = :radnikFk,
                    mjesto_fk = :mjestoFk,
                    ulica = :ulica,
                    kucni_br = :kucniBr
                WHERE id_radnik_prebivaliste = :idRadnikPrebivaliste
                """;

        var params = new MapSqlParameterSource()
                .addValue("idRadnikPrebivaliste", radnikPrebivaliste.getIdRadnikPrebivaliste())
                .addValue("radnikFk", radnikPrebivaliste.getRadnikFk())
                .addValue("mjestoFk", radnikPrebivaliste.getMjestoFk())
                .addValue("ulica", radnikPrebivaliste.getUlica())
                .addValue("kucniBr", radnikPrebivaliste.getKucniBr());

        return namedJdbcTemplate.update(sql, params);
    }

    public int deleteRadnikPrebivaliste(Integer id) {
        var sql = """
                DELETE FROM radnik_prebivaliste
                WHERE id_radnik_prebivaliste = :idRadnikPrebivaliste
                """;

        var params = new MapSqlParameterSource()
                .addValue("idRadnikPrebivaliste", id);

        return namedJdbcTemplate.update(sql, params);
    }
}