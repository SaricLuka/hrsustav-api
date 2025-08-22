package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Spol;
import hr.tvz.hrsustav.query.SpolQuery;
import hr.tvz.hrsustav.raw.repository.SpolRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class SpolQueryRaw implements SpolQuery {

	private final SpolRepositoryR spolRepositoryR;

	@Override
	public List<Spol> getAllSpol() {

		return spolRepositoryR.getAllSpol();
	}

}