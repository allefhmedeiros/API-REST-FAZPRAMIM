package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOClienteListagem;
import com.fazpramim.api.dto.DTOEnderecoCadastro;
import com.fazpramim.api.dto.DTOEnderecoListagem;
import com.fazpramim.api.entities.Endereco;
import com.fazpramim.api.repository.ClienteRepository;
import com.fazpramim.api.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private ClienteRepository repositoryCliente;

    @PostMapping
    public void cadastrarEndereco(@RequestBody @Valid DTOEnderecoCadastro dados){
        var cliente = repositoryCliente.getReferenceById(dados.id_cliente());
        Endereco endereco = new Endereco(dados, cliente);
        repository.save(endereco);
    }

    @GetMapping
    public Page<DTOEnderecoListagem> listarEnderecos(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        return repository.findAllByStatusTrue(paginacao).map(DTOEnderecoListagem::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirEndereco(@PathVariable Long id){
        var endereco = repository.getReferenceById(id);
        endereco.excluirEndereco();
    }

}
