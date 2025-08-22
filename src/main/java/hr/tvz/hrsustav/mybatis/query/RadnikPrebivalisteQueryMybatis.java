package hr.tvz.hrsustav.mybatis.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;
import hr.tvz.hrsustav.mybatis.mapper.RadnikPrebivalisteMapperB;
import hr.tvz.hrsustav.query.RadnikPrebivalisteQuery;
import lombok.AllArgsConstructor;

@Component
@Profile("mybatis")
@AllArgsConstructor
public class RadnikPrebivalisteQueryMybatis implements RadnikPrebivalisteQuery {

	private final RadnikPrebivalisteMapperB radnikPrebivalisteMapper;

	@Override
	@Transactional
	public int createRadnikPrebivaliste(List<RadnikPrebivaliste> radnikPrebivalisteList) {
		final int batchSize = 50;

		for (var i = 0; i < radnikPrebivalisteList.size(); i += batchSize) {
			var end = Math.min(i + batchSize, radnikPrebivalisteList.size());
			var batch = radnikPrebivalisteList.subList(i, end);

			var ids = radnikPrebivalisteMapper.getNextIds(batchSize);

			for (int j = 0; j < batch.size(); j++) {
				batch.get(j).setIdRadnikPrebivaliste((ids.get(j)));
			}

			radnikPrebivalisteMapper.createRadnikPrebivaliste(batch);
		}
 
		return 1;
	}
 
	@Override
	public List<RadnikPrebivaliste> getRadnikPrebivalisteByRadnik(Integer id) {
		return radnikPrebivalisteMapper.getRadnikPrebivalisteByRadnik(id);
	}

	@Override
	public List<RadnikPrebivaliste> getRadnikPrebivalisteByMjesto(Integer id) {
		return radnikPrebivalisteMapper.getRadnikPrebivalisteByMjesto(id);
	}

	@Override
	public int updateRadnikPrebivaliste(RadnikPrebivaliste radnikPrebivaliste) {
		return radnikPrebivalisteMapper.updateRadnikPrebivaliste(radnikPrebivaliste);
	}

	@Override
	public int deleteRadnikPrebivaliste(Integer id) {
		return radnikPrebivalisteMapper.deleteRadnikPrebivaliste(id);
	}
}