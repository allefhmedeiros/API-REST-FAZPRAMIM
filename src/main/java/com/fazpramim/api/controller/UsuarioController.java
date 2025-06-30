package com.fazpramim.api.controller;

import com.fazpramim.api.dto.dtoDadosAtualizacaoUsuario;
import com.fazpramim.api.dto.dtoDadosCadastroUsuario;
import com.fazpramim.api.dto.dtoDadosListagemUsuario;
import com.fazpramim.api.entities.Usuario;
import com.fazpramim.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //Notifica o spring que essa classe deve ser inicializada com o projeto.
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid dtoDadosCadastroUsuario dados){
        repository.save(new Usuario(dados));
        //System.out.println(dados);
    }

    //Page vai devovler informações e funções de paginação. Abaixo o page vai devolver 3 registros por pagina e carregar a página 4 (Começando por 0,1,2,3,4,5...)
    //http://localhost:8080/usuarios?size=3&page=4

    //No exemplo abaixo nós ordenamos a resposta da requisição.
    //http://localhost:8080/usuarios?sort=dataNascimento,desc

    //@PageableDefault(size=10, sort = {"nome"}) irá configurar a devolução padrão caso cliente não defina o total de regustros e a classificação que deseja.
    //Isso previne problemas de performance.

    @GetMapping
    public Page<dtoDadosListagemUsuario> listarUsuarios(@PageableDefault(size=10, sort = {"nome"}) Pageable paginarDevolucao){
        return repository.findAllByStatusTrue(paginarDevolucao).map(dtoDadosListagemUsuario::new);
    }

    @PutMapping
    @Transactional
    public void atualizarUsuario(@RequestBody @Valid dtoDadosAtualizacaoUsuario dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirUsuario(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.inativarUsuario();
    }

}
