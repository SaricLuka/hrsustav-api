package hr.tvz.hrsustav.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.entity.Spol;
import hr.tvz.hrsustav.service.SpolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/spol")
@AllArgsConstructor
public class SpolController {

	private final SpolService spolService;

	@Operation(
		summary = "Dohvati sve spolove",
		description = "Vraća popis svih spolova iz baze podataka."
	)
	@ApiResponse(
		responseCode = "200",
		description = "Popis spolova uspješno dohvaćen."
	)
	@GetMapping
	public ResponseEntity<List<Spol>> getAllSpol() {

		return ResponseEntity.ok().body(spolService.getAllSpol());
	}
}