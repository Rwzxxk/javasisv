import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuService {
    static Scanner sc = new Scanner(System.in);
    static List<Veiculo> lista_veiculos = new ArrayList<>();

    //méttodo que lista veículos cadastrados
    public void verLista(){
        if(lista_veiculos.isEmpty()){
            System.out.println("Lista vazia");
        }else{
        lista_veiculos.forEach(System.out::println);}
        pausar();
    }

    //méttodo que cadastra os veículos no sistema|\\
    public void adicionaVeiculo() {
        System.out.println("Digite a marca do veiculo: ");
        String marca = sc.nextLine();
        //mettodo; Verifica se o usuário inseriu algum dado\\
        if (marca.isEmpty()) {
            throw new IllegalArgumentException("Marca Inválida");
        }
        System.out.println("Digite o modelo do veiculo: ");
        String modelo = sc.nextLine();
        if (modelo.isEmpty()) {
            throw new IllegalArgumentException("modelo do veículo é inválido");
        }
        System.out.println("Digite a cor do veiculo: ");
        String cor = sc.nextLine();
        if (cor.isEmpty()) {
            throw new IllegalArgumentException("Cor inserrida erroneamente");
        }
        System.out.println("Digite a placa do veiculo: ");
        String placa = sc.nextLine();
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("Placa Invàlida");
        }

        Veiculo novo_veiculo = new Veiculo(marca, modelo, cor, placa);

        //mettodo que verifica se a placa recém adicionada já pertence a um veículo do sistema\\
        for (Veiculo veiculo : lista_veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Erro: Já existe um carro com essa placa no estacionamento.");
                pausar();
                return;

            }

        }
        lista_veiculos.add(novo_veiculo);
        System.out.println("Veiculo adicionado com sucesso!");
        // Pausa para o usuário confirmar
        pausar();
    }

    //mettodo que remove veículo do sistema\\
    public void removeVeiculo() {
        System.out.println("Digite o placa do veiculo que saiu: ");
        String placa = sc.nextLine();
        //metodo que verifica se o usuário entrou com algum dado\\
        if (placa == null || placa.isBlank()) {
            System.out.println("Por favor digite uma placa válida");
            pausar();
            return;
        }
        boolean removido = lista_veiculos.removeIf(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa));
        if (removido) {
            System.out.println("Veiculo removido com sucesso!");
        } else {
            System.out.println("Veiculo nao encontrado!");
        }
        pausar();
    }
    //mettodo que encontra o veículo pela placa\\
    public void encontrarVeiculo() {
        System.out.print("Digite a placa do veículo: ");
        String placa = sc.nextLine();

        for (Veiculo v : lista_veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Veículo encontrado:");
                System.out.println(v);
                pausar();
                return; // encerra o méttodo ao encontrar
            }
        }//caso não encontre nenhum veiculo
        System.out.println("Veículo não encontrado.");
        pausar();
    }

    // Méttodo utilitário que pausa a execução até o usuário pressionar ENTER
    public void pausar() {
        pausar("Pressione ENTER para continuar...");
    }

    // Sobrecarga que aceita uma mensagem personalizada
    public void pausar(String mensagem) {
        System.out.println(mensagem);
        // Aguarda o usuário pressionar ENTER
        sc.nextLine();
    }
}
