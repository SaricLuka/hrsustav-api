package hr.tvz.hrsustav.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.hrsustav.entity.Mjesto;
import hr.tvz.hrsustav.service.MjestoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/mjesto")
@AllArgsConstructor
public class MjestoController {

	private final MjestoService mjestoService;

	@Operation(
		summary = "Dohvati sva mjesta",
		description = "Vraća popis svih mjesta iz baze podataka."
	)
	@ApiResponse(
		responseCode = "200",
		description = "Popis mjesta uspješno dohvaćen"
	)
	@GetMapping
	public ResponseEntity<List<Mjesto>> getAllMjesto() {

		return ResponseEntity.ok().body(mjestoService.getAllSpol());
	}
}