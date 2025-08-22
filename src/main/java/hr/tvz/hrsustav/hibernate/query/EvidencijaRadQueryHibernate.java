package hr.tvz.hrsustav.hibernate.query;

import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.EvidencijaRad;
import hr.tvz.hrsustav.hibernate.repository.EvidencijaRadRepositoryH;
import hr.tvz.hrsustav.query.EvidencijaRadQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class EvidencijaRadQueryHibernate implements EvidencijaRadQuery {

	private final EvidencijaRadRepositoryH evidencijaRadRepositoryH;

	@Override
	public int createEvidencijaRad(EvidencijaRad evidencijaRad) {
		evidencijaRadRepositoryH.save(evidencijaRad);
		return 1;
	}

	@Override
	public List<EvidencijaRad> getEvidencijaRad(Integer radnikFk, Date datumStart, Date datumEnd) {
		return evidencijaRadRepositoryH.findByRadnikFkAndDatumBetween(radnikFk, datumStart, datumEnd);
	}

	@Override
	public int updateEvidencijaRad(EvidencijaRad evidencijaRad) {
		return createEvidencijaRad(evidencijaRad);
	}

	@Override
	public int deleteEvidencijaRad(Integer id) {
		evidencijaRadRepositoryH.deleteById(id);
		return 1;
	}
}