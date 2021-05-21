package org.bootcamp.spring.mycashapi.web.api;

import org.bootcamp.spring.mycashapi.domain.Lancamento;
import org.bootcamp.spring.mycashapi.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public List<Lancamento> lancamentos() {
        return lancamentoService.findAll();
    }

    @GetMapping("/{id}")
    public Lancamento lancamentoPorId(@PathVariable("id") Integer id) {
        return lancamentoService.findById(id);
    }

    @PostMapping
    public Lancamento criarLancamento(@Valid @RequestBody Lancamento lancamento) {
        return lancamentoService.criarLancamento(lancamento);
    }

    @PutMapping("/{id}")
    public Lancamento atualizarLancamento(@PathVariable Integer id, @RequestBody Lancamento lancamento) {
        return lancamentoService.alterarLancamento(id, lancamento);
    }

    @DeleteMapping("/{id}")
    public void excluirLancamento(@PathVariable Integer id) {
        lancamentoService.excluirLancamento(id);
    }

}