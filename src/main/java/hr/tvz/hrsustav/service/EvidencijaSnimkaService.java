package hr.tvz.hrsustav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.dto.request.EvidencijaSnimkaRequest;
import hr.tvz.hrsustav.enums.DbParam;
import hr.tvz.hrsustav.exceptions.NoChangesToDbException;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.EvidencijaSnimkaQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EvidencijaSnimkaService {

	private final EvidencijaSnimkaQuery evidencijaSnimkaQuery;

	public void createEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {

		if(evidencijaSnimkaQuery.createEvidencijaSnimka(evidencijaSnimkaRequest) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public List<EvidencijaSnimkaDto> getEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest) {
		
		var evidencijaSnimkaList = evidencijaSnimkaQuery.getEvidencijaSnimka(evidencijaSnimkaRequest);

		if(evidencijaSnimkaList.isEmpty()){
			throw new NoEntriesFoundException();
		}
		
		return evidencijaSnimkaList;
	}

	public void updateOdjel(EvidencijaSnimkaRequest evidencijaSnimkaRequest){

		if(evidencijaSnimkaQuery.updateEvidencijaSnimka(evidencijaSnimkaRequest) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public void deleteOdjel(Integer id){

		if(evidencijaSnimkaQuery.deleteEvidencijaSnimka(id) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}
}
