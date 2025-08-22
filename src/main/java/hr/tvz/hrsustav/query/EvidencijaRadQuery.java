package hr.tvz.hrsustav.query;

import java.sql.Date;
import java.util.List;

import hr.tvz.hrsustav.entity.EvidencijaRad;

public interface EvidencijaRadQuery {

	int createEvidencijaRad(EvidencijaRad odjel);

	List<EvidencijaRad> getEvidencijaRad(Integer radnikFk, Date datumStart, Date datumEnd);

	int updateEvidencijaRad(EvidencijaRad odjel);

	int deleteEvidencijaRad(Integer id);
}
