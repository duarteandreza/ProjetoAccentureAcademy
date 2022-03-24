package br.com.duarteandreza.projetoaccenture.accentureacademy.repositories;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    //Usuario findById(Long id);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    Page<Usuario> findByNome(String nomeUsuario, Pageable pageable);

    Page<Usuario> findByEmail(String emailUsuario, Pageable pageable);

    Page<Usuario> findByNomeAndEmail(String nomeUsuario, String emailUsuario, Pageable pageable);

}
