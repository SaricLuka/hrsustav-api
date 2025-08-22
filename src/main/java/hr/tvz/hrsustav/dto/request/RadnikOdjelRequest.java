package hr.tvz.hrsustav.dto.request;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RadnikOdjelRequest {
	@Schema(description = "ID veze radnik-odjel (postavlja se na null kod kreiranja)", example = "1")
	private Integer idRadnikOdjel;
	@Schema(description = "ID radnika", example = "1")
	private Integer radnikFk;
	@Schema(description = "ID odjela", example = "1")
	private Integer odjelFk;
	@Schema(description = "Datum početka", example = "2024-01-01")
	private Date datumOd;
	@Schema(description = "Datum završetka", example = "2024-12-31")
	private Date datumDo;
}