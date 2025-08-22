package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.dto.RadnikOdjelDto;
import hr.tvz.hrsustav.dto.request.RadnikOdjelRequest;

@Mapper
public interface RadnikOdjelMapperB {

	public int createRadnikOdjel(RadnikOdjelRequest radnikOdjel);

	public List<RadnikOdjelDto> getRadnikOdjelByRadnik(Integer id);

	public List<RadnikOdjelDto> getRadnikOdjelByOdjel(Integer id);

	public int updateRadnikOdjel(RadnikOdjelRequest radnikOdjel);

	public int deleteRadnikOdjel(Integer id);
}
