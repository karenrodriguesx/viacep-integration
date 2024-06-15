package com.viacep.integration.service;

import com.viacep.integration.dto.ClienteDTO;
import com.viacep.integration.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {
    Iterable<Cliente> listar();

    Cliente buscarPorId(Long id);

    void salvar(ClienteDTO cliente);

    void atualizar(Long id, ClienteDTO cliente);

    void excluir(Long id);
}
