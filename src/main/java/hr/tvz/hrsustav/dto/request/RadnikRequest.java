package hr.tvz.hrsustav.dto.request;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RadnikRequest {
    @Schema(description = "ID radnika", example = "1")
    private Integer idRadnik;

    @Schema(description = "ID nadređenog radnika", example = "2")
    private Integer radnikNadredFk;

    @Schema(description = "Ime radnika", example = "Luka")
    private String ime;

    @Schema(description = "Prezime radnika", example = "Šarić")
    private String prezime;

    @Schema(description = "OIB radnika", example = "84789698705")
    private String oib;

    @Schema(description = "ID za spol radnika (Spol)", example = "1")
    private Integer spolFk;

    @Schema(description = "Datum rođenja radnika", example = "2003-10-18")
    private Date datumRod;

    @Schema(description = "ID vrste radnika", example = "1")
    private Integer radnikVrstaFk;
}