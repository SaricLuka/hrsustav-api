package hr.tvz.hrsustav.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.dto.request.EvidencijaSnimkaRequest;
import hr.tvz.hrsustav.service.EvidencijaSnimkaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/evidencija-snimka")
@AllArgsConstructor
public class EvidencijaSnimkaController {

	private final EvidencijaSnimkaService evidencijaSnimkaService;

	@Operation(
		summary = "Kreiraj evidenciju snimke",
		description = "Dodaje novu evidenciju snimke za radnika. ID se automatski generira.")
	@ApiResponse(
		responseCode = "204",
		description = "Evidencija snimke uspješno kreirana")
	@PostMapping
	public ResponseEntity<Void> createEvidencijaSnimka(@RequestBody EvidencijaSnimkaRequest evidencijaSnimka) {
		evidencijaSnimka.setIdEvidencijaSnimka(null);

		evidencijaSnimkaService.createEvidencijaSnimka(evidencijaSnimka);
		
		return ResponseEntity.noContent().build();
	}
	
	@Operation(
		summary = "Dohvati evidencije snimki",
		description = "Vraća popis evidencija snimki prema zadanim parametrima (svi su opcionalni).")
	@ApiResponse(
		responseCode = "200",
		description = "Evidencije snimki uspješno dohvaćene")
	@GetMapping
	public ResponseEntity<List<EvidencijaSnimkaDto>> getEvidencijaSnimka(
		@Parameter(description = "ID evidencije snimke", example = "1") @RequestParam(required = false) Integer idEvidencijaSnimka,
		@Parameter(description = "Početni datum", example = "2024-07-01") @RequestParam(required = false) Date datumOd,
		@Parameter(description = "Završni datum", example = "2024-07-31") @RequestParam(required = false) Date datumDo,
		@Parameter(description = "ID radnika", example = "1") @RequestParam(required = false) Integer radnikFk,
		@Parameter(description = "Datum snimanja", example = "2024-07-15") @RequestParam(required = false) Date datum){

		var evidencijaSnimka = new EvidencijaSnimkaRequest(
			idEvidencijaSnimka,
			datumOd,
			datumDo,
			radnikFk,
			null,
			datum);

		return ResponseEntity.ok().body(evidencijaSnimkaService.getEvidencijaSnimka(evidencijaSnimka));
	}

	@Operation(
		summary = "Ažuriraj evidenciju snimke",
		description = "Ažurira postojeću evidenciju snimke.")
	@ApiResponse(
		responseCode = "204",
		description = "Evidencija snimke uspješno ažurirana")
	@PutMapping
	public ResponseEntity<Void> updateEvidencijaSnimka(@RequestBody EvidencijaSnimkaRequest evidencijaSnimka) {
		
		evidencijaSnimkaService.updateOdjel(evidencijaSnimka);
		
		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Obriši evidenciju snimke",
		description = "Briše evidenciju snimke na temelju ID-a.")
	@ApiResponse(
		responseCode = "204",
		description = "Evidencija snimke uspješno obrisana")
	@DeleteMapping
	public ResponseEntity<Void> deleteEvidencijaSnimka(@RequestParam Integer id){

		evidencijaSnimkaService.deleteOdjel(id);

		return ResponseEntity.noContent().build();
	}
}