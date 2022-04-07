package br.com.duarteandreza.projetoaccenture.accentureacademy.services;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.ObjetoJaExisteException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.ObjetoNaoEncontradoException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.repositories.UsuarioRepository;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.AlterarDadosUsuarioRequest;
import br.com.duarteandreza.projetoaccenture.accentureacademy.specification.UsuarioSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario incluir(Usuario usuario) {

        boolean loginJaCadastrado = usuarioRepository.existsByLogin(usuario.getLogin());

        if(loginJaCadastrado) {
            throw new ObjetoJaExisteException("Login informado já está cadastrado.");
        }

        boolean emailJaCadastrado = usuarioRepository.existsByEmail(usuario.getEmail());

        if(emailJaCadastrado) {
            throw new ObjetoJaExisteException("E-mail informado já está cadastrado.");
        }


        return usuarioRepository.save(usuario);

    }

    public Usuario alterarDados(Long id, AlterarDadosUsuarioRequest alterarDadosRequest) {

        Usuario usuario = buscarUsuarioId(id);

        if (usuarioRepository.existsById(id)) {
            usuario.setNome(alterarDadosRequest.getNome());
            usuario.setLogin(alterarDadosRequest.getLogin());
            usuario.setSenha(alterarDadosRequest.getSenha());
            usuario.setTelefone(alterarDadosRequest.getTelefone());
            if (usuario.getEmail().equals(alterarDadosRequest.getEmail())) {
                usuario.getEmail();
            } else {
                if (usuarioRepository.existsByEmail(alterarDadosRequest.getEmail())) {
                    throw new ObjetoJaExisteException("E-mail informado já está cadastrado.");
                } else {
                    usuario.setEmail(alterarDadosRequest.getEmail());
                }
            }
            usuario.setPerfilUsuario(alterarDadosRequest.getPerfilUsuario());

            usuarioRepository.save(usuario);

        } else {
            throw new ObjetoNaoEncontradoException("Id não encontrado.");
        }

        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Long id) {

        Usuario usuario = buscarUsuarioId(id);

        if (usuario == null){
            throw new ObjetoNaoEncontradoException("Id não encontrado.");
        }

        usuario.setAtivo(false);

        usuarioRepository.save(usuario);

    }

    public Usuario buscarUsuarioId(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Id não encontrado."));

    }

    public List<Usuario> listarPorNomeEmail(String nome, String email) {

        var specification = UsuarioSpecification.consultarPorNomeEmail(nome,email);

        return (List<Usuario>) usuarioRepository.findAll(specification);

    }

    public void login(Usuario loginUsuario) {

        boolean loginValido = usuarioRepository.existsByLoginAndSenhaAndAtivo(loginUsuario.getLogin(), loginUsuario.getSenha(),
                                                                                loginUsuario.getAtivo());

        if (!loginValido){

            throw new ObjetoNaoEncontradoException("Login inválido.");

        }

    }
}
