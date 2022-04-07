package br.com.duarteandreza.projetoaccenture.accentureacademy.repositories;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.LivroCaixa;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroCaixaRepository extends PagingAndSortingRepository<LivroCaixa, Long> {


    Page<LivroCaixa> findAllByClienteId(Long idCliente, Pageable pageable);

    boolean existsByClienteId(Long idcliente);
}
