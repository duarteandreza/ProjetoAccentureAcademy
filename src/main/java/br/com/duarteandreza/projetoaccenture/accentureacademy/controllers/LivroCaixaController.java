package br.com.duarteandreza.projetoaccenture.accentureacademy.controllers;


import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.LivroCaixa;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.AlterarDadosLivroRequest;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.CadastrarLivroRequest;
import br.com.duarteandreza.projetoaccenture.accentureacademy.services.LivroCaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroCaixaController {

    @Autowired
    private LivroCaixaService livroCaixaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroCaixa incluirNovo(@RequestBody @Valid CadastrarLivroRequest cadastrarLivroRequest){
        return livroCaixaService.incluir(cadastrarLivroRequest);
    }

    @PutMapping(path = "/{id}/alterar")
    public LivroCaixa alterarDados(@PathVariable Long id, @RequestBody @Valid AlterarDadosLivroRequest alterarDadosLivroRequest) throws Exception {
        return livroCaixaService.alterarDados(id, alterarDadosLivroRequest);
    }

    @DeleteMapping(path = "/{id}/deletar")
    @ResponseStatus(HttpStatus.OK)
    public void excluirRegistro(@PathVariable Long id){
        livroCaixaService.excluirRegistro(id);
    }

    @GetMapping(path = "/{id}")
    public LivroCaixa buscarLivroId(@PathVariable Long id){
        return livroCaixaService.buscarLivroId(id);
    }

    @GetMapping(path = "/clientes/{idCliente}")
    public Page<LivroCaixa> listarLivroCaixaIdCliente(@PathVariable("idCliente") Long idCliente, @PageableDefault(sort = "nome") @ApiIgnore Pageable pageable){
        return livroCaixaService.listarLivroCaixaIdCliente(idCliente, pageable);
    }


}
