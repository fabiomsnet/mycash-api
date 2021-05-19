package org.bootcamp.spring.mycashapi.service;

import org.bootcamp.spring.mycashapi.domain.Lancamento;
import org.bootcamp.spring.mycashapi.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public List<Lancamento> findAll() {
        return repository.findAll();
    }

    public Lancamento findById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Lancamento criarLancamento(Lancamento lancamento) {
        return repository.save(lancamento);
    }

    public Lancamento alterarLancamento(Integer id , Lancamento novoLancamento) {
        return repository.findById(id).map(lancamento -> {
            lancamento.setDescricao(novoLancamento.getDescricao());
            lancamento.setData(novoLancamento.getData());
            lancamento.setValor(novoLancamento.getValor());
            lancamento.setTipo(novoLancamento.getTipo());
            return repository.save(lancamento);
        }).orElseThrow(EntityNotFoundException::new);
    }

    public void excluirLancamento(Integer id) {
        var lancamento = findById(id);
        repository.deleteById(lancamento.getId());
    }

}
