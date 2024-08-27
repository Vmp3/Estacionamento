package projeto.estacionamento.DTO;

public class FabricanteDTO {
    private Long id;
    private String nome;
    private String pais;
    private StatusDTO status;

    // Construtores
    public FabricanteDTO() {
    }

    public FabricanteDTO(Long id, String nome, String pais, StatusDTO status) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }
}
