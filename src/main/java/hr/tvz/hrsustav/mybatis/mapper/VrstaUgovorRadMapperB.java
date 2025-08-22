package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.VrstaUgovorRad;

@Mapper
public interface VrstaUgovorRadMapperB {

	public List<VrstaUgovorRad> getAllVrstaUgovorRad();
}