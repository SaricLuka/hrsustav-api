package hr.tvz.hrsustav.mybatis.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.dto.UgovorRadDto;
import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.UgovorRad;

@Mapper
public interface UgovorRadMapperB {

	public int createUgovorRad(UgovorRad ugovorRad);

	public List<UgovorRadDto> getAllUgovorRad(UgovorRadGetRequest request);

	public int updateUgovorRad(UgovorRad ugovorRad);

	public int deleteUgovorRad(Integer idUgovorRad);
}
