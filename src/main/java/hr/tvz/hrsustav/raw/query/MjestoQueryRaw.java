package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Mjesto;
import hr.tvz.hrsustav.query.MjestoQuery;
import hr.tvz.hrsustav.raw.repository.MjestoRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class MjestoQueryRaw implements MjestoQuery {

	private final MjestoRepositoryR mjestoRepositoryR;


	@Override
	public List<Mjesto> getAllMjesto() {
		
		return mjestoRepositoryR.getAllMjesto();
	}

}