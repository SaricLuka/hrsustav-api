package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.Drzava;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.DrzavaQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DrzavaService {

	private final DrzavaQuery drzavaQuery;

	public List<Drzava> getAllDrzava() {
		var drzavaList = drzavaQuery.getAllDrzava();

		if(drzavaList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return drzavaList;
	}
}