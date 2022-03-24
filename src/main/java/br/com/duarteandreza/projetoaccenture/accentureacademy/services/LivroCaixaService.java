package br.com.duarteandreza.projetoaccenture.accentureacademy.services;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.LivroCaixa;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.IdNaoEncontradaException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.repositories.LivroCaixaRepository;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.AlterarDadosLivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LivroCaixaService {

    @Autowired
    private LivroCaixaRepository livroCaixaRepository;
    @Autowired
    private Clientes clientes;

    public LivroCaixa incluir(LivroCaixa livroCaixa) {

        if (clientes.getId().equals(livroCaixa.getIdCliente())) {
            livroCaixaRepository.save(livroCaixa);
        } else {
            throw new IdNaoEncontradaException(clientes.getId());
        }

        return livroCaixaRepository.save(livroCaixa);

    }

    public LivroCaixa alterarDados(Long id, AlterarDadosLivroRequest alterarDadosLivroRequest) {

        LivroCaixa livroCaixa = buscarLivroId(id);

        if (livroCaixaRepository.existsById(id)) {
            livroCaixa.setDescricao(alterarDadosLivroRequest.getDescricao());
            livroCaixa.setTipoLacamentoCaixa(alterarDadosLivroRequest.getTipoLacamentoCaixa());
            livroCaixa.setValor(alterarDadosLivroRequest.getValor());

            livroCaixaRepository.save(livroCaixa);

        } else {

            throw new IdNaoEncontradaException(id);

        }

        return livroCaixa;

    }

    public void excluirRegistro(Long id) {

        LivroCaixa livroCaixa = buscarLivroId(id);

        if (livroCaixa == null){
            throw new IdNaoEncontradaException(id);
        }

        livroCaixaRepository.delete(livroCaixa);

    }

    public LivroCaixa buscarLivroId(Long id) {

        return livroCaixaRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradaException(id));

    }

//    public Page<LivroCaixa> listar(LivroCaixa livroCaixa, Pageable pageable) {
//    }
}
