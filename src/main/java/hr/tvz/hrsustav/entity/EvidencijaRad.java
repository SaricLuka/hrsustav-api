package hr.tvz.hrsustav.entity;

import java.sql.Date;
import java.sql.Time;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
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
public class EvidencijaRad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Jedinstveni identifikator evidencije rada", example = "1")
	private Integer idEvidencijaRad;
	@Schema(description = "ID radnika", example = "1")
	private Integer radnikFk;
	@Schema(description = "Datum evidencije", example = "2024-07-01")
	private Date datum;
	@Schema(description = "Vrijeme početka rada", example = "08:00:00")
	private Time pocetak;
	@Schema(description = "Vrijeme završetka rada", example = "16:00:00")
	private Time kraj;
	@Schema(description = "Ukupno redovnih sati", example = "8.0")
	private Double ukupnoRedovno;
	@Schema(description = "Redovni rad", example = "8.0")
	private Double redovno;
	@Schema(description = "Prekovremeni rad", example = "0.0")
	private Double prekovr;
	@Schema(description = "Sati zastoja", example = "0.0")
	private Double zastoj;
	@Schema(description = "Sati u štrajku", example = "0.0")
	private Double strajk;
	@Schema(description = "Sati u lockoutu", example = "0.0")
	private Double lockout;
	@Schema(description = "Preraspodijeljeni sati", example = "0.0")
	private Double prerasp;
	@Schema(description = "Bolovanje do 42 dana", example = "0.0")
	@Column(name = "bol_do_42")
	private Double bolDo42;
	@Schema(description = "Bolovanje preko 42 dana", example = "0.0")
	@Column(name = "bol_od_42")
	private Double bolOd42;
	@Schema(description = "Godisnji odmor (neplaćeni)", example = "0.0")
	private Double godisnji;
	@Schema(description = "Plaćeni godišnji odmor", example = "0.0")
	private Double godisnjiPlacen;
	@Schema(description = "Rad na praznik", example = "0.0")
	private Double praznik;
	@Schema(description = "Ukupno sati u danu", example = "8.0")
	private Double ukupnoSati;
	@Schema(description = "Rad nedjeljom - povećanje", example = "0.0")
	private Double nedjeljaPov;
	@Schema(description = "Rad praznikom - povećanje", example = "0.0")
	private Double praznikPov;
	@Schema(description = "Noćni rad - povećanje", example = "0.0")
	private Double nocPov;
	@Schema(description = "Rad u smjenama - povećanje", example = "0.0")
	private Double smjenaPov;
	@Schema(description = "Dvokratni rad - povećanje", example = "0.0")
	private Double dvokrPov;
	@Schema(description = "Ostalo - povećanje", example = "0.0")
	private Double ostaloPov;
	@Schema(description = "Sati pripravnosti", example = "0.0")
	private Double pripr;
	@Schema(description = "Sati odmora", example = "0.0")
	private Double odmor;
	@Schema(description = "Sati odsutnosti", example = "0.0")
	private Double odsut;
}