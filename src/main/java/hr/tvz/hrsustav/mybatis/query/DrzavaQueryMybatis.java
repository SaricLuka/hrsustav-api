package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Drzava;
import hr.tvz.hrsustav.mybatis.mapper.DrzavaMapperB;
import hr.tvz.hrsustav.query.DrzavaQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class DrzavaQueryMybatis implements DrzavaQuery {
	
	private final DrzavaMapperB drzavaMapper;

	@Override
	public List<Drzava> getAllDrzava(){
		return drzavaMapper.getAllDrzava();
	}

}