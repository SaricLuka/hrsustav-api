package hr.tvz.hrsustav.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.entity.RadnikVrsta;
import hr.tvz.hrsustav.service.RadnikVrstaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/radnik-vrsta")
@AllArgsConstructor
public class RadnikVrstaController {

	private final RadnikVrstaService radnikVrstaService;

	@Operation(
		summary = "Dohvati sve vrste radnika",
		description = "Vraća popis svih vrsta radnika iz baze podataka."
	)
	@ApiResponse(
		responseCode = "200",
		description = "Popis vrsta radnika uspješno dohvaćen"
	)
	@GetMapping
	public ResponseEntity<List<RadnikVrsta>> getAllRadnikVrsta() {

		return ResponseEntity.ok().body(radnikVrstaService.getAllRadnikVrsta());
	}
}