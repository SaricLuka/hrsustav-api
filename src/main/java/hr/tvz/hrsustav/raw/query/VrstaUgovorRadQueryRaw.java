package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.VrstaUgovorRad;
import hr.tvz.hrsustav.query.VrstaUgovorRadQuery;
import hr.tvz.hrsustav.raw.repository.VrstaUgovorRadRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class VrstaUgovorRadQueryRaw implements VrstaUgovorRadQuery{

	private final VrstaUgovorRadRepositoryR vrstaUgovorRadRepositoryR;

	@Override
	public List<VrstaUgovorRad> getAllVrstaUgovorRad() {
		
		return vrstaUgovorRadRepositoryR.getAllVrstaUgovorRad();
	}
}