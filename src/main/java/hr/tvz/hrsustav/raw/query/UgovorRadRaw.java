package hr.tvz.hrsustav.raw.query;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.UgovorRad;
import hr.tvz.hrsustav.query.UgovorRadQuery;
import hr.tvz.hrsustav.raw.repository.RadnoVrijemeRepositoryR;
import hr.tvz.hrsustav.raw.repository.UgovorRadRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class UgovorRadRaw implements UgovorRadQuery {

	private final UgovorRadRepositoryR ugovorRadRepositoryR;

	private final RadnoVrijemeRepositoryR radnoVrijemeRepositoryR;

	@Override
	@Transactional
	public int createUgovorRad(UgovorRad ugovorRad) {
		radnoVrijemeRepositoryR.createRadnoVrijeme(ugovorRad);
		return ugovorRadRepositoryR.createUgovorRad(ugovorRad);
	}

	@Override
	public Object getAllUgovorRad(UgovorRadGetRequest request) {
		return ugovorRadRepositoryR.getAllUgovorRad(request);
	}

	@Override
	@Transactional
	public int updateUgovorRad(UgovorRad ugovorRad) {
		radnoVrijemeRepositoryR.updateRadnoVrijeme(ugovorRad);
		return ugovorRadRepositoryR.updateUgovorRad(ugovorRad);
	}

	@Override
	public int deleteUgovorRad(Integer idUgovorRad) {
		ugovorRadRepositoryR.deleteUgovorRad(idUgovorRad);

		return 1;
	}

}
