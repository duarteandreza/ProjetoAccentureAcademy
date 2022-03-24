package br.com.duarteandreza.projetoaccenture.accentureacademy.services;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.CpfCnpjJaCadastradoException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.EmailJaCadastradoException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.IdNaoEncontradaException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.repositories.ClientesRepository;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.AlterarDadosClientesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;


    public Clientes incluir(Clientes cliente) {

        boolean cpfCnpjJaCadastrado = clientesRepository.existsByCpfCnpj(cliente.getCpfCnpj());

        if(cpfCnpjJaCadastrado) {
            throw new CpfCnpjJaCadastradoException(cliente.getCpfCnpj());
        }

        boolean emailJaCadastrado = clientesRepository.existsByEmail(cliente.getEmail());

        if(emailJaCadastrado) {
            throw new EmailJaCadastradoException(cliente.getEmail());
        }


        return clientesRepository.save(cliente);

    }

    public Clientes alterarDados(Long id, AlterarDadosClientesRequest alterarDadosClientesRequest) {

        Clientes clientes = buscarClienteId(id);

        if (clientesRepository.existsById(id)) {
            clientes.setNome(alterarDadosClientesRequest.getNome());
            clientes.setLogradouro(alterarDadosClientesRequest.getLogradouro());
            clientes.setCidade(alterarDadosClientesRequest.getCidade());
            clientes.setUf(alterarDadosClientesRequest.getUf());
            clientes.setCep(alterarDadosClientesRequest.getCep());
            clientes.setTelefone(alterarDadosClientesRequest.getTelefone());
            if (clientes.getEmail().equals(alterarDadosClientesRequest.getEmail())) {
                clientes.getEmail();
            } else {
                if (clientesRepository.existsByEmail(alterarDadosClientesRequest.getEmail())) {
                    throw new EmailJaCadastradoException(alterarDadosClientesRequest.getEmail());
                } else {
                    clientes.setEmail(alterarDadosClientesRequest.getEmail());
                }
            }

            clientesRepository.save(clientes);

        } else {

            throw new IdNaoEncontradaException(id);

        }

        return clientesRepository.save(clientes);

    }

    public void excluirCliente(Long id) {

        Clientes clientes = buscarClienteId(id);

        if (clientes == null){
            throw new IdNaoEncontradaException(id);
        }

        clientesRepository.delete(clientes);

    }

    public Clientes buscarClienteId(Long id) {

        return clientesRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradaException(id));

    }

//    public Page<Clientes> listar(Clientes cliente, Pageable pageable) {
//    }
}
