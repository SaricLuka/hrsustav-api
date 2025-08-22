package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Spol;
import hr.tvz.hrsustav.mybatis.mapper.SpolMapperB;
import hr.tvz.hrsustav.query.SpolQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class SpolQueryMybatis implements SpolQuery {

	private final SpolMapperB spolMapper;

	@Override
	public List<Spol> getAllSpol() {

		return spolMapper.getAllSpol();
	}

}