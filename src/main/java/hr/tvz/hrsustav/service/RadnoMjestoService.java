package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.RadnoMjesto;
import hr.tvz.hrsustav.enums.DbParam;
import hr.tvz.hrsustav.exceptions.NoChangesToDbException;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.RadnoMjestoQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RadnoMjestoService {

	private final RadnoMjestoQuery radnoMjestoQuery;

	public void createRadnoMjesto(RadnoMjesto radnoMjesto){

		if(radnoMjestoQuery.createRadnoMjesto(radnoMjesto) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public List<RadnoMjesto> getAllRadnoMjesto(){
		var radnoMjestoList = radnoMjestoQuery.getAllRadnoMjesto();

		if(radnoMjestoList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return radnoMjestoList;
	}

	public void updateRadnoMjesto(RadnoMjesto radnoMjesto){

		if(radnoMjestoQuery.updateRadnoMjesto(radnoMjesto) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public void deleteRadnoMjesto(Integer idRadnoMjesto){

		if(radnoMjestoQuery.deleteRadnoMjesto(idRadnoMjesto) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}
}