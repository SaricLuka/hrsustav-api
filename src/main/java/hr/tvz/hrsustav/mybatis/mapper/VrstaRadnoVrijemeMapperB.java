package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.VrstaRadnoVrijeme;

@Mapper
public interface VrstaRadnoVrijemeMapperB {

	public List<VrstaRadnoVrijeme> getAllVrstaRadnoVrijeme();
}