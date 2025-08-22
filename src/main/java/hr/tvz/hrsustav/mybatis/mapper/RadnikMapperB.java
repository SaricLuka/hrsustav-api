package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.dto.request.RadnikRequest;

@Mapper
public interface RadnikMapperB {

	public int createRadnik(RadnikRequest radnik);

	public List<RadnikDto> getAllRadnik(RadnikGetRequest request);

	public int updateRadnik(RadnikRequest radnik);

	public int deleteRadnik(Integer idRadnik);
}