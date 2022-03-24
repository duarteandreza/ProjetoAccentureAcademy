package br.com.duarteandreza.projetoaccenture.accentureacademy.services;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.PerfilUsuario;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.EmailJaCadastradoException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.IdUsuarioNaoEncontradaException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.LoginJaCadastradoException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.repositories.UsuarioRepository;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.AlterarDadosUsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario incluir(Usuario usuario) {

        boolean loginJaCadastrado = usuarioRepository.existsByLogin(usuario.getLogin());

        if(loginJaCadastrado) {
            throw new LoginJaCadastradoException(usuario.getLogin());
        }

        boolean emailJaCadastrado = usuarioRepository.existsByEmail(usuario.getEmail());

        if(emailJaCadastrado) {
            throw new EmailJaCadastradoException(usuario.getEmail());
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
                    throw new EmailJaCadastradoException(alterarDadosRequest.getEmail());
                } else {
                    usuario.setEmail(alterarDadosRequest.getEmail());
                }
            }
            usuario.setPerfilUsuario(alterarDadosRequest.getPerfilUsuario());

            usuarioRepository.save(usuario);

        } else {
            throw new IdUsuarioNaoEncontradaException(id);
        }

        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Long id) {

        Usuario usuario = buscarUsuarioId(id);

        if (usuario == null){
            throw new IdUsuarioNaoEncontradaException(id);
        }

        usuario.setAtivo(false);

        usuarioRepository.save(usuario);

    }

    public Usuario buscarUsuarioId(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IdUsuarioNaoEncontradaException(id));

    }

    public Page<Usuario> listarPorNome(String nomeUsuario, Pageable pageable) {

        return usuarioRepository.findByNome(nomeUsuario, pageable);

    }

    public Page<Usuario> listarPorEmail(String emailUsuario, Pageable pageable) {

        return usuarioRepository.findByEmail(emailUsuario, pageable);

    }

    public Page<Usuario> listarPorNomeEEmail(String nomeUsuario, String emailUsuario, Pageable pageable) {

        return usuarioRepository.findByNomeAndEmail(nomeUsuario, emailUsuario, pageable);

    }
}
