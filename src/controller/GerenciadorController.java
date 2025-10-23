package controller;

import java.util.List;
import java.util.Scanner;
import model.GerenciadorDeRedes;
import model.Dispositivo;
import model.Rede;

public class GerenciadorController {

    private final GerenciadorDeRedes gerenciador;
    private final Scanner scanner;

    public GerenciadorController() {
        this.gerenciador = new GerenciadorDeRedes();
        this.scanner = new Scanner(System.in);
        this.gerenciador.criaRede("Escritorio");
        this.gerenciador.criaRede("Visitantes");
    }

    
    public void criaRede() {
        System.out.print("-> Digite o nome da nova rede: ");
        String nomeRede = scanner.nextLine();
        if (gerenciador.criaRede(nomeRede)) {
            System.out.println("SUCESSO: Rede '" + nomeRede + "' criada!");
        } else {
            System.out.println("ERRO: Uma rede com o nome '" + nomeRede + "' já existe.");
        }
    }
    
    public void excluirRede() {
        System.out.print("-> Digite o nome da rede a ser excluída: ");
        String nomeRede = scanner.nextLine();
        if (gerenciador.excluirRede(nomeRede)) {
            System.out.println("SUCESSO: Rede '" + nomeRede + "' foi excluída.");
        } else {
            System.out.println("ERRO: Rede não encontrada.");
        }
    }
    
    public void encontrarRede() {
        System.out.print("-> Digite o nome da rede a ser encontrada: ");
        String nomeRede = scanner.nextLine();
        if (gerenciador.encontrarRede(nomeRede) != null) {
            System.out.println("INFO: A rede '" + nomeRede + "' existe no sistema.");
        } else {
            System.out.println("INFO: A rede '" + nomeRede + "' NÃO foi encontrada.");
        }
    }
    
    public void listarTodasRedes() {
        gerenciador.listarTodasRedes();
    }


    public void adicionarDispositivoEmRede() {
        System.out.print("-> Digite o nome da rede para adicionar o dispositivo: ");
        String nomeRede = scanner.nextLine();
        
        Rede redeAlvo = gerenciador.encontrarRede(nomeRede);
        if (redeAlvo != null) {
            System.out.print("-> Digite o nome do novo dispositivo: ");
            String nomeDisp = scanner.nextLine();
            
            System.out.print("-> Digite o endereço IP do dispositivo (ex: 192.168.0.10): ");
            String ipDisp = scanner.nextLine();
            
            Dispositivo novoDispositivo = new Dispositivo(nomeDisp, ipDisp);
            redeAlvo.adicionarDispositivo(novoDispositivo);
            System.out.println("SUCESSO: Dispositivo adicionado.");
        } else {
            System.out.println("ERRO: Rede '" + nomeRede + "' não encontrada.");
        }
    }
    
    public void removerDispositivoDeRede() {
        System.out.print("-> Digite o nome da rede: ");
        String nomeRede = scanner.nextLine();
        Rede rede = gerenciador.encontrarRede(nomeRede);

        if (rede == null) {
            System.out.println("ERRO: Rede não encontrada.");
            return;
        }

        System.out.print("-> Digite o nome do dispositivo a ser removido: ");
        String nomeDisp = scanner.nextLine();
        Dispositivo dispParaRemover = null;

        List<Dispositivo> dispositivos = rede.getDispositivosConectados();

        for (int i = 0; i < dispositivos.size(); i++) {
            Dispositivo d = dispositivos.get(i);

            if (d.getNome().equalsIgnoreCase(nomeDisp)) {
                dispParaRemover = d;
                break; 
            }
        }

        if (dispParaRemover != null) {
            rede.removerDispositivo(dispParaRemover);
            System.out.println("SUCESSO: Dispositivo removido da rede.");
        } else {
            System.out.println("ERRO: Dispositivo não encontrado nesta rede.");
        }
    }

    public void listarDispositivosDeUmaRede() {
        System.out.print("-> Digite o nome da rede para listar os dispositivos: ");
        String nomeRede = scanner.nextLine();
        
        Rede rede = gerenciador.encontrarRede(nomeRede);
        if (rede != null) {
            rede.listarDispositivos();
        } else {
            System.out.println("ERRO: Rede '" + nomeRede + "' não encontrada.");
        }
    }

    // --- MÉTODOS DE DISPOSITIVO ---

    private Dispositivo encontrarDispositivoNoSistema(String nomeDispositivo) {
        for (Rede rede : gerenciador.getListaDeRedes()) {
            for (Dispositivo disp : rede.getDispositivosConectados()) {
                if (disp.getNome().equalsIgnoreCase(nomeDispositivo)) {
                    return disp;
                }
            }
        }
        return null;
    }
    
    public void conectarDispositivo() {
        System.out.print("-> Digite o nome do dispositivo para CONECTAR: ");
        String nomeDisp = scanner.nextLine();
        Dispositivo disp = encontrarDispositivoNoSistema(nomeDisp);
        if (disp != null) {
            disp.conectar();
            System.out.println("SUCESSO: O status de '" + disp.getNome() + "' agora é " + disp.getStatus());
        } else {
            System.out.println("ERRO: Dispositivo não encontrado em nenhuma rede.");
        }
    }
    
    public void desconectarDispositivo() {
        System.out.print("-> Digite o nome do dispositivo para DESCONECTAR: ");
        String nomeDisp = scanner.nextLine();
        Dispositivo disp = encontrarDispositivoNoSistema(nomeDisp);
        if (disp != null) {
            disp.desconectar();
            System.out.println("SUCESSO: O status de '" + disp.getNome() + "' agora é " + disp.getStatus());
        } else {
            System.out.println("ERRO: Dispositivo não encontrado em nenhuma rede.");
        }
    }
    
    public void exibirInfoDeUmDispositivo() {
        System.out.print("-> Digite o nome do dispositivo que você quer exibir: ");
        String nomeDispositivo = scanner.nextLine();
        
        Dispositivo dispositivoEncontrado = encontrarDispositivoNoSistema(nomeDispositivo);
        
        if (dispositivoEncontrado != null) {
            dispositivoEncontrado.exibirInfo();
        } else {
            System.out.println("ERRO: Dispositivo '" + nomeDispositivo + "' não encontrado em nenhuma rede.");
        }
    }
}