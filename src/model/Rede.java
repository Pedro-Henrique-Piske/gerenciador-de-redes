package model;

import java.util.ArrayList;
import java.util.List;

public class Rede {
    private String nome;
    private List<Dispositivo> dispositivosConectados;
    
    public Rede(String nome) {
        this.nome = nome;
        this.dispositivosConectados = new ArrayList<>();
    }
    
    public void adicionarDispositivo(Dispositivo dispositivo) {
        this.dispositivosConectados.add(dispositivo);
        dispositivo.conectar(); 
    }
    
    public void removerDispositivo(Dispositivo dispositivo) {
        this.dispositivosConectados.remove(dispositivo);
        dispositivo.desconectar();
    }
    
    public void listarDispositivos() {
        System.out.println("\n--- Dispositivos na Rede: " + this.nome + " ---");
        if (this.dispositivosConectados.isEmpty()) {
            System.out.println("Nenhum dispositivo conectado a esta rede.");
        } else {
            for (Dispositivo disp : this.dispositivosConectados) {
                System.out.println(disp.toString()); 
            }
        }
        System.out.println("----------------------------------------");
    }

    // --- GETTERS E SETTERS ---
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Dispositivo> getDispositivosConectados() {
        return dispositivosConectados;
    }
}