package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.RadnoMjesto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class RadnoMjestoRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    public int createRadnoMjesto(RadnoMjesto radnoMjesto) {

        var sql = 
            """
            INSERT INTO radno_mjesto
                (naziv)
            VALUES
                (?)
            """;

        return jdbcTemplate.update(sql, radnoMjesto.getNaziv());
    }

    public List<RadnoMjesto> getAllRadnoMjesto() {

        var sql = 
            """
            SELECT
                id_radno_mjesto,
                naziv
            FROM radno_mjesto
            """;
        
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RadnoMjesto.class));
    }

    public int updateRadnoMjesto(RadnoMjesto radnoMjesto) {

        var sql = 
            """
            UPDATE radno_mjesto
            SET 
                naziv = ?
            WHERE 
                id_radno_mjesto = ?
            """;

        return jdbcTemplate.update(sql, radnoMjesto.getNaziv(), radnoMjesto.getIdRadnoMjesto());
    }

    public int deleteRadnoMjesto(Integer id) {

        var sql =
            """
            DELETE FROM radno_mjesto
            WHERE 
                id_radno_mjesto = ?
            """;

        return jdbcTemplate.update(sql, id);
    }
}
