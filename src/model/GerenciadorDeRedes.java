package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRedes {
    
    private List<Rede> listaDeRedes;

    public GerenciadorDeRedes() {
        this.listaDeRedes = new ArrayList<>();
    }

    public Rede encontrarRede(String nome) {
        for (Rede rede : listaDeRedes) {
            if (rede.getNome().equalsIgnoreCase(nome)) {
                return rede;
            }
        }
        return null;
    }

    public boolean criaRede(String nome) {
        if (encontrarRede(nome) != null) {
            return false;
        }
        Rede novaRede = new Rede(nome);
        this.listaDeRedes.add(novaRede);
        return true;
    }

    public boolean excluirRede(String nome) {
        Rede redeParaExcluir = encontrarRede(nome);
        if (redeParaExcluir != null) {
            this.listaDeRedes.remove(redeParaExcluir);
            return true;
        }
        return false;
    }
    
    public void listarTodasRedes() {
        System.out.println("\n=== LISTA DE TODAS AS REDES ===");
        if (this.listaDeRedes.isEmpty()) {
            System.out.println("Nenhuma rede cadastrada no sistema.");
        } else {
            for (Rede rede : this.listaDeRedes) {
                System.out.println("- " + rede.getNome());
            }
        }
        System.out.println("===============================");
    }
    
    public List<Rede> getListaDeRedes() {
        return this.listaDeRedes;
    }
}