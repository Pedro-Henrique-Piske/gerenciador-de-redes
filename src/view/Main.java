// Pacote: view
// Arquivo: Main.java

package view;

import controller.GerenciadorController;
import java.util.Scanner;

public class Main {

    // Scanner e Controller agora são estáticos para serem acessados pelos métodos de menu
    private static final Scanner scanner = new Scanner(System.in);
    private static final GerenciadorController controller = new GerenciadorController();

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Gerenciador de Redes!");
        int opcao = -1;

        while (opcao != 0) {
            exibirMenuPrincipal();
            System.out.print("Escolha uma área para gerenciar: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    menuDispositivos();
                    break;
                case 2:
                    menuRede();
                    break;
                case 3:
                    menuGerenciador();
                    break;
                case 0:
                    System.out.println("\nSaindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
                    break;
            }
        }
        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Funções de Dispositivos");
        System.out.println("2. Funções de Rede");
        System.out.println("3. Funções do Gerenciador de Redes");
        System.out.println("0. Sair");
        System.out.println("----------------------");
    }
    
    private static void menuDispositivos() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Menu: Funções de Dispositivos ---");
            System.out.println("1. Conectar Dispositivo");
            System.out.println("2. Desconectar Dispositivo");
            System.out.println("3. Exibir Informações de um Dispositivo");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("-------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1: controller.conectarDispositivo(); break;
                case 2: controller.desconectarDispositivo(); break;
                case 3: controller.exibirInfoDeUmDispositivo(); break;
                case 0: System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!"); break;
            }
            if (opcao != 0) aguardarEnter();
        }
    }
    
    private static void menuRede() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Menu: Funções de Rede ---");
            System.out.println("1. Adicionar Dispositivo a uma Rede");
            System.out.println("2. Remover Dispositivo de uma Rede");
            System.out.println("3. Listar Dispositivos de uma Rede");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("-------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1: controller.adicionarDispositivoEmRede(); break;
                case 2: controller.removerDispositivoDeRede(); break;
                case 3: controller.listarDispositivosDeUmaRede(); break;
                case 0: System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!"); break;
            }
            if (opcao != 0) aguardarEnter();
        }
    }
    
    private static void menuGerenciador() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Menu: Funções do Gerenciador ---");
            System.out.println("1. Criar Nova Rede");
            System.out.println("2. Excluir Rede");
            System.out.println("3. Encontrar Rede");
            System.out.println("4. Listar todas as Redes");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.println("-------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = lerOpcao();

            switch (opcao) {
                case 1: controller.criaRede(); break;
                case 2: controller.excluirRede(); break;
                case 3: controller.encontrarRede(); break;
                case 4: controller.listarTodasRedes(); break;
                case 0: System.out.println("Voltando..."); break;
                default: System.out.println("Opção inválida!"); break;
            }
            if (opcao != 0) aguardarEnter();
        }
    }

    // --- MÉTODOS AUXILIARES ---
    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome o "Enter"
            return opcao;
        } catch (Exception e) {
            System.out.println("ERRO: Entrada inválida. Por favor, digite um número.");
            scanner.nextLine(); // Limpa o buffer
            return -1; // Retorna um valor inválido para repetir o menu
        }
    }
    
    private static void aguardarEnter() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }
}