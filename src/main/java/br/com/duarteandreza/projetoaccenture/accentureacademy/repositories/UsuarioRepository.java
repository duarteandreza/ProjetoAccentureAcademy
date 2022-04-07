package br.com.duarteandreza.projetoaccenture.accentureacademy.repositories;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {


    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    boolean existsByLoginAndSenhaAndAtivo(String login, String senha, Boolean ativo);
}
