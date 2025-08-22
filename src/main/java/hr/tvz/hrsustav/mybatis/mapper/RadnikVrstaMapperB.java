package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.RadnikVrsta;

@Mapper
public interface RadnikVrstaMapperB {

	public List<RadnikVrsta> getAllRadnikVrsta();
}