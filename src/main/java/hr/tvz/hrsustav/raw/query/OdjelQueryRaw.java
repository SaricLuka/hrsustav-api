package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Odjel;
import hr.tvz.hrsustav.query.OdjelQuery;
import hr.tvz.hrsustav.raw.repository.OdjelRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class OdjelQueryRaw implements OdjelQuery{

	private final OdjelRepositoryR odjelRepositoryR;
	
	@Override
	public int createOdjel(Odjel odjel) {

		return odjelRepositoryR.createOdjel(odjel);
	}

	@Override
	public List<Odjel> getAllOdjel() {

		return odjelRepositoryR.getAllOdjel();
	}

	@Override
	public int updateOdjel(Odjel odjel) {

		return odjelRepositoryR.updateOdjel(odjel);
	}

	@Override
	public int deleteOdjel(Integer id) {

		return odjelRepositoryR.deleteOdjel(id);
	}

}