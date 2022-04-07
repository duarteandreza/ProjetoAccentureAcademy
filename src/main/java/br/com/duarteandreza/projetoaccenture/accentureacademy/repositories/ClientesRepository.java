package br.com.duarteandreza.projetoaccenture.accentureacademy.repositories;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long>, JpaSpecificationExecutor<Clientes> {

    boolean existsByCpfCnpj(String cpfCnpj);

    boolean existsByEmail(String email);
}
