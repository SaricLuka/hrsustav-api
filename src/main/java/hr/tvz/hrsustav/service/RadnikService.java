package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.dto.request.RadnikRequest;
import hr.tvz.hrsustav.enums.DbParam;
import hr.tvz.hrsustav.exceptions.NoChangesToDbException;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.RadnikQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RadnikService {

	private final RadnikQuery radnikQuery;

	public void createRadnik(RadnikRequest radnik){

		if(radnikQuery.createRadnik(radnik) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public List<RadnikDto> getAllRadnik(RadnikGetRequest request){
		var radnikList = radnikQuery.getAllRadnik(request);

		if(radnikList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return radnikList;
	}

	public void updateRadnik(RadnikRequest radnik){

		if(radnikQuery.updateRadnik(radnik) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public void deleteRadnik(Integer idRadnik){

		if(radnikQuery.deleteRadnik(idRadnik) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}
}
