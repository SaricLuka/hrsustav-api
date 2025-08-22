package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.VrstaRadnoVrijeme;
import hr.tvz.hrsustav.hibernate.repository.VrstaRadnoVrijemeRepositoryH;
import hr.tvz.hrsustav.query.VrstaRadnoVrijemeQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class VrstaRadnoVrijemeQueryHibernate implements VrstaRadnoVrijemeQuery{
	
	private final VrstaRadnoVrijemeRepositoryH vrstaRadnoVrijemeRepository;
	
	@Override
	public List<VrstaRadnoVrijeme> getAllVrstaRadnoVrijeme() {
		
		return vrstaRadnoVrijemeRepository.findAll();
	}

}