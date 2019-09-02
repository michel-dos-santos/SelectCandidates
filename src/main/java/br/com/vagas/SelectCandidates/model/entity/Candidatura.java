package br.com.vagas.SelectCandidates.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="id")
public class Candidatura {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Getter private Long id;
	@Getter @Setter	private Long idVaga;
	@Getter @Setter	private Long idPessoa;
	@Getter @Setter	private Integer score;

}
