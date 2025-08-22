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

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;
import hr.tvz.hrsustav.service.RadnikPrebivalisteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/radnik-prebivaliste")
@AllArgsConstructor
public class RadnikPrebivalisteController {

	private final RadnikPrebivalisteService radnikPrebivalisteService;

	@Operation(
		summary = "Kreiraj novu poveznicu radnika i prebivališta",
		description = "Kreira novu poveznicu između radnika i prebivališta. ID poveznice se automatski generira prilikom unosa.")
	@ApiResponse(
		responseCode = "204",
		description = "Poveznica između radnika i prebivališta uspješno kreirana")
	@PostMapping
	public ResponseEntity<Void> createRadnikPrebivaliste(@RequestBody RadnikPrebivaliste radnikPrebivaliste) {
		radnikPrebivaliste.setIdRadnikPrebivaliste(null);
		radnikPrebivalisteService.createRadnikPrebivaliste(radnikPrebivaliste);
		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Dohvati poveznice po ID-u radnika",
		description = "Vraća popis svih prebivališta koja su povezana s određenim radnikom.")
	@ApiResponse(
		responseCode = "200",
		description = "Podaci uspješno dohvaćeni")
	@GetMapping("/by-radnik")
	public ResponseEntity<List<RadnikPrebivaliste>> getRadnikPrebivalisteByRadnik(@RequestParam Integer id) {
		return ResponseEntity.ok().body(radnikPrebivalisteService.getRadnikPrebivalisteByRadnik(id));
	}

	@Operation(
		summary = "Dohvati poveznice po ID-u mjesta",
		description = "Vraća popis svih radnika koji su povezani s određenim prebivalištem.")
	@ApiResponse(
		responseCode = "200",
		description = "Podaci uspješno dohvaćeni")
	@GetMapping("/by-mjesto")
	public ResponseEntity<List<RadnikPrebivaliste>> getRadnikPrebivalisteByMjesto(@RequestParam Integer id) {
		return ResponseEntity.ok().body(radnikPrebivalisteService.getRadnikPrebivalisteByMjesto(id));
	}

	@Operation(
		summary = "Ažuriraj postojeću poveznicu radnik-prebivalište",
		description = "Ažurira podatke o poveznici između radnika i prebivališta.")
	@ApiResponse(
		responseCode = "204",
		description = "Poveznica uspješno ažurirana")
	@PutMapping
	public ResponseEntity<Void> updateRadnikPrebivaliste(@RequestBody RadnikPrebivaliste radnikPrebivaliste) {
		radnikPrebivalisteService.updateRadnikPrebivaliste(radnikPrebivaliste);
		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Obriši poveznicu radnik-prebivalište",
		description = "Briše poveznicu između radnika i prebivališta prema ID-u poveznice.")
	@ApiResponse(
		responseCode = "204",
		description = "Poveznica uspješno obrisana")
	@DeleteMapping
	public ResponseEntity<Void> deleteRadnikPrebivaliste(@RequestParam Integer id) {
		radnikPrebivalisteService.deleteRadnikPrebivaliste(id);
		return ResponseEntity.noContent().build();
	}
}