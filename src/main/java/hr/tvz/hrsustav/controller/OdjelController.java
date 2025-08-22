package hr.tvz.hrsustav.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.entity.Odjel;
import hr.tvz.hrsustav.service.OdjelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/odjel")
@AllArgsConstructor
public class OdjelController {
	
	private final OdjelService odjelService;

	@Operation(
		summary = "Kreiraj novi odjel",
		description = "Dodaje novi odjel u sustav. ID se automatski generira.")
	@ApiResponse(
		responseCode = "204",
		description = "Odjel uspješno kreiran")
	@PostMapping
	public ResponseEntity<Void> createOdjel(@RequestBody Odjel odjel) {
		odjel.setIdOdjel(null);

		odjelService.createOdjel(odjel);
		
		return ResponseEntity.noContent().build();
	}
	
	@Operation(
		summary = "Dohvati sve odjele",
		description = "Vraća popis svih odjela iz baze podataka.")
	@ApiResponse(
		responseCode = "200",
		description = "Popis odjela uspješno dohvaćen")
	@GetMapping
	public ResponseEntity<List<Odjel>> getAllOdjel() {

		return ResponseEntity.ok().body(odjelService.getAllOdjel());
	}

	@Operation(
		summary = "Ažuriraj postojeći odjel",
		description = "Ažurira podatke postojećeg odjela prema ID-u.")
	@ApiResponse(
		responseCode = "204",
		description = "Odjel uspješno ažuriran")
	@PutMapping
	public ResponseEntity<Void> updateOdjel(@RequestBody Odjel odjel) {
		
		odjelService.updateOdjel(odjel);
		
		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Obriši odjel",
		description = "Briše odjel prema ID-u.")
	@ApiResponse(
		responseCode = "204",
		description = "Odjel uspješno obrisan")
	@DeleteMapping
	public ResponseEntity<Void> deleteOdjel(@RequestParam Integer id){

		odjelService.deleteOdjel(id);

		return ResponseEntity.noContent().build();
	}
}