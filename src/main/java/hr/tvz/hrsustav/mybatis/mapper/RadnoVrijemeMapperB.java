package hr.tvz.hrsustav.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.UgovorRad;

@Mapper
public interface RadnoVrijemeMapperB {

	int createRadnoVrijme(UgovorRad ugovorRad);

	int updateRadnoVrijeme(UgovorRad ugovorRad);
}
