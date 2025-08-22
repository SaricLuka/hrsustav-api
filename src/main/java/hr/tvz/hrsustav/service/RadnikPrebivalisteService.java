package hr.tvz.hrsustav.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;
import hr.tvz.hrsustav.enums.DbParam;
import hr.tvz.hrsustav.exceptions.NoChangesToDbException;
import hr.tvz.hrsustav.exceptions.NoEntriesFoundException;
import hr.tvz.hrsustav.query.RadnikPrebivalisteQuery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RadnikPrebivalisteService {

	private final RadnikPrebivalisteQuery radnikPrebivalisteQuery;

	public void createRadnikPrebivaliste(RadnikPrebivaliste template){
		List<RadnikPrebivaliste> radnikPrebivalisteList = new ArrayList<RadnikPrebivaliste>();
		for (int i = 0; i < 1125; i++) {
        	RadnikPrebivaliste r = new RadnikPrebivaliste();
        	r.setRadnikFk(template.getRadnikFk());
        	r.setMjestoFk(template.getMjestoFk());
        	r.setUlica(template.getUlica());
        	r.setKucniBr(template.getKucniBr());
        	radnikPrebivalisteList.add(r);
    	}
		if(radnikPrebivalisteQuery.createRadnikPrebivaliste(radnikPrebivalisteList) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public List<RadnikPrebivaliste> getRadnikPrebivalisteByRadnik(Integer id){
		var radnikPrebivalisteList = radnikPrebivalisteQuery.getRadnikPrebivalisteByRadnik(id);

		if(radnikPrebivalisteList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return radnikPrebivalisteList;
	}

	public List<RadnikPrebivaliste> getRadnikPrebivalisteByMjesto(Integer id){
		var radnikPrebivalisteList = radnikPrebivalisteQuery.getRadnikPrebivalisteByMjesto(id);

		if(radnikPrebivalisteList.isEmpty()){
			throw new NoEntriesFoundException();
		}

		return radnikPrebivalisteList;
	}

	public void updateRadnikPrebivaliste(RadnikPrebivaliste radnikPrebivaliste){

		if(radnikPrebivalisteQuery.updateRadnikPrebivaliste(radnikPrebivaliste) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}

	public void deleteRadnikPrebivaliste(Integer id){

		if(radnikPrebivalisteQuery.deleteRadnikPrebivaliste(id) == DbParam.NO_CHANGES){
			throw new NoChangesToDbException();
		}
	}
}
