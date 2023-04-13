package moderna.Ifoodbackend.controller;

import lombok.AllArgsConstructor;
import moderna.Ifoodbackend.model.Cliente;
import moderna.Ifoodbackend.repository.ClienteRepository;
import moderna.Ifoodbackend.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @GetMapping("/exibe-texto")
    public String texto2() {

        return "Seja Bem-vindo ao serviço de cliente do IfoodModerna!";
    }

    @GetMapping("/exibir-cliente")
    public Cliente retornaCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Adriano");
        cliente.setEndereco("Rua Santa Cruz do Capibaribe, 303");
        cliente.setEmail("adrianolira@gmail.com");
        return cliente;
    }

    @PostMapping("/salvar-cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);

    }

    @GetMapping("/listar-clientes")
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("/buscar-cliente/{id}")
    // Metodo do JPA para buscar um cliente por id.
    public Optional<Cliente> buscarClientePorId(@PathVariable("id") Long id) {
        //Options serve para tratar erro no banco de dados quando a solicitação não existe no banco de dados
        return clienteRepository.findById(id);
    }

    @DeleteMapping("/deletar/{id}")
    public Optional<Cliente> deleteRegistroPorId(@PathVariable("id") Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()) {
            System.out.println("Id não consta na base de dados.");
            return Optional.empty();
        }
        clienteRepository.deleteById(id);
        if (clienteRepository.existsById(id)) {
            System.out.println("Erro ao excluir cliente com id " + id);
            return Optional.empty();
        }
        return cliente;
    }


    }

