package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.dto.request.RadnikRequest;
import hr.tvz.hrsustav.entity.Radnik;
import hr.tvz.hrsustav.hibernate.criteria.RadnikRepositoryC;
import hr.tvz.hrsustav.hibernate.repository.RadnikRepositoryH;
import hr.tvz.hrsustav.hibernate.repository.RadnikVrstaRepositoryH;
import hr.tvz.hrsustav.hibernate.repository.SpolRepositoryH;
import hr.tvz.hrsustav.query.RadnikQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class RadnikQueryHibernate implements RadnikQuery {

	private final RadnikRepositoryH radnikRepositoryH;
	private final RadnikRepositoryC radnikRepositoryC;
	private final SpolRepositoryH spolRepository;
	private final RadnikVrstaRepositoryH radnikVrstaRepository;

	@Override
	public int createRadnik(RadnikRequest radnikRequest) {
		Radnik radnik = new Radnik();

		radnik.setIdRadnik(radnikRequest.getIdRadnik());
    	radnik.setIme(radnikRequest.getIme());
    	radnik.setPrezime(radnikRequest.getPrezime());
    	radnik.setOib(radnikRequest.getOib());
    	radnik.setDatumRod(radnikRequest.getDatumRod());

    	radnik.setSpolFk(spolRepository.getReferenceById(radnikRequest.getSpolFk()));
    	radnik.setRadnikVrstaFk(radnikVrstaRepository.getReferenceById(radnikRequest.getRadnikVrstaFk()));

    	if (radnikRequest.getRadnikNadredFk() != null) radnik.setRadnikNadredFk(radnikRepositoryH.getReferenceById(radnikRequest.getRadnikNadredFk()));
		radnikRepositoryH.save(radnik);
		return 1;
	}

	@Override
	public List<RadnikDto> getAllRadnik(RadnikGetRequest request) {
		return radnikRepositoryC.findAllRadnik(request);
	}

	@Override
	public int updateRadnik(RadnikRequest radnik) {
		return createRadnik(radnik);
	}

	@Override
	public int deleteRadnik(Integer id) {
		radnikRepositoryH.deleteById(id);
		return 1;
	}
}