package br.com.vagas.SelectCandidates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vagas.SelectCandidates.model.entity.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
	
}
