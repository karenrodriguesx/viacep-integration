package com.viacep.integration.service.impl;

import com.viacep.integration.dto.ClienteDTO;
import com.viacep.integration.entity.Cliente;
import com.viacep.integration.entity.Endereco;
import com.viacep.integration.repository.ClienteRepository;
import com.viacep.integration.repository.EnderecoRepository;
import com.viacep.integration.service.ClienteService;
import com.viacep.integration.service.ViaCepService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Cliente não encontrado!"));
    }

    @Override
    public void salvar(ClienteDTO cliente) {
        salvarCliente(cliente);
    }

    @Override
    public void atualizar(Long id, ClienteDTO cliente) {
        Optional<Cliente> clienteSalvo = clienteRepository.findById(id);
        if (clienteSalvo.isPresent()) {
            salvarCliente(cliente);
        }
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarCliente(ClienteDTO cliente) {
        Cliente clienteSalvo = new Cliente();
        clienteSalvo.setId(cliente.getId());
        clienteSalvo.setNome(cliente.getNome());
        clienteSalvo.setCpf(cliente.getCpf());

        Endereco endereco = enderecoRepository.findById(cliente.getEnderecoId())
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.buscarCep(cliente.getCep());
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });
        clienteSalvo.setEndereco(endereco);

        clienteRepository.save(clienteSalvo);
    }
}
