package com.viacep.integration.controller;

import com.viacep.integration.dto.ClienteDTO;
import com.viacep.integration.entity.Cliente;
import com.viacep.integration.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> listar () {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscar (@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar (@RequestBody ClienteDTO cliente) {
        clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteDTO> atualizar (@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover (@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
