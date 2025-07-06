package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTODetalheServicoCadastro;
import com.fazpramim.api.entities.DetalheServico;
import com.fazpramim.api.repository.CatalogoRepository;
import com.fazpramim.api.repository.DetalheServicoRepository;
import com.fazpramim.api.repository.OrdemServicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void cadastrarDetalheServico(@RequestBody @Valid DTODetalheServicoCadastro dados){

        var catalogo = catalogoRepository.getReferenceById(dados.id_catalogo());
        var ordemServico = ordemServicoRepository.getReferenceById(dados.id_ordem_servico());
        var subtotal = catalogo.getValor_hora()*dados.qtd_horas();

        if(ordemServico.getStatus().getId() == 5){
            detalheServicoRepository.save(new DetalheServico(dados, catalogo, ordemServico, subtotal));
            var valorTotal = ordemServico.getValor_total();
            var valotTotalAtualizado = valorTotal + subtotal;
            ordemServico.setValor_total(valotTotalAtualizado);
            ordemServicoRepository.save(ordemServico);
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirDetalheServico(@PathVariable Long id){
        var detalheServico = detalheServicoRepository.getReferenceById(id);
        var ordemServico = ordemServicoRepository.getReferenceById(detalheServico.getOrdem_servico().getId());
        var valorTotal = ordemServico.getValor_total();
        var valorTotalAtualizado = valorTotal - detalheServico.getSub_total();
        ordemServico.setValor_total(valorTotalAtualizado);
        ordemServicoRepository.save(ordemServico);
        detalheServicoRepository.deleteById(id);
    }

}
