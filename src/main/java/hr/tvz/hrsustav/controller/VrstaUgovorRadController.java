package hr.tvz.hrsustav.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.entity.VrstaUgovorRad;
import hr.tvz.hrsustav.service.VrstaUgovorRadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/vrsta-ugovor-rad")
@AllArgsConstructor
public class VrstaUgovorRadController {

	private final VrstaUgovorRadService vrstaUgovorRadService;

	@Operation(
		summary = "Dohvati sve vrste ugovora o radu",
		description = "Vraća popis svih dostupnih vrsta ugovora o radu iz sustava."
	)
	@ApiResponse(
		responseCode = "200",
		description = "Uspješno dohvaćen popis vrsta ugovora o radu")
	@GetMapping
	public ResponseEntity<List<VrstaUgovorRad>> getAllVrstaUgovorRad() {

		return ResponseEntity.ok().body(vrstaUgovorRadService.getAllVrstaUgovorRad());
	}
}