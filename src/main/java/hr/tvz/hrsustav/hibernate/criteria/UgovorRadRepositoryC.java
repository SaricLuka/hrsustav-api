package hr.tvz.hrsustav.hibernate.criteria;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hr.tvz.hrsustav.dto.UgovorRadDto;
import hr.tvz.hrsustav.dto.request.UgovorRadGetRequest;
import hr.tvz.hrsustav.entity.RadnoVrijeme;
import hr.tvz.hrsustav.entity.UgovorRad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UgovorRadRepositoryC {

	private final EntityManager entityManager;

	public List<UgovorRadDto> findAllUgovorRad(UgovorRadGetRequest request) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<UgovorRadDto> query = cb.createQuery(UgovorRadDto.class);
		Root<UgovorRad> u = query.from(UgovorRad.class);
		Join<UgovorRad, RadnoVrijeme> r = u.join("radnoVrijemeFk", JoinType.LEFT);

		query.select(cb.construct(
				UgovorRadDto.class,
				u.get("idUgovorRad"),
				u.get("radnikFk"),
				u.get("datumUgovor"),
				u.get("datumOd"),
				u.get("datumDo"),
				u.get("mjestoRadaFk"),
				u.get("radnoMjestoFk"),
				r.get("idRadnoVrijeme"),
				r.get("vrstaRadnoVrijemeFk"),
				r.get("tjednoSati"),
				r.get("dnevnoSati"),
				r.get("godisnji"),
				u.get("vrstaUgovorRadFk"),
				u.get("brutoPlaca")));

		List<Predicate> predicates = new ArrayList<>();

		addPredicateIfNotNull(predicates, cb, u.get("idUgovorRad"), request.getIdUgovorRad());
		addPredicateIfNotNull(predicates, cb, u.get("radnikFk"), request.getRadnikFk());
		addDateRangePredicate(predicates, cb, u, "datumUgovor", request.getDatumUgovorFrom(),
				request.getDatumUgovorTo());
		addDateRangePredicate(predicates, cb, u, "datumOd", request.getDatumFrom(), request.getDatumTo(), "datumDo");
		addPredicateIfNotNull(predicates, cb, u.get("radnoMjestoFk"), request.getRadnoMjestoFk());

		query.where(cb.and(predicates.toArray(new Predicate[0])));

		return entityManager.createQuery(query).getResultList();
	}

	private <T> void addPredicateIfNotNull(List<Predicate> predicates, CriteriaBuilder cb, Path<T> path, T value) {
		Optional.ofNullable(value).ifPresent(v -> predicates.add(cb.equal(path, v)));
	}

	private void addDateRangePredicate(List<Predicate> predicates, CriteriaBuilder cb, Root<UgovorRad> u,
			String dateField,
			Date from, Date to) {
		if (from != null && to != null) {
			predicates.add(cb.between(u.get(dateField), from, to));
		} else if (from != null) {
			predicates.add(cb.greaterThanOrEqualTo(u.get(dateField), from));
		} else if (to != null) {
			predicates.add(cb.lessThanOrEqualTo(u.get(dateField), to));
		}
	}

	private void addDateRangePredicate(List<Predicate> predicates, CriteriaBuilder cb, Root<UgovorRad> u,
			String fromField,
			Date from, Date to, String toField) {
		if (from != null && to != null) {
			predicates.add(cb.greaterThanOrEqualTo(u.get(fromField), from));
			predicates.add(cb.lessThanOrEqualTo(u.get(toField), to));
		} else if (from != null) {
			predicates.add(cb.greaterThanOrEqualTo(u.get(fromField), from));
		} else if (to != null) {
			predicates.add(cb.lessThanOrEqualTo(u.get(toField), to));
		}
	}
}