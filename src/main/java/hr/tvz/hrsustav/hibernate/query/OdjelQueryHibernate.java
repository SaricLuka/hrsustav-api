package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Odjel;
import hr.tvz.hrsustav.hibernate.repository.OdjelRepositoryH;
import hr.tvz.hrsustav.query.OdjelQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class OdjelQueryHibernate implements OdjelQuery {

	private final OdjelRepositoryH odjelRepository;

	@Override
	public int createOdjel(Odjel odjel) {
		odjelRepository.save(odjel);
		return 1;
	}

	@Override
	public List<Odjel> getAllOdjel() {
		return odjelRepository.findAll();
	}

	@Override
	public int updateOdjel(Odjel odjel) {
		return createOdjel(odjel);
	}

	@Override
	public int deleteOdjel(Integer id) {
		odjelRepository.deleteById(id);
		return 1;
	}

}