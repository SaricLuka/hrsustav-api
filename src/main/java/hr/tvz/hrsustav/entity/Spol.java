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
public class Spol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Jedinstveni identifikator spola", example = "1")
	private Integer idSpol;
	@Schema(description = "Oznaka spola", example = "M")
	private String oznaka;
}