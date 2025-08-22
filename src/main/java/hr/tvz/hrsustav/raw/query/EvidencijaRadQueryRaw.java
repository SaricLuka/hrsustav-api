package hr.tvz.hrsustav.raw.query;

import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.EvidencijaRad;
import hr.tvz.hrsustav.query.EvidencijaRadQuery;
import hr.tvz.hrsustav.raw.repository.EvidencijaRadRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class EvidencijaRadQueryRaw implements EvidencijaRadQuery {

	private final EvidencijaRadRepositoryR evidencijaRadRepositoryR;

	@Override
	public int createEvidencijaRad(EvidencijaRad odjel) {
		return evidencijaRadRepositoryR.createEvidencijaRad(odjel);
	}

	@Override
	public List<EvidencijaRad> getEvidencijaRad(Integer radnikFk, Date datumStart, Date datumEnd) {
		return evidencijaRadRepositoryR.getEvidencijaRad(radnikFk, datumStart, datumEnd);
	}

	@Override
	public int updateEvidencijaRad(EvidencijaRad odjel) {
		return evidencijaRadRepositoryR.updateEvidencijaRad(odjel);
	}

	@Override
	public int deleteEvidencijaRad(Integer id) {
		return evidencijaRadRepositoryR.deleteEvidencijaRad(id);
	}

}