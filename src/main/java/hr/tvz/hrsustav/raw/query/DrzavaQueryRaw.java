package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.Drzava;
import hr.tvz.hrsustav.query.DrzavaQuery;
import hr.tvz.hrsustav.raw.repository.DrzavaRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class DrzavaQueryRaw implements DrzavaQuery {
	
	private final DrzavaRepositoryR drzavaRepositoryR;

	@Override
	public List<Drzava> getAllDrzava(){
		return drzavaRepositoryR.getAllDrzava();
	}

}