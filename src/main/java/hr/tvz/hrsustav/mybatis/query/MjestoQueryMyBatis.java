package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Mjesto;
import hr.tvz.hrsustav.mybatis.mapper.MjestoMapperB;
import hr.tvz.hrsustav.query.MjestoQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class MjestoQueryMyBatis implements MjestoQuery {

	private final MjestoMapperB mjestoMapperB;

	@Override
	public List<Mjesto> getAllMjesto() {
		
		return mjestoMapperB.getAllMjesto();
	}

}
