package hr.tvz.hrsustav.dto;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RadnikDto {

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

	@Schema(description = "Spol radnika", example = "M")
	private String spol;

	@Schema(description = "Datum rođenja radnika", example = "2003-10-18")
	private Date datumRod;

	@Schema(description = "Naziv vrste radnika", example = "Vlastiti")
	private String radnikVrstaNaziv;

	@Schema(description = "ID odjela kojem radnik pripada", example = "1")
	private Integer odjelFk;

	@Schema(description = "ID ugovora o radu radnika", example = "1")
	private Integer idUgovorRad;

	@Schema(description = "Početni datum dodjele radnika u odjel", example = "2025-05-17")
	private Date datumOdRadnikOdjel;

	@Schema(description = "Početni datum ugovora o radu", example = "2025-07-02")
	private Date datumOdUgovorRad;
}