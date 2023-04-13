package moderna.Ifoodbackend.repository;


import moderna.Ifoodbackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByEmail(String email);

}
