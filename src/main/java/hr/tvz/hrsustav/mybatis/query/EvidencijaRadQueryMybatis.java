package hr.tvz.hrsustav.mybatis.query;

import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.EvidencijaRad;
import hr.tvz.hrsustav.mybatis.mapper.EvidencijaRadMapperB;
import hr.tvz.hrsustav.query.EvidencijaRadQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class EvidencijaRadQueryMybatis implements EvidencijaRadQuery {

	private final EvidencijaRadMapperB evidencijaRadMapper;

	@Override
	public int createEvidencijaRad(EvidencijaRad evidencijaRad) {
		return evidencijaRadMapper.createEvidencijaRad(evidencijaRad);
	}

	@Override
	public List<EvidencijaRad> getEvidencijaRad(Integer radnikFk, Date datumStart, Date datumEnd) {
		return evidencijaRadMapper.getEvidencijaRad(radnikFk, datumStart, datumEnd);
	}

	@Override
	public int updateEvidencijaRad(EvidencijaRad evidencijaRad) {
		return evidencijaRadMapper.updateEvidencijaRad(evidencijaRad);
	}

	@Override
	public int deleteEvidencijaRad(Integer id) {
		return evidencijaRadMapper.deleteEvidencijaRad(id);
	}
}