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
public class RadnikOdjelDto {
	@Schema(description = "ID veze radnik-odjel", example = "1")
	private Integer idRadnikOdjel;
	@Schema(description = "ID radnika", example = "10")
	private Integer radnikFk;
	@Schema(description = "Naziv odjela", example = "Financije")
	private String nazivOdjela;
	@Schema(description = "Datum početka", example = "2024-01-01")
	private Date datumOd;
	@Schema(description = "Datum završetka", example = "2024-12-31")
	private Date datumDo;
}
