package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.Spol;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.SpolQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SpolService {

	private final SpolQuery spolQuery;

	public List<Spol> getAllSpol(){
		var spolList = spolQuery.getAllSpol();

		if(spolList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return spolList;
	}
}