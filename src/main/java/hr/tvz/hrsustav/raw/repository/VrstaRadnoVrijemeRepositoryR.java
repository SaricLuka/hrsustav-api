package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.VrstaRadnoVrijeme;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class VrstaRadnoVrijemeRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    public List<VrstaRadnoVrijeme> getAllVrstaRadnoVrijeme() {

        var sql = 
            """
            SELECT
                id_vrsta_radno_vrijeme,
                naziv
            FROM vrsta_radno_vrijeme
            """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VrstaRadnoVrijeme.class));
    }
}