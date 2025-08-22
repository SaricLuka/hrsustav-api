package hr.tvz.hrsustav.hibernate.criteria;

import hr.tvz.hrsustav.dto.RadnikDto;
import hr.tvz.hrsustav.dto.request.RadnikGetRequest;
import hr.tvz.hrsustav.entity.Radnik;
import hr.tvz.hrsustav.entity.Spol;
import hr.tvz.hrsustav.entity.RadnikVrsta;
import hr.tvz.hrsustav.entity.RadnikOdjel;
import hr.tvz.hrsustav.entity.UgovorRad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("java:S1192")
@Repository
@AllArgsConstructor
public class RadnikRepositoryC {

	private final EntityManager entityManager;

	public List<RadnikDto> findAllRadnik(RadnikGetRequest request) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<RadnikDto> query = cb.createQuery(RadnikDto.class);
		Root<Radnik> r = query.from(Radnik.class);

		Join<Radnik, Spol> s = r.join("spolFk", JoinType.LEFT);
		Join<Radnik, RadnikVrsta> rv = r.join("radnikVrstaFk", JoinType.LEFT);
		Join<Radnik, RadnikOdjel> ro = r.join("radnikOdjel", JoinType.LEFT);
		Join<Radnik, UgovorRad> ur = r.join("ugovorRad", JoinType.LEFT);

		query.select(cb.construct(
				RadnikDto.class,
				r.get("idRadnik"),
				r.get("radnikNadredFk").get("idRadnik"),
				r.get("ime"),
				r.get("prezime"),
				r.get("oib"),
				s.get("oznaka"),
				r.get("datumRod"),
				rv.get("naziv"),
				ro.get("odjelFk").get("idOdjel"),
				ur.get("idUgovorRad"),
				ro.get("datumOd"),
				ur.get("datumOd")));

		List<Predicate> predicates = new ArrayList<>();

		addPredicateIfNotNull(predicates, cb, r.get("idRadnik"), request.getIdRadnik());
		addPredicateIfNotNull(predicates, cb, r.get("radnikNadredFk"), request.getRadnikNadredFk());
		addPredicateIfNotNull(predicates, cb, r.get("ime"), request.getIme());
		addPredicateIfNotNull(predicates, cb, r.get("prezime"), request.getPrezime());
		addPredicateIfNotNull(predicates, cb, r.get("oib"), request.getOib());
		addPredicateIfNotNull(predicates, cb, r.get("spolFk"), request.getSpolFk());
		addPredicateIfNotNull(predicates, cb, r.get("datumRod"), request.getDatumRod());
		addPredicateIfNotNull(predicates, cb, r.get("radnikVrstaFk"), request.getRadnikVrstaFk());

		if (Boolean.TRUE.equals(request.getInOdjel())) {
			predicates.add(cb.lessThanOrEqualTo(ro.get("datumOd"), cb.currentDate()));
			predicates.add(cb.or(
					cb.greaterThanOrEqualTo(ro.get("datumDo"), cb.currentDate()),
					cb.isNull(ro.get("datumDo"))));
		}

		if (Boolean.TRUE.equals(request.getIsZaposlen())) {
			predicates.add(cb.lessThanOrEqualTo(ur.get("datumOd"), cb.currentDate()));
			predicates.add(cb.or(
					cb.greaterThanOrEqualTo(ur.get("datumDo"), cb.currentDate()),
					cb.isNull(ur.get("datumDo"))));
		}

		query.where(cb.and(predicates.toArray(new Predicate[0])));
		query.distinct(true);

		query.orderBy(
				cb.asc(r.get("idRadnik")),
				cb.desc(ro.get("datumOd")),
				cb.desc(ur.get("datumOd")));

		return entityManager.createQuery(query).getResultList();
	}

	private <T> void addPredicateIfNotNull(List<Predicate> predicates, CriteriaBuilder cb, Path<T> path, T value) {
		if (value != null) {
			predicates.add(cb.equal(path, value));
		}
	}
}