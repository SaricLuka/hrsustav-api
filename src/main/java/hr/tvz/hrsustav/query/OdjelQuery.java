package hr.tvz.hrsustav.query;

import java.util.List;

import hr.tvz.hrsustav.entity.Odjel;

public interface OdjelQuery {

	int createOdjel(Odjel odjel);

	List<Odjel> getAllOdjel();

	int updateOdjel(Odjel odjel);

	int deleteOdjel(Integer id);

}