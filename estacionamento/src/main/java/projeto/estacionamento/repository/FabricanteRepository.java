package projeto.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.estacionamento.entities.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
    List<Fabricante> findByPais(String pais);

    List<Fabricante> findByPaisContaining(String pais);
}
