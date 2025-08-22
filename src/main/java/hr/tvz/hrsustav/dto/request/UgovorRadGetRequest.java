package hr.tvz.hrsustav.dto.request;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UgovorRadGetRequest {
	@Schema(description = "Filtriraj po ID-u ugovora o radu", example = "1")
	private Integer idUgovorRad;

	@Schema(description = "Filtriraj po ID-u radnika", example = "1")
	private Integer radnikFk;

	@Schema(description = "Početni datum za filtriranje po datumu sklapanja ugovora", example = "2024-01-01")
	private Date datumUgovorFrom;

	@Schema(description = "Završni datum za filtriranje po datumu sklapanja ugovora", example = "2024-12-31")
	private Date datumUgovorTo;

	@Schema(description = "Početni datum za filtriranje po datumu početka rada", example = "2024-02-01")
	private Date datumFrom;

	@Schema(description = "Završni datum za filtriranje po datumu početka rada", example = "2025-01-01")
	private Date datumTo;

	@Schema(description = "Filtriraj po ID-u radnog mjesta", example = "1")
	private Integer radnoMjestoFk;
}