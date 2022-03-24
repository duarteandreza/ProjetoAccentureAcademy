package br.com.duarteandreza.projetoaccenture.accentureacademy.repositories;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    boolean existsByCpfCnpj(String cpfCnpj);

    boolean existsByEmail(String email);
}
