package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.VrstaUgovorRad;
import hr.tvz.hrsustav.mybatis.mapper.VrstaUgovorRadMapperB;
import hr.tvz.hrsustav.query.VrstaUgovorRadQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class VrstaUgovorRadQueryMybatis implements VrstaUgovorRadQuery{

	private final VrstaUgovorRadMapperB vrstaUgovorRadMapper;

	@Override
	public List<VrstaUgovorRad> getAllVrstaUgovorRad() {
		
		return vrstaUgovorRadMapper.getAllVrstaUgovorRad();
	}
}