package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.RadnikVrsta;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.RadnikVrstaQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RadnikVrstaService {

	private final RadnikVrstaQuery radnikVrstaQuery;

	public List<RadnikVrsta> getAllRadnikVrsta(){
		var radnikVrstaList = radnikVrstaQuery.getAllRadnikVrsta();

		if(radnikVrstaList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return radnikVrstaList;
	}
}