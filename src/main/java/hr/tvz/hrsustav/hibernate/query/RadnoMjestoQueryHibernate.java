package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.RadnoMjesto;
import hr.tvz.hrsustav.hibernate.repository.RadnoMjestoRepositoryH;
import hr.tvz.hrsustav.query.RadnoMjestoQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class RadnoMjestoQueryHibernate implements RadnoMjestoQuery{
	
	private final RadnoMjestoRepositoryH radnoMjestoRepository;
	
	@Override
	public int createRadnoMjesto(RadnoMjesto radnoMjesto) {

		radnoMjestoRepository.save(radnoMjesto);
		return 1;
	}

	@Override
	public List<RadnoMjesto> getAllRadnoMjesto() {

		return radnoMjestoRepository.findAll();
	}

	@Override
	public int updateRadnoMjesto(RadnoMjesto radnoMjesto) {

		return createRadnoMjesto(radnoMjesto);
	}

	@Override
	public int deleteRadnoMjesto(Integer id) {

		radnoMjestoRepository.deleteById(id);
		return 1;
	}

}