package br.com.apsoo.pedidos.service.exception;

import br.com.apsoo.pedidos.domain.Cliente;
import br.com.apsoo.pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.orElseThrow(() -> new ObjectNotFoundException("O Objeto com o id: " + id + " da classe " + Cliente.class.getName() + " não foi encontrado!"));
    }
}
