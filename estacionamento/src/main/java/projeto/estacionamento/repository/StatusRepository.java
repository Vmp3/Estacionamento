package projeto.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.estacionamento.entities.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
