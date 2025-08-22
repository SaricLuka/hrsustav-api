package hr.tvz.hrsustav.hibernate.summary;

import java.math.BigDecimal;
import java.sql.Date;

public interface UgovorRadSummary {
    Integer getIdUgovorRad();
    Integer getRadnikFk();
    Date getDatumUgovor();
    Date getDatumOd();
    Date getDatumDo();
    Integer getMjestoRadaFk();
    Integer getRadnoMjestoFk();

    Integer getRadnoVrijemeFkIdRadnoVrijeme();
    Double getRadnoVrijemeFkTjednoSati();
    Double getRadnoVrijemeFkDnevnoSati();
    Integer getRadnoVrijemeFkGodisnji();
    Integer getRadnoVrijemeFkVrstaRadnoVrijemeFk();

    Integer getVrstaUgovorRadFk();
    BigDecimal getBrutoPlaca();
}