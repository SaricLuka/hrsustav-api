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

import hr.tvz.hrsustav.entity.RadnoMjesto;
import hr.tvz.hrsustav.service.RadnoMjestoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/radno-mjesto")
@AllArgsConstructor
public class RadnoMjestoController {

	private final RadnoMjestoService radnoMjestoService;

	@Operation(
		summary = "Kreiraj novo radno mjesto",
		description = "Dodaje novo radno mjesto u sustav. ID se automatski generira."
	)
	@ApiResponse(
		responseCode = "204",
		description = "Radno mjesto uspješno kreirano"
	)
	@PostMapping
	public ResponseEntity<Void> createRadnoMjesto(@RequestBody RadnoMjesto radnoMjesto) {
		radnoMjesto.setIdRadnoMjesto(null);

		radnoMjestoService.createRadnoMjesto(radnoMjesto);

		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Dohvati sva radna mjesta",
		description = "Vraća popis svih radnih mjesta iz baze podataka."
	)
	@ApiResponse(
		responseCode = "200",
		description = "Popis radnih mjesta uspješno dohvaćen"
	)
	@GetMapping
	public ResponseEntity<List<RadnoMjesto>> getAllRadnoMjesto() {

		return ResponseEntity.ok().body(radnoMjestoService.getAllRadnoMjesto());
	}

	@Operation(
		summary = "Ažuriraj postojeće radno mjesto",
		description = "Ažurira podatke postojećeg radnog mjesta na temelju ID-a."
	)
	@ApiResponse(
		responseCode = "204",
		description = "Radno mjesto uspješno ažurirano"
	)
	@PutMapping
	public ResponseEntity<Void> updateRadnoMjesto(@RequestBody RadnoMjesto radnoMjesto) {

		radnoMjestoService.updateRadnoMjesto(radnoMjesto);

		return ResponseEntity.noContent().build();
	}

	@Operation(
		summary = "Obriši radno mjesto",
		description = "Briše radno mjesto na temelju ID-a."
	)
	@ApiResponse(
		responseCode = "204",
		description = "Radno mjesto uspješno obrisano"
	)
	@DeleteMapping
	public ResponseEntity<Void> deleteRadnoMjesto(@RequestParam Integer id) {

		radnoMjestoService.deleteRadnoMjesto(id);

		return ResponseEntity.noContent().build();
	}
}