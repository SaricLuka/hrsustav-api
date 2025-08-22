package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.RadnikVrsta;
import hr.tvz.hrsustav.mybatis.mapper.RadnikVrstaMapperB;
import hr.tvz.hrsustav.query.RadnikVrstaQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class RadnikVrstaQueryMybatis implements RadnikVrstaQuery {

	private final RadnikVrstaMapperB radnikVrstaMapper;
	
	@Override
	public List<RadnikVrsta> getAllRadnikVrsta() {
		return radnikVrstaMapper.getAllRadnikVrsta();
	}
	
}
