package hr.tvz.hrsustav.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.entity.Drzava;
import hr.tvz.hrsustav.service.DrzavaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/drzava")
@AllArgsConstructor
public class DrzavaController {

	private final DrzavaService drzavaService;

	@Operation(
		summary = "Dohvati sve države",
		description = "Vraća popis svih država iz baze podataka."
	)
	@ApiResponse(
		responseCode = "200",
		description = "Popis država uspješno dohvaćen"
	)
	@GetMapping
	public ResponseEntity<List<Drzava>> getAllDrzava() {

		return ResponseEntity.ok().body(drzavaService.getAllDrzava());
	}
}