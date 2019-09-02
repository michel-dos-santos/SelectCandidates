package br.com.vagas.SelectCandidates.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vagas.SelectCandidates.exceptions.PessoaNotFoundException;
import br.com.vagas.SelectCandidates.model.entity.Candidatura;
import br.com.vagas.SelectCandidates.model.entity.Pessoa;
import br.com.vagas.SelectCandidates.model.entity.Vaga;
import br.com.vagas.SelectCandidates.model.request.VagaRequest;
import br.com.vagas.SelectCandidates.model.response.CandidaturaResponse;
import br.com.vagas.SelectCandidates.model.response.VagaResponse;
import br.com.vagas.SelectCandidates.repository.CandidaturaRepository;
import br.com.vagas.SelectCandidates.repository.PessoaRepository;
import br.com.vagas.SelectCandidates.repository.VagaRepository;

@RestController
public class VagaController {

	@Autowired
	private VagaRepository vagaRepository;

	@Autowired
	private CandidaturaRepository candidaturaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@PostMapping(path = "v1/vagas", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public ResponseEntity<VagaResponse> newJobOpportunity(@RequestBody VagaRequest vagaRequest) {
		Vaga vaga = Vaga.builder()
				.empresa(vagaRequest.getEmpresa())
				.titulo(vagaRequest.getTitulo())
				.descricao(vagaRequest.getDescricao())
				.localizacao(vagaRequest.getLocalizacao())
				.nivel(vagaRequest.getNivel()).build();
				
		Vaga saved = vagaRepository.save(vaga);
		 
		 if(saved == null) {
			 return ResponseEntity.status(HttpStatus.CONFLICT).header("Error", "Erro ao tentar salvar os dados.").build();
		 } else {
			 return ResponseEntity.status(HttpStatus.CREATED)
					 .body(VagaResponse.builder()
								.empresa(vagaRequest.getEmpresa())
								.titulo(vagaRequest.getTitulo())
								.descricao(vagaRequest.getDescricao())
								.localizacao(vagaRequest.getLocalizacao())
								.nivel(vagaRequest.getNivel()).build());
		 }
	 }

	@GetMapping("v1/vagas/{idVacantJob}/candidaturas/ranking")
	public ResponseEntity<List<CandidaturaResponse>> getVacantJobByID(@PathVariable Long idVacantJob){
		List<Candidatura> candidatos = candidaturaRepository.findByIdVagaOrderByScoreDesc(idVacantJob);
		
		List<CandidaturaResponse> candidaturas = new LinkedList<CandidaturaResponse>();
		
		candidatos.forEach(candidato -> {
			Pessoa pessoa = pessoaRepository.findById(candidato.getIdPessoa()).orElseThrow(() -> new PessoaNotFoundException(candidato.getIdPessoa()));
			candidaturas.add(CandidaturaResponse.builder()
					.nome(pessoa.getNome())
					.profissao(pessoa.getProfissao())
					.localizacao(pessoa.getLocalizacao())
					.nivel(pessoa.getNivel())
					.score(candidato.getScore()).build());
		});
		
		return ResponseEntity.ok().body(candidaturas);
	}

}
