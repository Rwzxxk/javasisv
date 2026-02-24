public class Veiculo {
    private final String marca;
    private final String modelo;
    private final String cor;
    private final String placa;
    @Override
    public String toString() {
        return "Marca: " + marca +
                ", Modelo: " + modelo +
                ", Cor: " + cor +
                ", Placa: " + placa;
    }
    public Veiculo(String marca, String modelo, String cor, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }
    public String getPlaca() {
        return placa;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getCor() {
        return cor;
    }
}
