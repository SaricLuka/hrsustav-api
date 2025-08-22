package hr.tvz.hrsustav.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Mjesto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Jedinstveni identifikator mjesta", example = "1")
	private Integer idMjesto;
	@Schema(description = "Naziv mjesta", example = "Zagreb")
	private String naziv;
	@Schema(description = "Poštanski broj", example = "10000")
	private String postBr;
	@ManyToOne
	@JoinColumn(name = "drzava_fk")
	@Schema(description = "Država kojoj mjesto pripada")
	private Drzava drzavaFk;
}