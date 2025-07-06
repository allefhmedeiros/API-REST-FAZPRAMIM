package com.fazpramim.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fazpramim.api.dto.DTOOrdemServicoAtualizacao;
import com.fazpramim.api.dto.DTOOrdemServicoCadastro;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name="tbl_ordem_servico")
@Entity(name="OrdemServico")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data_cadastro;
    private LocalDateTime data_agendamento;
    private Double valor_total;
    @ManyToOne
    @JoinColumn(name = "tbl_status_id")
    @JsonBackReference
    private Status status;
    @ManyToOne
    @JoinColumn(name = "tbl_cliente_id")
    @JsonBackReference
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "tbl_endereco_id")
    @JsonBackReference
    private Endereco endereco;
    @OneToMany(mappedBy = "ordem_servico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<DetalheServico> detalhes = new ArrayList<>();

    public OrdemServico() {

    }

    public OrdemServico(DTOOrdemServicoCadastro dados, Cliente cliente, Endereco endereco, Status status) {
        LocalDateTime dataAtual = LocalDateTime.now();
        this.data_cadastro = dataAtual;
        this.data_agendamento = dados.data_agendamento();
        this.valor_total = 0.0;
        this.status = status;
        this.cliente = cliente;
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServico that = (OrdemServico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public LocalDateTime getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(LocalDateTime data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void atualizarInformacoes(DTOOrdemServicoAtualizacao dados, Status status, Cliente cliente, Endereco endereco) {
        if(dados.data_agendamento() != null){
            this.data_agendamento = dados.data_agendamento();
        }
        if(dados.valor_total() != null){
            this.valor_total = dados.valor_total();
        }
        if(dados.id_status() != null){
            this.status = status;
        }
        if(dados.id_cliente() != null){
            this.cliente = cliente;
        }
        if(dados.id_endereco() != null){
            this.endereco = endereco;
        }

    }


    public List<DetalheServico> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(List<DetalheServico> detalhes) {
        this.detalhes = detalhes;
    }
}
