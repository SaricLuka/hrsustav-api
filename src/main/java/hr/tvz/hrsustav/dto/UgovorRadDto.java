package hr.tvz.hrsustav.dto;

import java.math.BigDecimal;
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
public class UgovorRadDto {
	@Schema(description = "Jedinstveni identifikator ugovora o radu", example = "1")
	private Integer idUgovorRad;

	@Schema(description = "ID radnika na kojeg se ugovor odnosi", example = "1")
	private Integer radnikFk;

	@Schema(description = "Datum sklapanja ugovora", example = "2024-01-15")
	private Date datumUgovor;

	@Schema(description = "Datum početka rada", example = "2024-02-01")
	private Date datumOd;

	@Schema(description = "Datum završetka ugovora (ako postoji)", example = "2025-02-01")
	private Date datumDo;

	@Schema(description = "ID mjesta rada", example = "3")
	private Integer mjestoRadaFk;

	@Schema(description = "ID radnog mjesta", example = "5")
	private Integer radnoMjestoFk;

	@Schema(description = "ID vrste radnog vremena (npr. puno, nepuno)", example = "1")
	private Integer radnoVrijemeFk;

	@Schema(description = "ID dodatne kategorije radnog vremena", example = "2")
	private Integer vrstaRadnoVrijemeFk;

	@Schema(description = "Broj radnih sati tjedno", example = "40.0")
	private Double tjednoSati;

	@Schema(description = "Broj radnih sati dnevno", example = "8.0")
	private Double dnevnoSati;

	@Schema(description = "Broj dana godišnjeg odmora", example = "20")
	private Integer godisnji;

	@Schema(description = "ID vrste ugovora (npr. na neodređeno, na određeno)", example = "1")
	private Integer vrstaUgovorRadFk;

	@Schema(description = "Bruto plaća izražena u eurima", example = "1320.50")
	private BigDecimal brutoPlaca;
}