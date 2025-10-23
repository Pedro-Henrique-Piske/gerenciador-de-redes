# 🖥️ Sistema de Gerenciamento de Redes

Este é um **projeto acadêmico em Java** que simula um sistema de gerenciamento de redes e dispositivos por meio de uma interface de console.  
O objetivo principal é **aplicar e demonstrar os conceitos de Programação Orientada a Objetos (POO)** e do **padrão de arquitetura Model-View-Controller (MVC)**.

📅 **Data:** 23 Outubro de 2025  
👤 **Autores:** Pedro Henrique Piske & Lucas Stibbe

---

## 🧩 1. Propósito do Projeto (O Cenário)

O sistema foi projetado para atender às necessidades de um **administrador de TI** em um pequeno escritório.  
Ele oferece uma ferramenta simples para **gerenciar recursos de rede**, permitindo:

- Cadastrar e gerenciar **redes** (ex: *Escritório*, *Visitantes*, *Diretoria*).  
- Cadastrar e vincular **dispositivos** (notebooks, servidores, celulares) a redes.  
- Controlar o **status de conexão** de cada dispositivo (*CONECTADO*, *DESCONECTADO*, etc.).  

O programa oferece uma solução centralizada para essas tarefas, facilitando o controle e a organização da infraestrutura simulada.

---

## ⚙️ 2. Funcionalidades

O sistema possui um menu principal dividido em três áreas principais, que permitem ao usuário gerenciar todos os aspectos da rede simulada.

### 🧭 Gerenciador de Redes
- **Criar Rede:** Cadastra uma nova rede no sistema.  
- **Excluir Rede:** Remove uma rede existente.  
- **Encontrar Rede:** Verifica se uma rede existe no sistema.  
- **Listar Todas as Redes:** Exibe todas as redes cadastradas.

### 🌐 Funções de Rede
- **Adicionar Dispositivo:** Cria e aloca um novo dispositivo em uma rede.  
- **Remover Dispositivo:** Desvincula um dispositivo de uma rede.  
- **Listar Dispositivos:** Exibe todos os dispositivos pertencentes a uma rede.

### 💻 Funções de Dispositivos
- **Conectar / Desconectar:** Altera o status de conexão de um dispositivo.  
- **Exibir Informações:** Busca um dispositivo pelo nome e exibe detalhes como **Nome**, **IP** e **Status**.

---

## 🧱 3. Arquitetura e Tecnologias

O projeto segue as boas práticas de **organização e separação de responsabilidades** do padrão **MVC**.

| Camada | Descrição | Classes |
|:--|:--|:--|
| **Model** | Contém a lógica de negócio e as estruturas de dados. | `Dispositivo`, `Rede`, `GerenciadorDeRedes`, `StatusDispositivo` |
| **Controller** | Faz a mediação entre a View e o Model. | `GerenciadorController` |
| **View** | Interage com o usuário via console. | `Main` |

**Tecnologias utilizadas:**
- Linguagem: **Java SE (JDK 8+)**
- IDE recomendada: **Apache NetBeans** (ou Eclipse / IntelliJ)
- Arquitetura: **Model-View-Controller (MVC)**

---

## 🧩 4. Diagrama de Classes UML

O diagrama de classes do *Model* representa as relações de **Agregação** entre os principais componentes do sistema:

GerenciadorDeRedes
└── possui uma ou muitas Redes
└── possui um ou muitos Dispositivos


📘 Relações:
- Um **GerenciadorDeRedes** contém várias **Redes**.  
- Uma **Rede** contém vários **Dispositivos**.  
- A relação é do tipo *tem-um* (agregação).

---

## 📂 5. Estrutura de Pacotes

- Sistema_de_Redes/src/
- **1.** controller/
- **1.1.** GerenciadorController.java
- **2.** model/
- **2.1** Dispositivo.java
- **2.2** GerenciadorDeRedes.java
- **2.3** -Rede.java
- **2.4** -StatusDispositivo.java
- **3.** view/
- **3.1.** -Main.java


---

## 🚀 6. Como Executar o Projeto

### 🔧 Pré-requisitos
- **Java Development Kit (JDK)** 8 ou superior.  
- **Apache NetBeans IDE** (ou outra IDE compatível com Java).  

### 🪜 Passos para execução
1. **Clone ou baixe** este repositório.  
2. **Abra o NetBeans** e vá em:  
   `Arquivo > Abrir Projeto...`  
3. **Selecione a pasta** do projeto e confirme.  
4. Localize o arquivo `Main.java` dentro do pacote `view`.  
5. Clique com o botão direito e escolha **"Executar Arquivo"**.  
6. O **menu principal** será exibido no console.

---

## 🧠 7. Conceitos Aplicados

- Encapsulamento e Herança.
- Enumerações (`enum`) para controle de status.  
- Relacionamentos de agregação entre classes.  
- Organização modular com o padrão **MVC**.  

---

## 📜 Licença

Este projeto foi desenvolvido para fins **educacionais**.  
Sinta-se à vontade para estudar, modificar e melhorar o código.
