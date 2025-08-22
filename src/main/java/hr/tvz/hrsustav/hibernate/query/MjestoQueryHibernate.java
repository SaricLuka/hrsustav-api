package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Mjesto;
import hr.tvz.hrsustav.hibernate.repository.MjestoRepositoryH;
import hr.tvz.hrsustav.query.MjestoQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class MjestoQueryHibernate implements MjestoQuery {

	private final MjestoRepositoryH mjestoRepository;

	@Override
	public List<Mjesto> getAllMjesto() {
		
		return mjestoRepository.findAll();
	}

}
