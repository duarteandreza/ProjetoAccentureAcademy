//package br.com.duarteandreza.projetoaccenture.accentureacademy.controllers;
//
//
//import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AutenticacaoController {
//
//    @Autowired
//    private AutenticacaoUsuarioService autenticacaoUsuarioService;
//
//    public AutenticacaoController(AutenticacaoUsuarioService autenticacaoUsuarioService){
//        this.autenticacaoUsuarioService = autenticacaoUsuarioService;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
//        Usuario usuario = userAuthenticationService.authenticate(dadosLogin, Authorization);
//        return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(usuario, "Bearer "), HttpStatus.ACCEPTED);
//    }
//
//}
