package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.dto.request.RadnikOdjelRequest;
import hr.tvz.hrsustav.enums.DbParam;
import hr.tvz.hrsustav.exceptions.NoChangesToDbException;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.RadnikOdjelQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RadnikOdjelService {

	private final RadnikOdjelQuery radnikOdjelQuery;

	public void createRadnikOdjel(RadnikOdjelRequest radnikOdjel){

		if(radnikOdjelQuery.createRadnikOdjel(radnikOdjel) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public List<RadnikOdjelDto> getRadnikOdjelbyRadnik(Integer id){
		var radnikOdjelList = radnikOdjelQuery.getRadnikOdjelbyRadnik(id);

		if(radnikOdjelList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return radnikOdjelList;
	}

	public List<RadnikOdjelDto> getRadnikOdjelbyOdjel(Integer id){
		var radnikOdjelList = radnikOdjelQuery.getRadnikOdjelbyOdjel(id);

		if(radnikOdjelList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return radnikOdjelList;
	}

	public void updateRadnikOdjel(RadnikOdjelRequest radnikOdjel){

		if(radnikOdjelQuery.updateRadnikOdjel(radnikOdjel) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public void deleteRadnikOdjel(Integer idRadnik){

		if(radnikOdjelQuery.deleteRadnikOdjel(idRadnik) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}
}
