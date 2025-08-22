package hr.tvz.hrsustav.query;

import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.UgovorRad;

public interface UgovorRadQuery {

	public int createUgovorRad(UgovorRad ugovorRad);

	public Object getAllUgovorRad(UgovorRadGetRequest request);

	public int updateUgovorRad(UgovorRad ugovorRad);

	public int deleteUgovorRad(Integer idUgovorRad);

}