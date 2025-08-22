package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.VrstaUgovorRad;
import hr.tvz.hrsustav.hibernate.repository.VrstaUgovorRadRepositoryH;
import hr.tvz.hrsustav.query.VrstaUgovorRadQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class VrstaUgovorRadQueryHibernate implements VrstaUgovorRadQuery {

	private final VrstaUgovorRadRepositoryH vrstaUgovorRadRepository;

	@Override
	public List<VrstaUgovorRad> getAllVrstaUgovorRad() {

		return vrstaUgovorRadRepository.findAll();
	}

}