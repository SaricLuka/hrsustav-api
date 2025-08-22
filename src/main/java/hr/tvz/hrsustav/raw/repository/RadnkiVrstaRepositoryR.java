package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.RadnikVrsta;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class RadnkiVrstaRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    public List<RadnikVrsta> getAllRadnikVrsta() {

        var sql = 
                """
                SELECT
                    id_radnik_vrsta,
                    naziv
                FROM radnik_vrsta
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RadnikVrsta.class));
    }
}