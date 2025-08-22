package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.RadnoMjesto;
import hr.tvz.hrsustav.query.RadnoMjestoQuery;
import hr.tvz.hrsustav.raw.repository.RadnoMjestoRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class RadnoMjestoQueryRaw implements RadnoMjestoQuery{

	private final RadnoMjestoRepositoryR radnoMjestoRepositoryR;

	@Override
	public int createRadnoMjesto(RadnoMjesto radnoMjesto) {

		return radnoMjestoRepositoryR.createRadnoMjesto(radnoMjesto);
	}

	@Override
	public List<RadnoMjesto> getAllRadnoMjesto() {
		
		return radnoMjestoRepositoryR.getAllRadnoMjesto();
	}

	@Override
	public int updateRadnoMjesto(RadnoMjesto radnoMjesto) {

		return radnoMjestoRepositoryR.updateRadnoMjesto(radnoMjesto);
	}

	@Override
	public int deleteRadnoMjesto(Integer id) {

		return radnoMjestoRepositoryR.deleteRadnoMjesto(id);
	}
}