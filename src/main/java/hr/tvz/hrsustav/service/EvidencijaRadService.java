package hr.tvz.hrsustav.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.EvidencijaRad;
import hr.tvz.hrsustav.enums.DbParam;
import hr.tvz.hrsustav.exceptions.NoChangesToDbException;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.EvidencijaRadQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EvidencijaRadService {

	private final EvidencijaRadQuery evidencijaRadQuery;

	public void createEvidencijaRad(EvidencijaRad evidencijaRad){

		if(evidencijaRadQuery.createEvidencijaRad(evidencijaRad) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public List<EvidencijaRad> getEvidencijaRad(Integer radnikFk, Date datumStart, Date datumEnd){
		var evidencijaRadList = evidencijaRadQuery.getEvidencijaRad(radnikFk, datumStart, datumEnd);

		if(evidencijaRadList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return evidencijaRadList;
	}

	public void updateEvidencijaRad(EvidencijaRad evidencijaRad){

		if(evidencijaRadQuery.updateEvidencijaRad(evidencijaRad) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public void deleteEvidencijaRad(Integer idEvidencijaRad){

		if(evidencijaRadQuery.deleteEvidencijaRad(idEvidencijaRad) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}
}