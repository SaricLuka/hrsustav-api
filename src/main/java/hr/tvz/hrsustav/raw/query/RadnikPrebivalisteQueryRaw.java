package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;
import hr.tvz.hrsustav.query.RadnikPrebivalisteQuery;
import hr.tvz.hrsustav.raw.repository.RadnikPrebivalisteRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class RadnikPrebivalisteQueryRaw implements RadnikPrebivalisteQuery {

	private final RadnikPrebivalisteRepositoryR radnikPrebivalisteRepositoryR;
	
	@Override
	@Transactional
	public int createRadnikPrebivaliste(List<RadnikPrebivaliste> radnikPrebivalisteList) {
		final int batchSize = 50;

    	for (var i = 0; i < radnikPrebivalisteList.size(); i += batchSize) {
        	var end = Math.min(i + batchSize, radnikPrebivalisteList.size());
        	var batch = radnikPrebivalisteList.subList(i, end);

        	radnikPrebivalisteRepositoryR.createRadnikPrebivaliste(batch);
    	}
    	return 1;
	}
  
	@Override
	public List<RadnikPrebivaliste> getRadnikPrebivalisteByRadnik(Integer id) {
		return radnikPrebivalisteRepositoryR.getRadnikPrebivalisteByRadnik(id);
	}

	@Override
	public List<RadnikPrebivaliste> getRadnikPrebivalisteByMjesto(Integer id) {
		return radnikPrebivalisteRepositoryR.getRadnikPrebivalisteByMjesto(id);
	}

	@Override
	public int updateRadnikPrebivaliste(RadnikPrebivaliste radnikPrebivaliste) {
		return radnikPrebivalisteRepositoryR.updateRadnikPrebivaliste(radnikPrebivaliste);
	}

	@Override
	public int deleteRadnikPrebivaliste(Integer id) {
		return radnikPrebivalisteRepositoryR.deleteRadnikPrebivaliste(id);
	}

}
