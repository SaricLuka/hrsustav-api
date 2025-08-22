package hr.tvz.hrsustav.dto.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class RadnikGetRequest {
	private Integer idRadnik;
	private Integer radnikNadredFk;
	private String ime;
	private String prezime;
	private String oib;
	private Integer spolFk;
	private Date datumRod;
	private Integer radnikVrstaFk;
	private Integer odjelFk;
	private Integer idUgovorRad;
	private Boolean inOdjel;
	private Boolean isZaposlen;
}
