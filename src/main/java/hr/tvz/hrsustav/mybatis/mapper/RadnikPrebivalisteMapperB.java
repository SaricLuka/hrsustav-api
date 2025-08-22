package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;

@Mapper
public interface RadnikPrebivalisteMapperB {

	public List<Integer> getNextIds(Integer count);

	public int createRadnikPrebivaliste(List<RadnikPrebivaliste> radnikPrebivaliste);

	public List<RadnikPrebivaliste> getRadnikPrebivalisteByRadnik(Integer id);

	public List<RadnikPrebivaliste> getRadnikPrebivalisteByMjesto(Integer id);

	public int updateRadnikPrebivaliste(RadnikPrebivaliste radnikPrebivaliste);

	public int deleteRadnikPrebivaliste(Integer id);
}
