import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        boolean rodando = true;
        while (rodando) {
            System.out.println("-------------------------------------------------------");
            System.out.println("-----------SISTEMAS DE REGISTROS DE VEÍCULOS-----------");
            System.out.println("-------------------------------------------------------");
            System.out.println("Digite a opção desejada:");
            System.out.println("1-Cadastrar Veículo");
            System.out.println("2-listar veículos");
            System.out.println("3-Encontrar Veículo");
            System.out.println("4-Remover Veículo");
            System.out.println("0-Sair do sistema.");
            int opcao = sc.nextInt();
            sc.nextLine(); //limpeza de buffer

            switch (opcao) {
                case 1:
                    menuService.adicionaVeiculo();
                    break;

                case 2:
                    menuService.verLista();
                    break;

                case 3:
                    menuService.encontrarVeiculo();
                    break;

                case 4:
                    menuService.removeVeiculo();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    rodando = false;
                    break;
            }


        }


    }
}
