package hr.tvz.hrsustav.query;

import java.util.List;

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.dto.request.RadnikRequest;

public interface RadnikQuery {

	public int createRadnik(RadnikRequest radnik);

	public List<RadnikDto> getAllRadnik(RadnikGetRequest request);

	public int updateRadnik(RadnikRequest radnik);

	public int deleteRadnik(Integer idRadnik);
}