package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.RadnoMjesto;
import hr.tvz.hrsustav.mybatis.mapper.RadnoMjestoMapperB;
import hr.tvz.hrsustav.query.RadnoMjestoQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class RadnoMjestoQueryMybatis implements RadnoMjestoQuery{

	private final RadnoMjestoMapperB radnoMjestoMapper;

	@Override
	public int createRadnoMjesto(RadnoMjesto radnoMjesto) {

		return radnoMjestoMapper.createRadnoMjesto(radnoMjesto);
	}

	@Override
	public List<RadnoMjesto> getAllRadnoMjesto() {
		
		return radnoMjestoMapper.getAllRadnoMjesto();
	}

	@Override
	public int updateRadnoMjesto(RadnoMjesto radnoMjesto) {

		return radnoMjestoMapper.updateRadnoMjesto(radnoMjesto);
	}

	@Override
	public int deleteRadnoMjesto(Integer id) {

		return radnoMjestoMapper.deleteRadnoMjesto(id);
	}
}