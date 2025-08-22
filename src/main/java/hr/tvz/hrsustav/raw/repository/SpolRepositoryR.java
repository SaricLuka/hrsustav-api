package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.Spol;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class SpolRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    public List<Spol> getAllSpol() {

        var sql = 
            """
            SELECT
                id_spol,
                oznaka
            FROM spol
            """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Spol.class));
    }
}