package br.com.duarteandreza.projetoaccenture.accentureacademy.controllers;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.AlterarDadosUsuarioRequest;
import br.com.duarteandreza.projetoaccenture.accentureacademy.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario incluirNovo(@RequestBody @Valid Usuario usuario){
        return usuarioService.incluir(usuario);
    }

    @PutMapping(path = "/{id}/alterar")
    public Usuario alterarDados(@PathVariable Long id,@RequestBody @Valid AlterarDadosUsuarioRequest alterarDadosUsuarioRequest) {
        return usuarioService.alterarDados(id, alterarDadosUsuarioRequest);
    }

    @DeleteMapping(path = "/{id}/excluir")
    @ResponseStatus(HttpStatus.OK)
    public void excluirUsuario(@PathVariable Long id){
        usuarioService.excluirUsuario(id);
    }

    @GetMapping(path = "/{id}")
    public Usuario buscarUsuarioId(@PathVariable Long id){
        return usuarioService.buscarUsuarioId(id);
    }

    @GetMapping
    public List<Usuario> listarUsuariosPorNomeEmail(
            @RequestParam (required = false) String nome,
            @RequestParam (required = false) String email)
            {
        return (List<Usuario>) usuarioService.listarPorNomeEmail(nome, email);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void login(@RequestBody @Valid Usuario loginUsuario){
        usuarioService.login(loginUsuario);
    }

}
