package io.github.spring.controller;

import io.github.entity.Cliente;
import io.github.repository.ClienteRepository;
import io.github.spring.controller.adapter.ClienteControllerAdapter;
import io.github.spring.controller.dto.Request.ClienteRequest;
import io.github.spring.controller.dto.Response.ClienteResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ClienteResponse criar(@RequestBody  ClienteRequest request) {

        Cliente cliente = ClienteControllerAdapter.castRequest(request);
        Cliente salvo = clienteRepository.salvar(cliente);

        return ClienteControllerAdapter.castResponse(salvo);
    }

    @GetMapping("/{id}")
    public ClienteResponse buscarPorId(@PathVariable String id) {

        Optional<Cliente> cliente = clienteRepository.buscarPorId(id);

        return ClienteControllerAdapter.castResponse(
                cliente.orElseThrow(() -> new RuntimeException("Cliente não encontrado"))
        );
    }

    @GetMapping
    public List<ClienteResponse> listar() {

        return clienteRepository.listar()
                .stream()
                .map(ClienteControllerAdapter::castResponse)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        clienteRepository.deletar(id);
    }

    @PutMapping("/{id}")
    public ClienteResponse atualizar(@PathVariable String id, @RequestBody  ClienteRequest request) {

        Cliente cliente = ClienteControllerAdapter.castRequestWithId(id, request);


        Cliente atualizado = clienteRepository.salvar(cliente);

        return ClienteControllerAdapter.castResponse(atualizado);
    }
}
