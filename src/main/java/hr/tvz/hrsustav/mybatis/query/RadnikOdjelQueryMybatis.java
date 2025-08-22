package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.dto.request.RadnikOdjelRequest;
import hr.tvz.hrsustav.mybatis.mapper.RadnikOdjelMapperB;
import hr.tvz.hrsustav.query.RadnikOdjelQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class RadnikOdjelQueryMybatis implements RadnikOdjelQuery{

	private final RadnikOdjelMapperB radnikOdjelMapper;
	
	@Override
	public int createRadnikOdjel(RadnikOdjelRequest radnikOdjel) {

		return radnikOdjelMapper.createRadnikOdjel(radnikOdjel);
	}

	@Override
	public List<RadnikOdjelDto> getRadnikOdjelbyRadnik(Integer id) {

		return radnikOdjelMapper.getRadnikOdjelByRadnik(id);
	}

	@Override
	public List<RadnikOdjelDto> getRadnikOdjelbyOdjel(Integer id) {
		
		return radnikOdjelMapper.getRadnikOdjelByOdjel(id);
	}

	@Override
	public int updateRadnikOdjel(RadnikOdjelRequest radnikOdjel) {
		
		return radnikOdjelMapper.updateRadnikOdjel(radnikOdjel);
	}

	@Override
	public int deleteRadnikOdjel(Integer id) {
		
		return radnikOdjelMapper.deleteRadnikOdjel(id);
	}
}