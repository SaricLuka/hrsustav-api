package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.Drzava;
import hr.tvz.hrsustav.entity.Mjesto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MjestoRepositoryR {

    private final JdbcTemplate jdbcTemplate;

    public List<Mjesto> getAllMjesto() {
		var sql = """
            SELECT 
                m.id_mjesto,
                m.naziv,
                m.post_br,
                d.id_drzava,
                d.naziv AS drzava_naziv,
                d.oznaka AS drzava_oznaka
            FROM mjesto m
            JOIN drzava d ON m.drzava_fk = d.id_drzava
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            var drzava = new Drzava();
            drzava.setIdDrzava(rs.getInt("id_drzava"));
            drzava.setNaziv(rs.getString("drzava_naziv"));
            drzava.setOznaka(rs.getString("drzava_oznaka"));

            var mjesto = new Mjesto();
            mjesto.setIdMjesto(rs.getInt("id_mjesto"));
            mjesto.setNaziv(rs.getString("naziv"));
            mjesto.setPostBr(rs.getString("post_br"));

            mjesto.setDrzavaFk(drzava);

            return mjesto;
        });
    }
}