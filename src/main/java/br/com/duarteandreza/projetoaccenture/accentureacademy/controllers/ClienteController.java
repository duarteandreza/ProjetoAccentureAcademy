package br.com.duarteandreza.projetoaccenture.accentureacademy.controllers;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

//    @Autowired
//    private ClienteService clienteService;
//
//    @PostMapping
//    public Clientes incluirNovo(@RequestBody @Valid Clientes cliente){
//        return clienteService.incluir(cliente);
//    }
//
//    @PutMapping(path = "/{id}")
//    public Clientes alterarDados(@PathVariable Long id,@RequestBody @Valid AlterarDadosRequest alterarDadosRequest) throws Exception {
//        return clienteService.alterarDados(id, alterarDadosRequest);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void excluirCliente(@PathVariable Long id){
//        clienteService.excluirCliente(id);
//    }
//
//    @GetMapping(path = "/{id}")
//    public Clientes buscarClienteId(@PathVariable Long id){
//        return clienteService.buscarClienteId(id);
//    }
//
//    @GetMapping
//    public Page<Clientes> listarClientes(Clientes cliente, @PageableDefault(sort = "nome") @ApiIgnore Pageable pageable){
//        return clienteService.listar(cliente, pageable);
//    }
//

}
