package hr.tvz.hrsustav.hibernate.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.dto.request.EvidencijaSnimkaRequest;
import hr.tvz.hrsustav.entity.EvidencijaSnimka;
import hr.tvz.hrsustav.hibernate.repository.EvidencijaSnimkaRepositoryH;
import hr.tvz.hrsustav.hibernate.repository.RadnikRepositoryH;
import hr.tvz.hrsustav.query.EvidencijaSnimkaQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("hibernate")
@AllArgsConstructor
public class EvidencijaSnimkaQueryHibernate implements EvidencijaSnimkaQuery {

	private final EvidencijaSnimkaRepositoryH evidencijaSnimkaRepository;
	private final RadnikRepositoryH radnikRepository;

	@Override
	public int createEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		EvidencijaSnimka evidencijaSnimka = EvidencijaSnimka.builder()
			.idEvidencijaSnimka(evidencijaSnimkaRequest.getIdEvidencijaSnimka())
			.datumOd(evidencijaSnimkaRequest.getDatumOd())
			.datumDo(evidencijaSnimkaRequest.getDatumDo())
			.radnikFk(radnikRepository.getReferenceById(evidencijaSnimkaRequest.getRadnikFk()))
			.snimka(evidencijaSnimkaRequest.getSnimka())
			.datum(evidencijaSnimkaRequest.getDatum())
			.build();

		evidencijaSnimkaRepository.save(evidencijaSnimka);
		return 1;
	}

	@Override
	public List<EvidencijaSnimkaDto> getEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		
		return evidencijaSnimkaRepository.getEvidencijaSnimka(
			evidencijaSnimkaRequest.getIdEvidencijaSnimka(),
			evidencijaSnimkaRequest.getRadnikFk(),
			evidencijaSnimkaRequest.getDatumOd(),
			evidencijaSnimkaRequest.getDatumDo(),
			evidencijaSnimkaRequest.getDatum());
	}

	@Override
	public int updateEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		createEvidencijaSnimka(evidencijaSnimkaRequest);
		return 1;
	}

	@Override
	public int deleteEvidencijaSnimka(Integer id) {
		evidencijaSnimkaRepository.deleteById(id);
		return 1;
	}

}
