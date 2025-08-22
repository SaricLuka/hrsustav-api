package hr.tvz.hrsustav.query;

import java.util.List;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.dto.request.EvidencijaSnimkaRequest;

public interface EvidencijaSnimkaQuery {

	int createEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest);

	List<EvidencijaSnimkaDto> getEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest);

	int updateEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest);

	int deleteEvidencijaSnimka(Integer id);
}
