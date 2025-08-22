package hr.tvz.hrsustav.query;

import java.util.List;

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;

public interface RadnikPrebivalisteQuery {

	public int createRadnikPrebivaliste(List<RadnikPrebivaliste> radnikPrebivaliste);

	public List<RadnikPrebivaliste> getRadnikPrebivalisteByRadnik(Integer id);

	public List<RadnikPrebivaliste> getRadnikPrebivalisteByMjesto(Integer id);

	public int updateRadnikPrebivaliste(RadnikPrebivaliste radnikPrebivaliste);

	public int deleteRadnikPrebivaliste(Integer id);
}
