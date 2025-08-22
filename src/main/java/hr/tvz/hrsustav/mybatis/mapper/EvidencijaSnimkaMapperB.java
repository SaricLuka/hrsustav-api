package hr.tvz.hrsustav.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.dto.EvidencijaSnimkaDto;
import hr.tvz.hrsustav.dto.request.EvidencijaSnimkaRequest;

@Mapper
public interface EvidencijaSnimkaMapperB {

	int createEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest);

	List<EvidencijaSnimkaDto> getEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest);

	int updateEvidencijaSnimka(EvidencijaSnimkaRequest evidencijaSnimkaRequest);

	int deleteEvidencijaSnimka(Integer id);
}
