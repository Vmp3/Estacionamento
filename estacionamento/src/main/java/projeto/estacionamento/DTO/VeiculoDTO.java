package projeto.estacionamento.DTO;

public class VeiculoDTO {
    private Long id;
    private String placa;
    private String cor;
    private ModeloDTO modelo;

    // Construtores
    public VeiculoDTO() {
    }

    public VeiculoDTO(Long id, String placa, String cor, ModeloDTO modelo) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public ModeloDTO getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDTO modelo) {
        this.modelo = modelo;
    }
}
