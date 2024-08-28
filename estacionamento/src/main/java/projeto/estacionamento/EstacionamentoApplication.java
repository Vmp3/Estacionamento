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
        // Verifica se o status com ID 1 já existe
        if (!statusRepository.existsById(1L)) {
            // Se não existir, cria o status "Ativo" com ID 1
            Status statusAtivo = new Status();
            statusAtivo.setId(1L); // Define o ID como 1
            statusAtivo.setNomeStatus("Ativo");
            statusRepository.save(statusAtivo);
            System.out.println("Status 'Ativo' criado com ID 1.");
        } else {
            System.out.println("Status com ID 1 já existe.");
        }
    }
}
