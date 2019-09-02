package br.com.vagas.SelectCandidates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vagas.SelectCandidates.exceptions.PessoaNotFoundException;
import br.com.vagas.SelectCandidates.exceptions.VagaNotFoundException;
import br.com.vagas.SelectCandidates.model.entity.Candidatura;
import br.com.vagas.SelectCandidates.model.entity.Pessoa;
import br.com.vagas.SelectCandidates.model.entity.Vaga;
import br.com.vagas.SelectCandidates.model.request.CandidaturaRequest;
import br.com.vagas.SelectCandidates.model.response.CandidaturaResponse;
import br.com.vagas.SelectCandidates.repository.CandidaturaRepository;
import br.com.vagas.SelectCandidates.repository.PessoaRepository;
import br.com.vagas.SelectCandidates.repository.VagaRepository;
import br.com.vagas.SelectCandidates.util.score.CalculoScore;

@RestController
public class CandidaturaController {

	@Autowired
	private CandidaturaRepository candidaturaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private VagaRepository vagaRepository;
	
	 @PostMapping("v1/candidaturas") 
	 public ResponseEntity<CandidaturaResponse> newCandidacy(@RequestBody CandidaturaRequest candidaturaRequest) {
		 try {
			 Pessoa pessoa = pessoaRepository.findById(candidaturaRequest.getIdPessoa()).orElseThrow(() -> new PessoaNotFoundException(candidaturaRequest.getIdPessoa()));
			 Vaga vaga = vagaRepository.findById(candidaturaRequest.getIdVaga()).orElseThrow(() -> new VagaNotFoundException(candidaturaRequest.getIdVaga()));
			 
			 Candidatura candidatura = Candidatura.builder()
					 .idPessoa(candidaturaRequest.getIdPessoa())
					 .idVaga(candidaturaRequest.getIdVaga())
					 .score(CalculoScore.getScoreCandidatoVaga(pessoa, vaga)).build();
			 
			 Candidatura saved = candidaturaRepository.save(candidatura);
			 
			 if(saved == null) {
				 return ResponseEntity.status(HttpStatus.CONFLICT).header("Error", "Erro ao tentar salvar os dados.").build();
			 } else {
				 return ResponseEntity.status(HttpStatus.CREATED).
						 body(CandidaturaResponse.builder()
								 .nome(pessoa.getNome())
								 .profissao(pessoa.getProfissao())
								 .localizacao(pessoa.getLocalizacao())
								 .nivel(pessoa.getNivel())
								 .score(CalculoScore.getScoreCandidatoVaga(pessoa, vaga)).build());
			 }
		 } catch(PessoaNotFoundException | VagaNotFoundException e) {
			 return ResponseEntity.status(HttpStatus.CONFLICT).header("Error", "Erro ao tentar salvar os dados.").build();
		 }
	 }
	
}
