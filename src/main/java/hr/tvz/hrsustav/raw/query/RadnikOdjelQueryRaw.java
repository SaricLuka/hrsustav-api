package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.dto.request.RadnikOdjelRequest;
import hr.tvz.hrsustav.query.RadnikOdjelQuery;
import hr.tvz.hrsustav.raw.repository.RadnikOdjelRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class RadnikOdjelQueryRaw implements RadnikOdjelQuery {

	private final RadnikOdjelRepositoryR radnikOdjelRepositoryR;
	
	@Override
	public int createRadnikOdjel(RadnikOdjelRequest radnikOdjel) {
		return radnikOdjelRepositoryR.createRadnikOdjel(radnikOdjel);
	}

	@Override
	public List<RadnikOdjelDto> getRadnikOdjelbyRadnik(Integer id) {
		return radnikOdjelRepositoryR.getRadnikOdjelbyRadnik(id);
	}

	@Override
	public List<RadnikOdjelDto> getRadnikOdjelbyOdjel(Integer id) {
		return radnikOdjelRepositoryR.getRadnikOdjelbyOdjel(id);
	}

	@Override
	public int updateRadnikOdjel(RadnikOdjelRequest radnikOdjel) {
		return radnikOdjelRepositoryR.updateRadnikOdjel(radnikOdjel);
	}

	@Override
	public int deleteRadnikOdjel(Integer id) {
		return radnikOdjelRepositoryR.deleteRadnikOdjel(id);
	}
}