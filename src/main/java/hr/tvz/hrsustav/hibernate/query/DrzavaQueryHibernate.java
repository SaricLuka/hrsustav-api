package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Drzava;
import hr.tvz.hrsustav.hibernate.repository.DrzavaRepositoryH;
import hr.tvz.hrsustav.query.DrzavaQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class DrzavaQueryHibernate implements DrzavaQuery {

	private final DrzavaRepositoryH drzavaRepository;

	@Override
	public List<Drzava> getAllDrzava(){
		return drzavaRepository.findAll();
	}
}