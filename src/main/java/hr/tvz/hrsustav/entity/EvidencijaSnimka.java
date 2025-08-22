package hr.tvz.hrsustav.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvidencijaSnimka {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvidencijaSnimka;
	private Date datumOd;
	private Date datumDo;
	@ManyToOne
	@JoinColumn(name = "radnik_fk")
	private Radnik radnikFk;
	private byte[] snimka;
	private Date datum;
}
