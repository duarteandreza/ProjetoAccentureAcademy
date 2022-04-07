package br.com.duarteandreza.projetoaccenture.accentureacademy.services;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Usuario;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.ObjetoJaExisteException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.ObjetoNaoEncontradoException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.repositories.ClientesRepository;
import br.com.duarteandreza.projetoaccenture.accentureacademy.requests.AlterarDadosClientesRequest;
import br.com.duarteandreza.projetoaccenture.accentureacademy.specification.ClienteSpecification;
import br.com.duarteandreza.projetoaccenture.accentureacademy.specification.UsuarioSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;


    public Clientes incluir(Clientes cliente) {

        boolean cpfCnpjJaCadastrado = clientesRepository.existsByCpfCnpj(cliente.getCpfCnpj());

        if(cpfCnpjJaCadastrado) {
            throw new ObjetoJaExisteException("CPF/CNPJ já existe.");
        }

        boolean emailJaCadastrado = clientesRepository.existsByEmail(cliente.getEmail());

        if(emailJaCadastrado) {
            throw new ObjetoJaExisteException("E-mail já existe.");
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
                    throw new ObjetoJaExisteException("E-mail já existe.");
                } else {
                    clientes.setEmail(alterarDadosClientesRequest.getEmail());
                }
            }

            clientesRepository.save(clientes);

        } else {

            throw new ObjetoNaoEncontradoException("Id não encontrado.");

        }

        return clientesRepository.save(clientes);

    }

    public void excluirCliente(Long id) {

        Clientes clientes = buscarClienteId(id);

        if (clientes == null){
            throw new ObjetoNaoEncontradoException("Id não encontrado.");
        }

        clientesRepository.delete(clientes);

    }

    public Clientes buscarClienteId(Long id) {

        return clientesRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Id não encontrado."));

    }

    public List<Clientes> listarPorNomeCpfCnpjCidadeUf(String nome, String cpfCnpj, String cidade, String uf) {

        var specification = ClienteSpecification.consultarPorNomeCpfCnpjCidadeUf(nome, cpfCnpj, cidade, uf);

        return (List<Clientes>) clientesRepository.findAll((Pageable) specification);

    }
}
