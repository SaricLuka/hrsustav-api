package hr.tvz.hrsustav.raw.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.dto.request.EvidencijaSnimkaRequest;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class EvidencijaSnimkaRepositoryR {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

	public int createEvidencijaSnimka(EvidencijaSnimkaRequest request) {
        var sql = """
            INSERT INTO evidencija_snimka (
                datum_od,
                datum_do,
                radnik_fk,
                snimka,
                datum)
            VALUES (
                :datumOd,
                :datumDo,
                :radnikFk,
                :snimka,
                CURRENT_TIMESTAMP)
        """;

        var params = new MapSqlParameterSource()
            .addValue("datumOd", request.getDatumOd())
            .addValue("datumDo", request.getDatumDo())
            .addValue("radnikFk", request.getRadnikFk())
            .addValue("snimka", request.getSnimka());

        return namedJdbcTemplate.update(sql, params);
    }

    public List<EvidencijaSnimkaDto> getEvidencijaSnimka(EvidencijaSnimkaRequest request) {
        var sql = new StringBuilder("""
            SELECT
                id_evidencija_snimka,
                datum_od,
                datum_do,
                radnik_fk,
                snimka,
                datum
            FROM evidencija_snimka
            WHERE 1=1
        """);

        var params = new MapSqlParameterSource();

        if (request.getIdEvidencijaSnimka() != null) {
            sql.append(" AND id_evidencija_snimka = :idEvidencijaSnimka");
            params.addValue("idEvidencijaSnimka", request.getIdEvidencijaSnimka());
        }

        if (request.getRadnikFk() != null) {
            sql.append(" AND radnik_fk = :radnikFk");
            params.addValue("radnikFk", request.getRadnikFk());
        }

        if (request.getDatumOd() != null) {
            sql.append(" AND datum_od = :datumOd");
            params.addValue("datumOd", request.getDatumOd());
        }

        if (request.getDatumDo() != null) {
            sql.append(" AND datum_do = :datumDo");
            params.addValue("datumDo", request.getDatumDo());
        }

        if (request.getDatum() != null) {
            sql.append(" AND datum = :datum");
            params.addValue("datum", request.getDatum());
        }

        return namedJdbcTemplate.query(sql.toString(), params, new BeanPropertyRowMapper<>(EvidencijaSnimkaDto.class));
    }

	public int updateEvidencijaSnimka(EvidencijaSnimkaRequest request) {
        var sql = """
            UPDATE evidencija_snimka
            SET
                datum_od = :datumOd,
                datum_do = :datumDo,
                radnik_fk = :radnikFk,
                snimka = :snimka,
                datum = CURRENT_TIMESTAMP
            WHERE
                id_evidencija_snimka = :idEvidencijaSnimka
        """;

        var params = new MapSqlParameterSource()
            .addValue("datumOd", request.getDatumOd())
            .addValue("datumDo", request.getDatumDo())
            .addValue("radnikFk", request.getRadnikFk())
            .addValue("snimka", request.getSnimka())
            .addValue("idEvidencijaSnimka", request.getIdEvidencijaSnimka());

        return namedJdbcTemplate.update(sql, params);
    }

	public int deleteEvidencijaSnimka(Integer id) {
        var sql = """
            DELETE FROM evidencija_snimka
            WHERE id_evidencija_snimka = :id
        """;

        var params = new MapSqlParameterSource()
            .addValue("id", id);

        return namedJdbcTemplate.update(sql, params);
    }
}
