package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.dto.request.EvidencijaSnimkaRequest;
import hr.tvz.hrsustav.mybatis.mapper.EvidencijaSnimkaMapperB;
import hr.tvz.hrsustav.query.EvidencijaSnimkaQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class EvidencijaSnimkaQueryMybatis implements EvidencijaSnimkaQuery {

	private final EvidencijaSnimkaMapperB evidencijaSnimkaMapper;

	@Override
	public int createEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		
		return evidencijaSnimkaMapper.createEvidencijaSnimka(evidencijaSnimkaRequest);
	}

	@Override
	public List<EvidencijaSnimkaDto> getEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		
		return evidencijaSnimkaMapper.getEvidencijaSnimka(evidencijaSnimkaRequest);
	}

	@Override
	public int updateEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		
		return evidencijaSnimkaMapper.updateEvidencijaSnimka(evidencijaSnimkaRequest);
	}

	@Override
	public int deleteEvidencijaSnimka(Integer id) {
		
		return evidencijaSnimkaMapper.deleteEvidencijaSnimka(id);
	}
}
