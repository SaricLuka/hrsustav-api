package hr.tvz.hrsustav.mybatis.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hr.tvz.hrsustav.entity.EvidencijaRad;

@Mapper
public interface EvidencijaRadMapperB {

	public int createEvidencijaRad(EvidencijaRad evidencijaRad);

	public List<EvidencijaRad> getEvidencijaRad(Integer radnikFk, Date datumStart, Date datumEnd);

	public int updateEvidencijaRad(EvidencijaRad evidencijaRad);

	public int deleteEvidencijaRad(Integer idEvidencijaRad);
}
