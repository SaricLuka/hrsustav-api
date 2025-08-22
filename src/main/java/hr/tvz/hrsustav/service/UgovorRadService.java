package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.UgovorRad;
import hr.tvz.hrsustav.enums.DbParam;
import hr.tvz.hrsustav.exceptions.NoChangesToDbException;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.UgovorRadQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UgovorRadService {

	private final UgovorRadQuery ugovorRadQuery;

	public void createUgovorRad(UgovorRad ugovorRad){

		if(ugovorRadQuery.createUgovorRad(ugovorRad) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public Object getAllUgovorRad(UgovorRadGetRequest request){
		var ugovorRadList = ugovorRadQuery.getAllUgovorRad(request);

		if(((List<?>) ugovorRadList).isEmpty()){
			throw new NoEntriesFoundException();
		}

		return ugovorRadList;
	}

	public void updateUgovorRad(UgovorRad ugovorRad){

		if(ugovorRadQuery.updateUgovorRad(ugovorRad) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public void deleteUgovorRad(Integer idUgovorRad){

		if(ugovorRadQuery.deleteUgovorRad(idUgovorRad) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}
}