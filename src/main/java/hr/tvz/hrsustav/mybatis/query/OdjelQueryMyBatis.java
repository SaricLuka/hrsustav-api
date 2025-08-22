package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Odjel;
import hr.tvz.hrsustav.mybatis.mapper.OdjelMapperB;
import hr.tvz.hrsustav.query.OdjelQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class OdjelQueryMyBatis implements OdjelQuery{

	private final OdjelMapperB odjelMapper;
	
	@Override
	public int createOdjel(Odjel odjel) {

		return odjelMapper.createOdjel(odjel);
	}

	@Override
	public List<Odjel> getAllOdjel() {

		return odjelMapper.getAllOdjel();
	}

	@Override
	public int updateOdjel(Odjel odjel) {

		return odjelMapper.updateOdjel(odjel);
	}

	@Override
	public int deleteOdjel(Integer id) {

		return odjelMapper.deleteOdjel(id);
	}

}