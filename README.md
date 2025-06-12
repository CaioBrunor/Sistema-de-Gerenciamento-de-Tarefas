## 📝 ByteTasks – Sistema de Gerenciamento de Tarefas
**ByteTasks é um sistema simples de gerenciamento de tarefas desenvolvido em Java, com foco no controle de atividades pessoais ou profissionais. Ele permite criar, listar, atualizar, excluir e organizar tarefas com ou sem prazos, acompanhando o progresso por meio de status.**

---

## ⚙️ Funcionalidades
  
- 📋 *Listar tarefas: (Todas/Apenas pendentes/Em andamento/Finalizadas)*
   
- ✅ *Adicionar tarefas simples ou com prazo*
  
- 🔍 *Pesquisar tarefas por título*

- 🖊️ *Atualizar título, status ou descrição da tarefa*

- 🗑️ *Excluir tarefa pelo título*

- ⏳ *Verificar e destacar tarefas atrasadas automaticamente*

- 👤 *Cadastro de usuário responsável por cada tarefa*

---

## 🧱 Estrutura do Projeto

***├── Main.java***
**Arquivo com todos os métodos e o menu**

***├── Tarefas.java***
**Arquivo com a classe "Tarefa"**

***├── TarefaSimples.java***
**Arquivo com a classe "TarefaSimples" que herda atributos e métodos da classe Tarefas**

***├── TarefaComPrazo.java***
**Arquivo com a classe "TarefaComPrazo" que herda atributos e métodos da classe Tarefas**

***├── Usuario.java***
**Arquivo com a classe "Usuario"**

***├── Status.java (enum)***
**Arquivo com o enum "Status**

---
## ▶️ Como executar

 **1.** *Clone este repositório ou copie os arquivos para uma pasta local.*

 **2.** *Certifique-se de clonar todas os arquivos: Main, Tarefas, TarefasSimples, TarefasComPrazo, Usuario, Status.*

 **3.** *Lembre de rodar os arquivos na linguagem Java*

---

## 🔒 Validações Implementadas

- *Verificação de campos obrigatórios (título, descrição, usuário, e-mail)*

- *Impede alteração de status inválido*

- *Verifica e exibe aviso de tarefas atrasadas automaticamente*

- *Prevenção de ações com campos em branco*

---
## 📌 Exemplo de uso
```
Sistema de Gerenciamento de Tarefas de (Seu Nome)
System.out.println("1️⃣ - 📋 Listar Tarefas");
System.out.println("2️⃣ - ▶️ Iniciar Tarefa");
System.out.println("3️⃣ - ✅ Finalizar Tarefa");
System.out.println("4️⃣ - ➕ Adicionar Nova Tarefa");
System.out.println("5️⃣ - ❌ Excluir Tarefa Pelo Título");
System.out.println("6️⃣ - 🔍 Pesquisar Tarefa Pelo Título");
System.out.println("7️⃣ - ✏️ Atualizar Tarefa Pelo Título");
System.out.println("8️⃣ - 🚪 Sair do Sistema");
```

---
## 🧠 Observações

- **O programa contém classes que fazem a implementação de getters e setters**
- **O programa contém recursos básicos de POO, como polimorfismo, herança, encapsulamento e abstração**

---
## 👩‍💻 Desenvolvido por
- **Caio Bruno Rodrigues de Santana**
- **Curso de Sistema de Informação – UniFacisa**
- **Projeto de prática em programação orientada a objetos em Java.**

---
## 🙏 Agradecimentos

***Muito obrigado por se interessar no meu sistema de gerenciamento de tarefas, busco cada vez mais melhorar e aprender mais na área de programação, esse foi meu primeiro projeto e vou buscar cada vez mais aprender para futuramente entrar num emprego na área de programação, pois esse sempre foi meu sonho desde pequeno, agradeço pelo reconhecimento!!***
