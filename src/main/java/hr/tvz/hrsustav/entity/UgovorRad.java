package hr.tvz.hrsustav.entity;

import java.math.BigDecimal;
import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class UgovorRad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Schema(description = "ID mjesta rada", example = "1")
	private Integer mjestoRadaFk;

	@Schema(description = "ID radnog mjesta", example = "1")
	private Integer radnoMjestoFk;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "radno_vrijeme_fk")
	@Schema(description = "Podaci o radnom vremenu povezani s ugovorom")
	private RadnoVrijeme radnoVrijemeFk;

	@Schema(description = "ID vrste ugovora (npr. na neodređeno, na određeno)", example = "1")
	private Integer vrstaUgovorRadFk;

	@Schema(description = "Bruto plaća izražena u eurima", example = "1320.50")
	private BigDecimal brutoPlaca;
}