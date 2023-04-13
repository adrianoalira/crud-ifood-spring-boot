package moderna.Ifoodbackend.service;

import lombok.AllArgsConstructor;
import moderna.Ifoodbackend.model.Cliente;
import moderna.Ifoodbackend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    public Cliente salvarCliente(Cliente cliente){
        Optional<Cliente> emailExiste = clienteRepository.findByEmail(cliente.getEmail());
        if(!emailExiste.isPresent()){
            clienteRepository.save(cliente);
        } else{
            System.out.println("EMAIL EXISTENTE");
        }
            return null;
        }

    }
