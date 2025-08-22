package hr.tvz.hrsustav.query;

import java.util.List;

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.dto.request.RadnikOdjelRequest;

public interface RadnikOdjelQuery {

	public int createRadnikOdjel(RadnikOdjelRequest radnikOdjel);

	public List<RadnikOdjelDto> getRadnikOdjelbyRadnik(Integer id);

	public List<RadnikOdjelDto> getRadnikOdjelbyOdjel(Integer id);

	public int updateRadnikOdjel(RadnikOdjelRequest radnikOdjel);

	public int deleteRadnikOdjel(Integer id);
}
