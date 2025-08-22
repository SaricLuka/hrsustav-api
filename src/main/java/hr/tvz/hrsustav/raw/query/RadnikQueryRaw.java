package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.dto.request.RadnikRequest;
import hr.tvz.hrsustav.query.RadnikQuery;
import hr.tvz.hrsustav.raw.repository.RadnikRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class RadnikQueryRaw implements RadnikQuery{

	private final RadnikRepositoryR radnikRepositoryR;

	@Override
	public int createRadnik(RadnikRequest radnik) {
		return radnikRepositoryR.createRadnik(radnik);
	}

	@Override
	public List<RadnikDto> getAllRadnik(RadnikGetRequest request) {
		return radnikRepositoryR.getAllRadnik(request);
	}

	@Override
	public int updateRadnik(RadnikRequest radnik) {
		return radnikRepositoryR.updateRadnik(radnik);
	}

	@Override
	public int deleteRadnik(Integer idRadnik) {
		return radnikRepositoryR.deleteRadnik(idRadnik);
	}
}