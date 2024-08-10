package app.services;

import app.entities.ClienteEntity;
import app.entities.EnderecoEntity;
import app.entities.FuncionarioEntity;
import app.repositories.ClienteRepository;
import app.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public String save(ClienteEntity clienteEntity){
        this.clienteRepository.save(clienteEntity);
        return "Cliente Salvo";
    }

    public String update(ClienteEntity clienteEntity, long id){
        clienteEntity.setId(id);
        this.clienteRepository.save(clienteEntity);
        EnderecoEntity endereco = clienteEntity.getEndereco();
        enderecoService.save(endereco);
        return "Cliente foi alterado";
    }

    public String delete(long id){
        ClienteEntity clienteEntity = this.clienteRepository.findById(id).orElse(null);
        EnderecoEntity endereco = clienteEntity.getEndereco();
        clienteEntity.setEndereco(null);
        this.clienteRepository.save(clienteEntity);
        this.enderecoRepository.delete(endereco);
        this.clienteRepository.deleteById(id);
        return "Excluído com sucesso";
    }

    public List<ClienteEntity> findAll(){
        List<ClienteEntity> lista = this.clienteRepository.findAll();
        return lista;
    }

    public ClienteEntity findById(long id){
        return this.clienteRepository.findById(id).get();
    }

    public List<ClienteEntity> listarClientesPorIdade(int idadeInicio, int idadeFim){
        return this.clienteRepository.findByIdadeBetween(idadeInicio, idadeFim);
    }
}
