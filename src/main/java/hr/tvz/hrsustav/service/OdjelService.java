package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.Odjel;
import hr.tvz.hrsustav.enums.DbParam;
import hr.tvz.hrsustav.exceptions.NoChangesToDbException;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.OdjelQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OdjelService {

	private final OdjelQuery odjelQuery;

	public void createOdjel(Odjel odjel){

		if(odjelQuery.createOdjel(odjel) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public List<Odjel> getAllOdjel(){
		var odjelList = odjelQuery.getAllOdjel();

		if(odjelList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return odjelList;
	}

	public void updateOdjel(Odjel odjel){

		if(odjelQuery.updateOdjel(odjel) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public void deleteOdjel(Integer idOdjel){

		if(odjelQuery.deleteOdjel(idOdjel) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}
}