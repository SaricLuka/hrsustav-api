package hr.tvz.hrsustav.mybatis.query;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.UgovorRad;
import hr.tvz.hrsustav.mybatis.mapper.RadnoVrijemeMapperB;
import hr.tvz.hrsustav.mybatis.mapper.UgovorRadMapperB;
import hr.tvz.hrsustav.query.UgovorRadQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class UgovorRadQueryMybatis implements UgovorRadQuery {

	private final UgovorRadMapperB ugovorRadMapperB;

	private final RadnoVrijemeMapperB radnoVrijemeMapperB;

	@Override
	@Transactional
	public int createUgovorRad(UgovorRad ugovorRad) {
		radnoVrijemeMapperB.createRadnoVrijme(ugovorRad);
		return ugovorRadMapperB.createUgovorRad(ugovorRad);
	}

	@Override
	public Object getAllUgovorRad(UgovorRadGetRequest request) {
		return ugovorRadMapperB.getAllUgovorRad(request);
	}

	@Override
	@Transactional
	public int updateUgovorRad(UgovorRad ugovorRad) {
		radnoVrijemeMapperB.updateRadnoVrijeme(ugovorRad);
		return ugovorRadMapperB.updateUgovorRad(ugovorRad);
	}

	@Override
	public int deleteUgovorRad(Integer idUgovorRad) {
		return ugovorRadMapperB.deleteUgovorRad(idUgovorRad);
	}

}
