package projeto.estacionamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projeto.estacionamento.entities.Status;
import projeto.estacionamento.repository.StatusRepository;

@SpringBootApplication
public class EstacionamentoApplication implements CommandLineRunner {

    @Autowired
    private StatusRepository statusRepository;

    public static void main(String[] args) {
        SpringApplication.run(EstacionamentoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (!statusRepository.existsById(1L)) {

            Status statusAtivo = new Status();
            statusAtivo.setId(1L);
            statusAtivo.setNomeStatus("Ativo");
            statusRepository.save(statusAtivo);
            System.out.println("Status 'Ativo' criado com ID 1.");
        } else {
            System.out.println("Status com ID 1 já existe.");
        }
    }
}
