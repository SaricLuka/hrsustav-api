package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.Drzava;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DrzavaRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    public List<Drzava> getAllDrzava() {
        var sql = 
            """
            SELECT
                id_drzava,
                naziv,
                oznaka
            FROM drzava
            """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Drzava.class));
    }
}