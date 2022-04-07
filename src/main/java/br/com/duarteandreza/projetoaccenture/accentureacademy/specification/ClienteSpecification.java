package br.com.duarteandreza.projetoaccenture.accentureacademy.specification;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes_;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ClienteSpecification {

    private ClienteSpecification() {

    }

    public static Specification<Clientes> consultarPorNomeCpfCnpjCidadeUf(String nome, String cpfCnpj, String cidade, String uf) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(nome)) {
                predicates.add(builder.equal(root.get(Clientes_.NOME), nome));
            }

            if(StringUtils.hasText(cpfCnpj)) {
                predicates.add(builder.equal(root.get(Clientes_.CPF_CNPJ), cpfCnpj));
            }

            if(StringUtils.hasText(cidade)) {
                predicates.add(builder.equal(root.get(Clientes_.CIDADE), cidade));
            }

            if(StringUtils.hasText(uf)) {
                predicates.add(builder.equal(root.get(Clientes_.UF), uf));
            }

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
