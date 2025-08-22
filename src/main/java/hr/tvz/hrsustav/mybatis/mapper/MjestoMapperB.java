package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.Mjesto;

@Mapper
public interface MjestoMapperB {

	public List<Mjesto> getAllMjesto();
}