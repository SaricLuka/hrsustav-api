package hr.tvz.hrsustav.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class RadnoMjesto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Jedinstveni identifikator radnog mjesta", example = "1")
	private Integer idRadnoMjesto;
	@Schema(description = "Naziv radnog mjesta", example = "Developer/ica aplikativnih rješenja")
	private String naziv;
}