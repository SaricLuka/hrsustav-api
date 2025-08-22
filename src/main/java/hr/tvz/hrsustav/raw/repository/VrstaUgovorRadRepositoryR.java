package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.VrstaUgovorRad;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class VrstaUgovorRadRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    public List<VrstaUgovorRad> getAllVrstaUgovorRad() {

        var sql = 
            """
            SELECT
                id_vrsta_ugovor_rad,
                naziv
            FROM vrsta_ugovor_rad
            """;
        
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VrstaUgovorRad.class));
    }
}
