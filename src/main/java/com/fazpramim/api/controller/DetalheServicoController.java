package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOClienteListagem;
import com.fazpramim.api.dto.DTODetalhePedidoListagem;
import com.fazpramim.api.dto.DTODetalheServicoCadastro;
import com.fazpramim.api.entities.DetalheServico;
import com.fazpramim.api.repository.CatalogoRepository;
import com.fazpramim.api.repository.DetalheServicoRepository;
import com.fazpramim.api.repository.OrdemServicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("detalheservico")
public class DetalheServicoController {

    @Autowired
    private DetalheServicoRepository detalheServicoRepository;

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    public ResponseEntity cadastrarDetalheServico(@RequestBody @Valid DTODetalheServicoCadastro dados, UriComponentsBuilder uriBuilder){

        var catalogo = catalogoRepository.getReferenceById(dados.id_catalogo());
        var ordemServico = ordemServicoRepository.getReferenceById(dados.id_ordem_servico());
        var subtotal = catalogo.getValor_hora()*dados.qtd_horas();

        if(ordemServico.getStatus().getId() == 5){
            var novoServico = new DetalheServico(dados, catalogo, ordemServico, subtotal);
            detalheServicoRepository.save(novoServico);
            var valorTotal = ordemServico.getValor_total();
            var valotTotalAtualizado = valorTotal + subtotal;
            ordemServico.setValor_total(valotTotalAtualizado);
            ordemServicoRepository.save(ordemServico);

            var uri = uriBuilder.path("/detalheservico/{id}").buildAndExpand(novoServico.getId()).toUri();
            return ResponseEntity.created(uri).body(novoServico);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirDetalheServico(@PathVariable Long id){
        var detalheServico = detalheServicoRepository.getReferenceById(id);
        var ordemServico = ordemServicoRepository.getReferenceById(detalheServico.getOrdem_servico().getId());
        var valorTotal = ordemServico.getValor_total();
        var valorTotalAtualizado = valorTotal - detalheServico.getSub_total();
        ordemServico.setValor_total(valorTotalAtualizado);
        ordemServicoRepository.save(ordemServico);
        detalheServicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharDetalhesDeServico(@PathVariable Long id){
        var DetalheServico = detalheServicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DTODetalhePedidoListagem(DetalheServico));
    }

}
