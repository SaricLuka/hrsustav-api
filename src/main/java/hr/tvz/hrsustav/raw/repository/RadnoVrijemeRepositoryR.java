package hr.tvz.hrsustav.raw.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.entity.UgovorRad;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class RadnoVrijemeRepositoryR {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int createRadnoVrijeme(UgovorRad ugovorRad) {
        var sql = """
                INSERT INTO radno_vrijeme (
                    vrsta_radno_vrijeme_fk,
                    tjedno_sati,
                    dnevno_sati,
                    godisnji
                ) VALUES (
                    :vrstaRadnoVrijemeFk,
                    :tjednoSati,
                    :dnevnoSati,
                    :godisnji
                )
                """;

        var params = new MapSqlParameterSource()
                .addValue("vrstaRadnoVrijemeFk", ugovorRad.getRadnoVrijemeFk().getVrstaRadnoVrijemeFk())
                .addValue("tjednoSati", ugovorRad.getRadnoVrijemeFk().getTjednoSati())
                .addValue("dnevnoSati", ugovorRad.getRadnoVrijemeFk().getDnevnoSati())
                .addValue("godisnji", ugovorRad.getRadnoVrijemeFk().getGodisnji());

        var keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, params, keyHolder, new String[] { "id_radno_vrijeme" });

        var generatedId = keyHolder.getKey();
        if (generatedId != null) {
            ugovorRad.getRadnoVrijemeFk().setIdRadnoVrijeme(generatedId.intValue());
            return generatedId.intValue();
        }
        return 0;
    }

    public int updateRadnoVrijeme(UgovorRad ugovorRad) {
        var sql = """
                UPDATE radno_vrijeme SET
                    vrsta_radno_vrijeme_fk = :vrstaRadnoVrijemeFk,
                    tjedno_sati = :tjednoSati,
                    dnevno_sati = :dnevnoSati,
                    godisnji = :godisnji
                WHERE id_radno_vrijeme = :idRadnoVrijeme
                """;

        var params = new MapSqlParameterSource()
                .addValue("vrstaRadnoVrijemeFk", ugovorRad.getRadnoVrijemeFk().getVrstaRadnoVrijemeFk())
                .addValue("tjednoSati", ugovorRad.getRadnoVrijemeFk().getTjednoSati())
                .addValue("dnevnoSati", ugovorRad.getRadnoVrijemeFk().getDnevnoSati())
                .addValue("godisnji", ugovorRad.getRadnoVrijemeFk().getGodisnji())
                .addValue("idRadnoVrijeme", ugovorRad.getRadnoVrijemeFk().getIdRadnoVrijeme());

        return namedParameterJdbcTemplate.update(sql, params);
    }
}
