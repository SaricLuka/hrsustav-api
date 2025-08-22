package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Spol;
import hr.tvz.hrsustav.hibernate.repository.SpolRepositoryH;
import hr.tvz.hrsustav.query.SpolQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class SpolQueryHibernate implements SpolQuery {

	private final SpolRepositoryH spolRepository;
	
	@Override
	public List<Spol> getAllSpol() {
		
		return spolRepository.findAll();
	}

}