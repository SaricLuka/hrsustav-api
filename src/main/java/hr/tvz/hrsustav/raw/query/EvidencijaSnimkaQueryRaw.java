package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.dto.request.EvidencijaSnimkaRequest;
import hr.tvz.hrsustav.query.EvidencijaSnimkaQuery;
import hr.tvz.hrsustav.raw.repository.EvidencijaSnimkaRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class EvidencijaSnimkaQueryRaw implements EvidencijaSnimkaQuery {

	private final EvidencijaSnimkaRepositoryR evidencijaSnimkaRepositoryR;

	@Override
	public int createEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		
		return evidencijaSnimkaRepositoryR.createEvidencijaSnimka(evidencijaSnimkaRequest);
	}

	@Override
	public List<EvidencijaSnimkaDto> getEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		
		return evidencijaSnimkaRepositoryR.getEvidencijaSnimka(evidencijaSnimkaRequest);
	}

	@Override
	public int updateEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		
		return evidencijaSnimkaRepositoryR.updateEvidencijaSnimka(evidencijaSnimkaRequest);
	}

	@Override
	public int deleteEvidencijaSnimka(Integer id) {
		
		return evidencijaSnimkaRepositoryR.deleteEvidencijaSnimka(id);
	}
}
