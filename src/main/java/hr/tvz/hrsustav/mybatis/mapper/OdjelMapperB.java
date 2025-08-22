package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.Odjel;

@Mapper
public interface OdjelMapperB {

	public int createOdjel(Odjel odjel);

	public List<Odjel> getAllOdjel();

	public int updateOdjel(Odjel odjel);

	public int deleteOdjel(Integer idOdjel);
}