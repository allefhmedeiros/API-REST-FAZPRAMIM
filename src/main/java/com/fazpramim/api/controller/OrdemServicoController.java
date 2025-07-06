package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOOrdemServicoAtualizacao;
import com.fazpramim.api.dto.DTOOrdemServicoCadastro;
import com.fazpramim.api.dto.DTOOrdemServicoListagem;
import com.fazpramim.api.entities.OrdemServico;
import com.fazpramim.api.repository.ClienteRepository;
import com.fazpramim.api.repository.EnderecoRepository;
import com.fazpramim.api.repository.OrdemServicoRepository;
import com.fazpramim.api.repository.StatusRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ordemservico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<DTOOrdemServicoListagem> cadastrarOrdemServico(@RequestBody @Valid DTOOrdemServicoCadastro dados){
        var status = statusRepository.getReferenceById(Long.valueOf("5"));
        var cliente = clienteRepository.getReferenceById(dados.id_cliente());
        var endereco = enderecoRepository.getReferenceById(dados.id_endereco());
        var ordemServicoCriada = ordemServicoRepository.save(new OrdemServico(dados, cliente, endereco, status));
        var ordemServicoCriadaDTO = new DTOOrdemServicoListagem(ordemServicoCriada);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordemServicoCriadaDTO);
    }

    @GetMapping
    public Page<DTOOrdemServicoListagem> listarOrdensServico(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        return ordemServicoRepository.findAll(paginacao).map(DTOOrdemServicoListagem::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DTOOrdemServicoListagem> atualizarOrdemServico(@RequestBody @Valid DTOOrdemServicoAtualizacao dados){

        var ordemServico = ordemServicoRepository.getReferenceById(dados.id());
        var status = statusRepository.getReferenceById(dados.id_status());
        var cliente = clienteRepository.getReferenceById(dados.id_cliente());
        var endereco = enderecoRepository.getReferenceById(dados.id_endereco());
        ordemServico.atualizarInformacoes(dados, status, cliente, endereco);

        var ordemServicoCriadaDTO = new DTOOrdemServicoListagem(ordemServico);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordemServicoCriadaDTO);

    }

}
