package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.Mjesto;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.MjestoQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MjestoService {

	private final MjestoQuery mjestoQuery;

	public List<Mjesto> getAllSpol(){
		var mjestoList = mjestoQuery.getAllMjesto();

		if(mjestoList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return mjestoList;
	}
}