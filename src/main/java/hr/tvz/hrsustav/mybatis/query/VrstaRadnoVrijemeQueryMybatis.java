package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.VrstaRadnoVrijeme;
import hr.tvz.hrsustav.mybatis.mapper.VrstaRadnoVrijemeMapperB;
import hr.tvz.hrsustav.query.VrstaRadnoVrijemeQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class VrstaRadnoVrijemeQueryMybatis implements VrstaRadnoVrijemeQuery {

	private final VrstaRadnoVrijemeMapperB vrstaRadnoVrijemeMapper;

	@Override
	public List<VrstaRadnoVrijeme> getAllVrstaRadnoVrijeme() {

		return vrstaRadnoVrijemeMapper.getAllVrstaRadnoVrijeme();
	}
}