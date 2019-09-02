package br.com.vagas.SelectCandidates.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vagas.SelectCandidates.model.entity.Candidatura;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
	
	List<Candidatura> findByIdVagaOrderByScoreDesc(Long idVaga);
	
}
