package br.com.vagas.SelectCandidates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vagas.SelectCandidates.model.entity.Pessoa;
import br.com.vagas.SelectCandidates.model.request.PessoaRequest;
import br.com.vagas.SelectCandidates.model.response.PessoaResponse;
import br.com.vagas.SelectCandidates.repository.PessoaRepository;

@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	 @PostMapping(path = "v1/pessoas", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE}) 
	 public ResponseEntity<PessoaResponse> newPerson(@RequestBody PessoaRequest pessoaRequest) {
		 Pessoa pessoa = Pessoa.builder()
				 .nome(pessoaRequest.getNome())
				 .profissao(pessoaRequest.getProfissao())
				 .localizacao(pessoaRequest.getLocalizacao())
				 .nivel(pessoaRequest.getNivel()).build();
		 Pessoa saved = pessoaRepository.save(pessoa);
		 
		 if(saved == null) {
			 return ResponseEntity.status(HttpStatus.CONFLICT).header("Error", "Erro ao tentar salvar os dados.").build();
		 } else {
			 return ResponseEntity.status(HttpStatus.CREATED).
					 body(PessoaResponse.builder()
							 .nome(pessoaRequest.getNome())
							 .profissao(pessoaRequest.getProfissao())
							 .localizacao(pessoaRequest.getLocalizacao())
							 .nivel(pessoaRequest.getNivel()).build());
		 }
	 }
	
}
