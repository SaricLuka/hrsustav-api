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

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.dto.request.RadnikRequest;
import hr.tvz.hrsustav.service.RadnikService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/radnik")
@AllArgsConstructor
public class RadnikController {

	private final RadnikService radnikService;

	@Operation(
		summary = "Kreiraj novog radnika",
		description = "Dodaje novog radnika u sustav. Polje 'idRadnik' mora biti null jer se generira automatski.")
	@ApiResponse(
		responseCode = "204",
		description = "Radnik uspješno kreiran")
	@PostMapping
	public ResponseEntity<Void> createRadnik(@RequestBody RadnikRequest radnik) {
		radnik.setIdRadnik(null);

		radnikService.createRadnik(radnik);

		return ResponseEntity.noContent().build();
	}
	
	@Operation(
		summary = "Dohvati sve radnike",
		description = "Vraća listu svih radnika filtriranu po zadanim parametrima.")
	@ApiResponse(
		responseCode = "200",
		description = "Lista radnika dohvaćena")
	@GetMapping
	public ResponseEntity<List<RadnikDto>> getAllRadnik(RadnikGetRequest request) {

		return ResponseEntity.ok().body(radnikService.getAllRadnik(request));
	}

	@Operation(
		summary = "Ažuriraj radnika",
		description = "Ažurira podatke postojećeg radnika. 'idRadnik' mora biti popunjen.")
	@ApiResponse(
		responseCode = "204",
		description = "Radnik uspješno ažuriran")
	@PutMapping
	public ResponseEntity<Void> updateRadnik(@RequestBody RadnikRequest radnik) {

		radnikService.updateRadnik(radnik);

		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Obriši radnika",
		description = "Briše radnika s određenim ID-em iz sustava."
	)
	@ApiResponse(
		responseCode = "204", 
		description = "Radnik uspješno obrisan")
	@DeleteMapping
	public ResponseEntity<Void> deleteRadnik(@RequestParam Integer id){

		radnikService.deleteRadnik(id);

		return ResponseEntity.noContent().build();
	}
}