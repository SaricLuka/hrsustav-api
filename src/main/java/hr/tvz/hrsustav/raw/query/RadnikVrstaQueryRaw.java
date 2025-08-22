package hr.tvz.hrsustav.raw.query;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hr.tvz.hrsustav.entity.RadnikVrsta;
import hr.tvz.hrsustav.query.RadnikVrstaQuery;
import hr.tvz.hrsustav.raw.repository.RadnkiVrstaRepositoryR;
import lombok.AllArgsConstructor;

@Component
@Profile("raw")
@AllArgsConstructor
public class RadnikVrstaQueryRaw implements RadnikVrstaQuery {

	private final RadnkiVrstaRepositoryR radnikVrstaRepositoryR;
	
	@Override
	public List<RadnikVrsta> getAllRadnikVrsta() {
		return radnikVrstaRepositoryR.getAllRadnikVrsta();
	}
	
}
