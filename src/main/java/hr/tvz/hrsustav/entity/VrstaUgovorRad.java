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
public class VrstaUgovorRad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Jedinstveni identifikator vrste ugovora", example = "1")
	private Integer idVrstaUgovorRad;
	@Schema(description = "Naziv vrste ugovora", example = "Rad na neodređeno vrijeme")
	private String naziv;
}