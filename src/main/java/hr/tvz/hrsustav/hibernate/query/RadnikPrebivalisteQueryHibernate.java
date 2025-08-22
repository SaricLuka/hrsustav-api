package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;
import hr.tvz.hrsustav.hibernate.repository.RadnikPrebivalisteRepositoryH;
import hr.tvz.hrsustav.query.RadnikPrebivalisteQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class RadnikPrebivalisteQueryHibernate implements RadnikPrebivalisteQuery {

	private final RadnikPrebivalisteRepositoryH radnikPrebivalisteRepository;

	@Override
	public int createRadnikPrebivaliste(List<RadnikPrebivaliste> radnikPrebivaliste) {
		radnikPrebivalisteRepository.saveAll(radnikPrebivaliste);
		return 1;
	}

	@Override
	public List<RadnikPrebivaliste> getRadnikPrebivalisteByRadnik(Integer id) {
		return radnikPrebivalisteRepository.findByRadnikFk(id);
	}

	@Override
	public List<RadnikPrebivaliste> getRadnikPrebivalisteByMjesto(Integer id) {
		return radnikPrebivalisteRepository.findByMjestoFk(id);
	}

	@Override
	public int updateRadnikPrebivaliste(RadnikPrebivaliste radnikPrebivaliste) {
		radnikPrebivalisteRepository.save(radnikPrebivaliste);
		return 1;
	}

	@Override
	public int deleteRadnikPrebivaliste(Integer id) {
		radnikPrebivalisteRepository.deleteById(id);
		return 1;
	}

}
