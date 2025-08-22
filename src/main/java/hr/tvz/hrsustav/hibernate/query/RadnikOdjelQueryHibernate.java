package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.dto.request.RadnikOdjelRequest;
import hr.tvz.hrsustav.entity.RadnikOdjel;
import hr.tvz.hrsustav.hibernate.repository.OdjelRepositoryH;
import hr.tvz.hrsustav.hibernate.repository.RadnikOdjelRepositoryH;
import hr.tvz.hrsustav.hibernate.repository.RadnikRepositoryH;
import hr.tvz.hrsustav.query.RadnikOdjelQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class RadnikOdjelQueryHibernate implements RadnikOdjelQuery {

	private final RadnikOdjelRepositoryH radnikOdjelRepository;
	private final RadnikRepositoryH radnikRepository;
	private final OdjelRepositoryH odjelRepository;

	@Override
	public int createRadnikOdjel(RadnikOdjelRequest radnikOdjelRequest) {
		
		var radnikOdjel = new RadnikOdjel();
		radnikOdjel.setIdRadnikOdjel(radnikOdjelRequest.getIdRadnikOdjel());
		radnikOdjel.setRadnikFk(radnikRepository.getReferenceById(radnikOdjelRequest.getRadnikFk()));
		radnikOdjel.setOdjelFk(odjelRepository.getReferenceById(radnikOdjelRequest.getOdjelFk()));
		radnikOdjel.setDatumOd(radnikOdjelRequest.getDatumOd());
		radnikOdjel.setDatumDo(radnikOdjelRequest.getDatumDo());
		radnikOdjel.setIdRadnikOdjel(radnikOdjelRequest.getIdRadnikOdjel());
		radnikOdjelRepository.save(radnikOdjel);
		return 1;
	}

	@Override
	public List<RadnikOdjelDto> getRadnikOdjelbyRadnik(Integer id) {

		return radnikOdjelRepository.findByRadnikFk_IdRadnik(id);
	}

	@Override
	public List<RadnikOdjelDto> getRadnikOdjelbyOdjel(Integer id) {

		return radnikOdjelRepository.findByOdjelFk_IdOdjel(id);
	}

	@Override
	public int updateRadnikOdjel(RadnikOdjelRequest radnikOdjel) {

		return createRadnikOdjel(radnikOdjel);
	}

	@Override
	public int deleteRadnikOdjel(Integer id) {

		radnikOdjelRepository.deleteById(id);
		return 1;
	}

}
