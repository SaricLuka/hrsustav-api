package hr.tvz.hrsustav.controller;

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

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.dto.request.RadnikOdjelRequest;
import hr.tvz.hrsustav.service.RadnikOdjelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/radnik-odjel")
@AllArgsConstructor
public class RadnikOdjelController {

	private final RadnikOdjelService radnikOdjelService;

	@Operation(
		summary = "Dodaj vezu radnika i odjela",
		description = "Kreira novu poveznicu između radnika i odjela. ID se automatski generira.")
	@ApiResponse(
		responseCode = "204", 
		description = "Veza uspješno kreirana")
	@PostMapping
	public ResponseEntity<Void> createRadnikOdjel(@RequestBody RadnikOdjelRequest radnikOdjel) {
		radnikOdjel.setIdRadnikOdjel(null);

		radnikOdjelService.createRadnikOdjel(radnikOdjel);
		
		return ResponseEntity.noContent().build();
	}
	
	@Operation(
		summary = "Dohvati odjele po radniku",
		description = "Vraća popis svih odjela u kojima je radnik radio."
	)
	@ApiResponse(
		responseCode = "200",
		description = "Podaci uspješno dohvaćeni"
	)
	@GetMapping("/by-radnik")
	public ResponseEntity<List<RadnikOdjelDto>> getRadnikOdjelbyRadnik(@RequestParam Integer id) {

		return ResponseEntity.ok().body(radnikOdjelService.getRadnikOdjelbyRadnik(id));
	}

	@Operation(
		summary = "Dohvati radnike po odjelu",
		description = "Vraća popis svih radnika koji su radili u odjelu.")
	@ApiResponse(
		responseCode = "200",
		description = "Podaci uspješno dohvaćeni")
	@GetMapping("/by-odjel")
	public ResponseEntity<List<RadnikOdjelDto>> getRadnikOdjelbyOdjel(@RequestParam Integer id) {

		return ResponseEntity.ok().body(radnikOdjelService.getRadnikOdjelbyOdjel(id));
	}

	@Operation(
		summary = "Ažuriraj vezu radnik-odjel",
		description = "Ažurira podatke o vezi radnika i odjela.")
	@ApiResponse(
		responseCode = "204",
		description = "Veza uspješno ažurirana")
	@PutMapping
	public ResponseEntity<Void> updateRadnikOdjel(@RequestBody RadnikOdjelRequest radnikOdjel) {
		
		radnikOdjelService.updateRadnikOdjel(radnikOdjel);
		
		return ResponseEntity.noContent().build();
	}

	@Operation(
	summary = "Obriši vezu radnik-odjel",
	description = "Briše vezu između radnika i odjela prema ID-u.")
	@ApiResponse(
		responseCode = "204",
		description = "Veza uspješno obrisana")
	@DeleteMapping
	public ResponseEntity<Void> deleteRadnikOdjel(@RequestParam Integer id){

		radnikOdjelService.deleteRadnikOdjel(id);

		return ResponseEntity.noContent().build();
	}
}