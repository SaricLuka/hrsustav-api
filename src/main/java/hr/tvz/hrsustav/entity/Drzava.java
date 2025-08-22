package hr.tvz.hrsustav.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Drzava {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Jedinstveni identifikator države", example = "1")
	private Integer idDrzava;
	@Schema(description = "Naziv države", example = "Hrvatska")
	private String naziv;
	@Schema(description = "Oznaka države", example = "HR")
	private String oznaka;
}