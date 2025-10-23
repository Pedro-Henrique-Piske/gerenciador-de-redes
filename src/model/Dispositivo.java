package model;

public class Dispositivo {
    
    private String nome;
    private String enderecoIP;
    private StatusDispositivo status;
    
    public Dispositivo(String nome, String enderecoIP) {
        this.nome = nome;
        this.enderecoIP = enderecoIP;
        this.status = StatusDispositivo.DESCONECTADO;
    }
    
    public void conectar() {
        this.status = StatusDispositivo.CONECTADO;
    }
    
    public void desconectar() {
        this.status = StatusDispositivo.DESCONECTADO;
    }
    
    public void exibirInfo() {
        System.out.println("--- Informações do Dispositivo ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Endereço IP: " + this.enderecoIP);
        System.out.println("Status: " + this.status);
        System.out.println("----------------------------------");
    }
    
    @Override
    public String toString() {
        return "Dispositivo [Nome=" + nome + ", IP=" + enderecoIP + ", Status=" + status + "]";
    }

    // --- GETTERS E SETTERS ---
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoIP() {
        return enderecoIP;
    }

    public void setEnderecoIP(String enderecoIP) {
        this.enderecoIP = enderecoIP;
    }

    public StatusDispositivo getStatus() {
        return status;
    }
}