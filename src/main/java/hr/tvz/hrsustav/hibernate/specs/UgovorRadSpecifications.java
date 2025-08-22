package hr.tvz.hrsustav.hibernate.specs;

import java.sql.Date;

import org.springframework.data.jpa.domain.Specification;

import hr.tvz.hrsustav.entity.UgovorRad;

public class UgovorRadSpecifications {

	private UgovorRadSpecifications() {
	}

	public static Specification<UgovorRad> hasIdUgovorRad(Integer id) {
		return (root, query, cb) -> id == null ? null : cb.equal(root.get("idUgovorRad"), id);
	}

	public static Specification<UgovorRad> hasRadnikFk(Integer radnikFk) {
		return (root, query, cb) -> radnikFk == null ? null : cb.equal(root.get("radnikFk"), radnikFk);
	}

	public static Specification<UgovorRad> datumUgovorBetween(Date from, Date to) {
		return (root, query, cb) -> {
			if (from == null && to == null)
				return null;
			if (from == null)
				return cb.lessThanOrEqualTo(root.get("datumUgovor"), to);
			if (to == null)
				return cb.greaterThanOrEqualTo(root.get("datumUgovor"), from);
			return cb.between(root.get("datumUgovor"), from, to);
		};
	}

	public static Specification<UgovorRad> datumBetween(Date from, Date to) {
		return (root, query, cb) -> {
			if (from == null && to == null)
				return null;
			if (from == null)
				return cb.lessThanOrEqualTo(cb.literal(to), root.get("datumDo"));
			if (to == null)
				return cb.lessThanOrEqualTo(root.get("datumOd"), from);
			return cb.and(
					cb.lessThanOrEqualTo(cb.literal(from), root.get("datumOd")),
					cb.lessThanOrEqualTo(cb.literal(to), root.get("datumDo")));
		};
	}

	public static Specification<UgovorRad> hasRadnoMjestoFk(Integer radnoMjestoFk) {
		return (root, query, cb) -> radnoMjestoFk == null ? null : cb.equal(root.get("radnoMjestoFk"), radnoMjestoFk);
	}
}
