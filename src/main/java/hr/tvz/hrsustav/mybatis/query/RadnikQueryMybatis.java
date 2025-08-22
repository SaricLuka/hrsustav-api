package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.dto.request.RadnikRequest;
import hr.tvz.hrsustav.mybatis.mapper.RadnikMapperB;
import hr.tvz.hrsustav.query.RadnikQuery;
import lombok.AllArgsConstructor;


@Component
@Profile("mybatis")
@AllArgsConstructor
public class RadnikQueryMybatis implements RadnikQuery {

	private final RadnikMapperB radnikMapper;

	@Override
	public int createRadnik(RadnikRequest radnik) {
		return radnikMapper.createRadnik(radnik);
	}

	@Override
	public List<RadnikDto> getAllRadnik(RadnikGetRequest request) {
		return radnikMapper.getAllRadnik(request);
	}

	@Override
	public int updateRadnik(RadnikRequest radnik) {
		return radnikMapper.updateRadnik(radnik);
	}

	@Override
	public int deleteRadnik(Integer idRadnik) {
		return radnikMapper.deleteRadnik(idRadnik);
	}
}