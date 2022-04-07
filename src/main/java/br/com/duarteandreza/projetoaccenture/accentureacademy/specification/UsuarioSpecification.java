package br.com.duarteandreza.projetoaccenture.accentureacademy.specification;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioSpecification {

    private UsuarioSpecification() {

    }

    public static Specification<Usuario> consultarPorNomeEmail(String nome, String email) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(nome)) {
                predicates.add(builder.equal(root.get(Usuario_.nome), nome));
            }

            if(StringUtils.hasText(email)) {
                predicates.add(builder.equal(root.get(Usuario_.email), email));
            }

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
