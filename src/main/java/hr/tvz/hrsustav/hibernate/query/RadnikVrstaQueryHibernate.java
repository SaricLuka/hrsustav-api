package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.RadnikVrsta;
import hr.tvz.hrsustav.hibernate.repository.RadnikVrstaRepositoryH;
import hr.tvz.hrsustav.query.RadnikVrstaQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class RadnikVrstaQueryHibernate implements RadnikVrstaQuery{
	
	private final RadnikVrstaRepositoryH radnikVrstaRepository;
	
	@Override
	public List<RadnikVrsta> getAllRadnikVrsta() {
	
		return radnikVrstaRepository.findAll();
	}

}