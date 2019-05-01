package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
