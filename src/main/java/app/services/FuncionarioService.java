package app.services;

import app.entities.EnderecoEntity;
import app.entities.FuncionarioEntity;
import app.repositories.EnderecoRepository;
import app.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public String save(FuncionarioEntity funcionarioEntity){
        this.funcionarioRepository.save(funcionarioEntity);
        return "Funcionario Salvo";
    }

    public String update(FuncionarioEntity funcionarioEntity, long id){
        funcionarioEntity.setId(id);
        this.funcionarioRepository.save(funcionarioEntity);
        return "Funcionario Atualizado";
    }

    public String delete(long id){
        FuncionarioEntity funcionario = this.funcionarioRepository.findById(id).orElse(null);
        EnderecoEntity endereco = funcionario.getEndereco();
        funcionario.setEndereco(null);
        this.funcionarioRepository.save(funcionario);
        this.enderecoRepository.delete(endereco);
        this.funcionarioRepository.deleteById(id);
        return "Excluído com sucesso";
    }

    public List<FuncionarioEntity> findAll(){
        List<FuncionarioEntity> lista = this.funcionarioRepository.findAll();
        return lista;
    }

    public FuncionarioEntity findById(long id){
        return this.funcionarioRepository.findById(id).get();
    }
}
