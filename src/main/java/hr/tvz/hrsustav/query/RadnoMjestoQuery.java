package hr.tvz.hrsustav.query;

import java.util.List;

import hr.tvz.hrsustav.entity.RadnoMjesto;

public interface RadnoMjestoQuery {

	int createRadnoMjesto(RadnoMjesto radnoMjesto);

	List<RadnoMjesto> getAllRadnoMjesto();

	int updateRadnoMjesto(RadnoMjesto radnoMjesto);

	int deleteRadnoMjesto(Integer id);
}