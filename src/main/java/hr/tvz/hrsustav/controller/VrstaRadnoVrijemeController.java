package hr.tvz.hrsustav.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.entity.VrstaRadnoVrijeme;
import hr.tvz.hrsustav.service.VrstaRadnoVrijemeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/vrsta-radno-vrijeme")
@AllArgsConstructor
public class VrstaRadnoVrijemeController {

	private final VrstaRadnoVrijemeService vrstaRadnoVrijemeService;

	@Operation(
		summary = "Dohvati sve vrste radnog vremena",
		description = "Vraća popis svih vrsta radnog vremena iz baze podataka."
	)
	@ApiResponse(
		responseCode = "200",
		description = "Popis vrsta radnog vremena uspješno dohvaćen."
	)
	@GetMapping
	public ResponseEntity<List<VrstaRadnoVrijeme>> getAllVrstaRadnoVrijeme() {

		return ResponseEntity.ok().body(vrstaRadnoVrijemeService.getAllVrstaRadnoVrijeme());
	}
}