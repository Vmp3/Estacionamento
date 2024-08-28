package projeto.estacionamento.DTO;

public class ModeloDTO {
    private Long id;
    private String nome;
    private FabricanteDTO fabricante;
    private TipoDTO tipo;

    // Construtores
    public ModeloDTO() {
    }

    public ModeloDTO(Long id, String nome, FabricanteDTO fabricante, TipoDTO tipo) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.tipo = tipo;
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

    public FabricanteDTO getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteDTO fabricante) {
        this.fabricante = fabricante;
    }

    public TipoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoDTO tipo) {
        this.tipo = tipo;
    }
}
