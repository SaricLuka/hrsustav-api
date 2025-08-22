package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.RadnoMjesto;

@Mapper
public interface RadnoMjestoMapperB {

	public int createRadnoMjesto(RadnoMjesto radnoMjesto);

	public List<RadnoMjesto> getAllRadnoMjesto();

	public int updateRadnoMjesto(RadnoMjesto radnoMjesto);

	public int deleteRadnoMjesto(Integer idRadnoMjesto);
}