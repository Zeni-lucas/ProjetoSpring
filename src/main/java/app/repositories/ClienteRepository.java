package app.repositories;

import app.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    List<ClienteEntity> findByIdadeBetween(int idadeInicio, int IdadeFim);
}
