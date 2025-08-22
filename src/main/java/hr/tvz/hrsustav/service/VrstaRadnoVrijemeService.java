package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.VrstaRadnoVrijeme;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.VrstaRadnoVrijemeQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VrstaRadnoVrijemeService {

	private final VrstaRadnoVrijemeQuery vrstaRadnoVrijemeQuery;

	public List<VrstaRadnoVrijeme> getAllVrstaRadnoVrijeme() {
		var vrstaRadnoVrijemeList = vrstaRadnoVrijemeQuery.getAllVrstaRadnoVrijeme();

		if(vrstaRadnoVrijemeList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return vrstaRadnoVrijemeList;
	}
}