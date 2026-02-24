import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MenuService {
    static Scanner sc = new Scanner(System.in);
    static List<Veiculo> lista_veiculos = new ArrayList<>();

    //método que cadastra os veículos no sistema|\\
    public static void adicionaVeiculo() {
        System.out.println("Digite a marca do veiculo: ");
        String marca = sc.nextLine();
        //todo; Verifica se o usuário inseriu algum dado\\
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

        //todo; Verifica se a placa recém adicionada já pertence a um veículo do sistema\\
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

    //todo; Método que remove veículo do sistema\\
    public static void removeVeiculo() {
        System.out.println("Digite o placa do veiculo que saiu: ");
        String placa = sc.nextLine();
        //todo; Verifica se o usuário entrou com algum dado\\
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

    //todo; Método que lista os veìculos que foram adicionados\\
    public static void listarVeiculos() {
        if (lista_veiculos.isEmpty()) {
            System.out.println("Ainda não foi adicionado nenhum carro");
            pausar();
            return;
        }
        System.out.println("--------Veículos Atuais--------");
        for (Veiculo veiculo : lista_veiculos) {
            System.out.println(
                    "Marca: " + veiculo.getMarca() + ", " +
                            "Modelo: " + veiculo.getModelo() + ", " +
                            "Cor: " + veiculo.getCor() + ", " +
                            "Placa:  " + veiculo.getPlaca()
            );
        }
        pausar();
    }

    //todo; método que encontra o veículo pela placa\\
    public static void encontrarVeiculo() {
        System.out.print("Digite a placa do veículo: ");
        String placa = sc.nextLine();

        for (Veiculo v : lista_veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Veículo encontrado:");
                System.out.println(v);
                pausar();
                return; // encerra o método ao encontrar
            }
        }//todo; Se não encontrou nenhum
        System.out.println("Veículo não encontrado.");
        pausar();
    }

    // Método utilitário que pausa a execução até o usuário pressionar ENTER
    public static void pausar() {
        pausar("Pressione ENTER para continuar...");
    }

    // Sobrecarga que aceita uma mensagem personalizada
    public static void pausar(String mensagem) {
        System.out.println(mensagem);
        // Aguarda o usuário pressionar ENTER
        sc.nextLine();
    }
}
