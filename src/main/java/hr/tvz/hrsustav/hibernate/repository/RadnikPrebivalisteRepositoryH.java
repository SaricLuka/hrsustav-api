package hr.tvz.hrsustav.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.hrsustav.entity.RadnikPrebivaliste;

public interface RadnikPrebivalisteRepositoryH extends JpaRepository<RadnikPrebivaliste, Integer> {

	List<RadnikPrebivaliste> findByRadnikFk(Integer radnikFk);

	List<RadnikPrebivaliste> findByMjestoFk(Integer mjestoFk);
}