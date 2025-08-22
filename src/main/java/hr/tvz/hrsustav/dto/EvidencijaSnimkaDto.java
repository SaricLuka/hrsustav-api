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
public class EvidencijaSnimkaDto {

	@Schema(description = "ID evidencije snimke", example = "1")
	private Integer idEvidencijaSnimka;
	@Schema(description = "Datum početka", example = "2024-07-01")
	private Date datumOd;
	@Schema(description = "Datum završetka", example = "2024-07-31")
	private Date datumDo;
	@Schema(description = "ID radnika", example = "1")
	private Integer radnikFk;
	@Schema(description = "Snimka u binarnom formatu", example = "BINARY_DATA")
	private byte[] snimka;
	@Schema(description = "Točan datum snimanja", example = "2024-07-15")
	private Date datum;
}
