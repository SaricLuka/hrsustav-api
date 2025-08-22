package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.Spol;

@Mapper
public interface SpolMapperB {
	
	public List<Spol> getAllSpol();
}