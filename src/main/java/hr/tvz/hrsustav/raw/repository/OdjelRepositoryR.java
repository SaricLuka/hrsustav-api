package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.Odjel;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class OdjelRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    public int createOdjel(Odjel odjel) {
        var sql = 
                """
                INSERT INTO odjel
                    (naziv)
                VALUES
                    (?)
                """;

        return jdbcTemplate.update(sql, odjel.getNaziv());
    }

    public List<Odjel> getAllOdjel() {
        var sql = 
                """
                SELECT
                    id_odjel,
                    naziv
                FROM odjel
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Odjel.class));
    }

    public int updateOdjel(Odjel odjel) {

        var sql = 
                """
                UPDATE odjel
                SET naziv = ?
                WHERE id_odjel = ?
                """;

        return jdbcTemplate.update(sql, odjel.getNaziv(), odjel.getIdOdjel());
    }

    public int deleteOdjel(Integer id) {

        var sql =
                """
                DELETE FROM odjel
                WHERE id_odjel = ?
                """;

        return jdbcTemplate.update(sql, id);
    }
}