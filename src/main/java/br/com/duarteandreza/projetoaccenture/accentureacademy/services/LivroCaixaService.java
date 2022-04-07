package br.com.duarteandreza.projetoaccenture.accentureacademy.services;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.LivroCaixa;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.ObjetoJaExisteException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.ObjetoNaoEncontradoException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.repositories.LivroCaixaRepository;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.AlterarDadosLivroRequest;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.CadastrarLivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LivroCaixaService {

    @Autowired
    private LivroCaixaRepository livroCaixaRepository;
    @Autowired
    private ClienteService clienteService;

    public LivroCaixa incluir(CadastrarLivroRequest cadastrarLivroRequest) {


        LivroCaixa clienteEncontrado = buscarLivroId(cadastrarLivroRequest.getIdcliente());

        LivroCaixa livroCaixa = new LivroCaixa();
        //livroCaixa.setCliente(clienteEncontrado);
        livroCaixa.setDataLancamento(cadastrarLivroRequest.getDataLancamento());
        livroCaixa.setDescricao(cadastrarLivroRequest.getDescricao());
        livroCaixa.setTipoLacamentoCaixa(cadastrarLivroRequest.getTipoLacamentoCaixa());
        livroCaixa.setValor(cadastrarLivroRequest.getValor());

        if (clienteEncontrado != null) {
            livroCaixaRepository.save(livroCaixa);
        } else {
            throw new ObjetoNaoEncontradoException("Id não encontrado.");
        }

        return livroCaixa;

    }

    public LivroCaixa alterarDados(Long id, AlterarDadosLivroRequest alterarDadosLivroRequest) {

        LivroCaixa livroCaixa = buscarLivroId(id);

        if (livroCaixaRepository.existsById(id)) {
            livroCaixa.setDescricao(alterarDadosLivroRequest.getDescricao());
            livroCaixa.setTipoLacamentoCaixa(alterarDadosLivroRequest.getTipoLacamentoCaixa());
            livroCaixa.setValor(alterarDadosLivroRequest.getValor());

            livroCaixaRepository.save(livroCaixa);

        } else {

            throw new ObjetoNaoEncontradoException("Id não encontrado.");

        }

        return livroCaixa;

    }

    public void excluirRegistro(Long id) {

        LivroCaixa livroCaixa = buscarLivroId(id);

        if (livroCaixa == null){
            throw new ObjetoNaoEncontradoException("Id não encontrado.");
        }

        livroCaixaRepository.delete(livroCaixa);

    }

    public LivroCaixa buscarLivroId(Long id) {

        return livroCaixaRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Id não encontrado."));

    }

    public Page<LivroCaixa> listarLivroCaixaIdCliente(Long idCliente, Pageable pageable) {

        return livroCaixaRepository.findAllByClienteId(idCliente, pageable);

    }


}