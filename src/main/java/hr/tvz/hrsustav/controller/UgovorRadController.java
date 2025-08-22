package hr.tvz.hrsustav.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.UgovorRad;
import hr.tvz.hrsustav.service.UgovorRadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ugovor-rad")
@AllArgsConstructor
public class UgovorRadController {

	private final UgovorRadService ugovorRadService;

	@Operation(
		summary = "Kreiraj novi ugovor o radu",
		description = "Dodaje novi ugovor o radu u sustav. Polje 'idUgovorRad' mora biti null jer se generira automatski."
	)
	@ApiResponse(
		responseCode = "204",
		description = "Ugovor o radu uspješno kreiran")
	@PostMapping
	public ResponseEntity<Void> createUgovorRad(@RequestBody UgovorRad ugovorRad) {
		ugovorRad.setIdUgovorRad(null);
		ugovorRadService.createUgovorRad(ugovorRad);
		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Dohvati sve ugovore o radu",
		description = "Vraća listu svih ugovora o radu filtriranu po zadanim parametrima.")
	@ApiResponse(
		responseCode = "200",
		description = "Lista ugovora o radu dohvaćena")
	@GetMapping
	public ResponseEntity<Object> getAllUgovorRad(UgovorRadGetRequest request) {
		return ResponseEntity.ok().body(ugovorRadService.getAllUgovorRad(request));
	}

	@Operation(
		summary = "Ažuriraj ugovor o radu",
		description = "Ažurira podatke postojećeg ugovora o radu. 'idUgovorRad' mora biti postavljen.")
	@ApiResponse(
		responseCode = "204",
		description = "Ugovor o radu uspješno ažuriran")
	@PutMapping
	public ResponseEntity<Void> updateUgovorRad(@RequestBody UgovorRad ugovorRad) {
		ugovorRadService.updateUgovorRad(ugovorRad);
		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Obriši ugovor o radu",
		description = "Briše ugovor o radu s određenim ID-em iz sustava.")
	@ApiResponse(
		responseCode = "204", 
		description = "Ugovor o radu uspješno obrisan")
	@DeleteMapping
	public ResponseEntity<Void> deleteUgovorRad(
		@Parameter(description = "ID ugovora o radu koji se briše", required = true) @RequestParam Integer id
	) {
		ugovorRadService.deleteUgovorRad(id);
		return ResponseEntity.noContent().build();
	}
}