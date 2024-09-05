package projeto.estacionamento.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projeto.estacionamento.entities.Modelo;

@SuppressWarnings("unused")
@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByFabricantePais(String pais);

     @Query("SELECT m FROM Modelo m JOIN m.fabricante f WHERE f.pais = :pais")
     List<Modelo> findModelosByFabricantePais(@Param("pais") String pais);
 
    
    // @Query(value = "CALL modelo_fabricante(:pais)", nativeQuery = true)
    // List<Modelo> findModelosByFabricantePais(@Param("pais") String pais);
}

