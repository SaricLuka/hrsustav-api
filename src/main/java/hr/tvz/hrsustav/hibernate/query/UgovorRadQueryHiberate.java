package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.hrsustav.dto.UgovorRadDto;
import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.UgovorRad;
import hr.tvz.hrsustav.hibernate.criteria.UgovorRadRepositoryC;
import hr.tvz.hrsustav.hibernate.repository.UgovorRadRepositoryH;
import hr.tvz.hrsustav.query.UgovorRadQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class UgovorRadQueryHiberate implements UgovorRadQuery {

	private final UgovorRadRepositoryH ugovorRadRepositoryH;

	private final UgovorRadRepositoryC ugovorRadRepositoryC;

	@Override
	public int createUgovorRad(UgovorRad ugovorRad) {

		ugovorRadRepositoryH.save(ugovorRad);
		return 1;
	}

	@Override
	public List<UgovorRadDto> getAllUgovorRad(UgovorRadGetRequest request) {

		return ugovorRadRepositoryC.findAllUgovorRad(request);
	}

	@Override
	public int updateUgovorRad(UgovorRad ugovorRad) {
		return createUgovorRad(ugovorRad);
	}

	@Override
	@Transactional
	public int deleteUgovorRad(Integer idUgovorRad) {
		return ugovorRadRepositoryH.deleteRadnoVrijemeByUgovorRadId(idUgovorRad);
	}

}