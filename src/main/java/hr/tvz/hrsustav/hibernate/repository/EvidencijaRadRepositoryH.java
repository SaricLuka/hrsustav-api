package hr.tvz.hrsustav.hibernate.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.hrsustav.entity.EvidencijaRad;

public interface EvidencijaRadRepositoryH extends JpaRepository<EvidencijaRad, Integer> {

	List<EvidencijaRad> findByRadnikFkAndDatumBetween(Integer radnikFk, Date start, Date end);
}