package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.VrstaUgovorRad;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.VrstaUgovorRadQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VrstaUgovorRadService {

	private final VrstaUgovorRadQuery vrstaUgovorRadQuery;

	public List<VrstaUgovorRad> getAllVrstaUgovorRad() {
		var vrstaUgovorRadList = vrstaUgovorRadQuery.getAllVrstaUgovorRad();

		if(vrstaUgovorRadList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return vrstaUgovorRadList;
	}
}