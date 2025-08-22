package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.VrstaRadnoVrijeme;
import hr.tvz.hrsustav.query.VrstaRadnoVrijemeQuery;
import hr.tvz.hrsustav.raw.repository.VrstaRadnoVrijemeRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class VrstaRadnoVrijemeQueryRaw implements VrstaRadnoVrijemeQuery {

	private final VrstaRadnoVrijemeRepositoryR vrstaRadnoVrijemeRepositoryR;

	@Override
	public List<VrstaRadnoVrijeme> getAllVrstaRadnoVrijeme() {

		return vrstaRadnoVrijemeRepositoryR.getAllVrstaRadnoVrijeme();
	}
}