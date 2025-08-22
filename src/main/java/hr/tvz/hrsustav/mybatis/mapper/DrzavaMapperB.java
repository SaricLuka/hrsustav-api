package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.Drzava;

@Mapper
public interface DrzavaMapperB {
	public List<Drzava> getAllDrzava();
}