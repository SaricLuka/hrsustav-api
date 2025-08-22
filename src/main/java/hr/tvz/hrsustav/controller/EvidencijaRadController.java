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

import hr.tvz.hrsustav.entity.EvidencijaRad;
import hr.tvz.hrsustav.service.EvidencijaRadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/evidencija-rad")
@AllArgsConstructor
public class EvidencijaRadController {

	private final EvidencijaRadService evidencijaRadService;

	@Operation(
		summary = "Dodaj evidenciju rada",
		description = "Kreira novu evidenciju radnog dana za određenog radnika.")
	@ApiResponse(
		responseCode = "204",
		description = "Evidencija rada uspješno kreirana")
	@PostMapping
	public ResponseEntity<Void> createEvidencijaRad(@RequestBody EvidencijaRad evidencijaRad) {
		evidencijaRad.setIdEvidencijaRad(null);

		evidencijaRadService.createEvidencijaRad(evidencijaRad);
		
		return ResponseEntity.noContent().build();
	}
	
	@Operation(
		summary = "Dohvati evidenciju rada po radniku i datumu",
		description = "Vraća sve zapise evidencije rada za odabranog radnika između dva datuma.")
	@ApiResponse(
		responseCode = "200",
		description = "Evidencija rada uspješno dohvaćena")
	@GetMapping
	public ResponseEntity<List<EvidencijaRad>> getEvidencijaRad(
			@Parameter(description = "ID radnika", example = "1") @RequestParam Integer radnikFk,
			@Parameter(description = "Početni datum (yyyy-MM-dd)", example = "2024-07-01") @RequestParam Date datumStart,
			@Parameter(description = "Završni datum (yyyy-MM-dd)", example = "2024-07-31") @RequestParam Date datumEnd) {

		return ResponseEntity.ok().body(evidencijaRadService.getEvidencijaRad(radnikFk, datumStart, datumEnd));
	}

	@Operation(
		summary = "Ažuriraj evidenciju rada",
		description = "Ažurira podatke postojeće evidencije rada."
	)
	@ApiResponse(responseCode = "204", description = "Evidencija rada uspješno ažurirana")
	@PutMapping
	public ResponseEntity<Void> updateEvidencijaRad(@RequestBody EvidencijaRad evidencijaRad) {
		
		evidencijaRadService.updateEvidencijaRad(evidencijaRad);
		
		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Obriši evidenciju rada",
		description = "Briše evidenciju rada prema ID-u."
	)
	@ApiResponse(responseCode = "204", description = "Evidencija rada uspješno obrisana")
	@DeleteMapping
	public ResponseEntity<Void> deleteEvidencijaRad(@RequestParam Integer id){

		evidencijaRadService.deleteEvidencijaRad(id);

		return ResponseEntity.noContent().build();
	}
}
