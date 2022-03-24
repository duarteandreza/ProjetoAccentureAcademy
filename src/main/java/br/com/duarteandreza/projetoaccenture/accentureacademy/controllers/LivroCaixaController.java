package br.com.duarteandreza.projetoaccenture.accentureacademy.controllers;


//import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.LivroCaixa;
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
@RequestMapping("/registroLivroCaixa")
public class LivroCaixaController {
//
//
//    @Autowired
//    private LivroCaixaService livroCaixaService;
//
//    @PostMapping
//    public LivroCaixa incluirNovo(@RequestBody @Valid LivroCaixa livroCaixa){
//        return livroCaixaService.incluir(livroCaixa);
//    }
//
//    @PutMapping(path = "/{id}")
//    public LivroCaixa alterarDados(@PathVariable Long id, @RequestBody @Valid AlterarDadosRequest alterarDadosRequest) throws Exception {
//        return livroCaixaService.alterarDados(id, alterarDadosRequest);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void excluirRegistro(@PathVariable Long id){
//        livroCaixaService.excluirRegistro(id);
//    }
//
//    @GetMapping(path = "/{id}")
//    public LivroCaixa buscarLivroId(@PathVariable Long id){
//        return livroCaixaService.buscarLivroId(id);
//    }
//
//    @GetMapping(path = "/clientes/{id}")
//    public Page<LivroCaixa> listarLivroCaixa(LivroCaixa livroCaixa, @PageableDefault(sort = "nome") @ApiIgnore Pageable pageable){
//        return livroCaixaService.listar(livroCaixa, pageable);
//    }
//
//
//

}
