import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Tarefas> totalTarefas = new ArrayList<>();
        int opcao;

        System.out.println("Seja bem-vindo ao nosso sistema de tarefas 'ByteTasks', fique à vontade com nosso menu e selecione sua opção:");
        do {
            System.out.println("-".repeat(7) + "Menu de Tarefas" + "-".repeat(10));
            System.out.println("1 - Listar Tarefas");
            System.out.println("2 - Iniciar Tarefa");
            System.out.println("3 - Finalizar Tarefa");
            System.out.println("4 - Adicionar Nova Tarefa");
            System.out.println("5 - Excluir Tarefa Pelo Título");
            System.out.println("6 - Pesquisar Tarefa Pelo Título");
            System.out.println("7 - Atualizar Tarefa Pelo Título");
            System.out.println("8 - Sair do Sistema");
            System.out.println("-".repeat(32));
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    //Lista de Tarefas
                    int opcaoListar;
                    do {
                        System.out.println("-".repeat(7) + "Tipos de Listas de Tarefas" + "-".repeat(10));
                        System.out.println("1 - Listar Todas as Tarefas");
                        System.out.println("2 - Listar Apenas Tarefas Pendentes");
                        System.out.println("3 - Listar Apenas Tarefas Em Andamento");
                        System.out.println("4 - Listar Apenas Tarefas Finalizadas");
                        System.out.println("5 - Voltar ao Menu Principal");
                        System.out.println("-".repeat(40));
                        opcaoListar = sc.nextInt();
                        sc.nextLine();
                        boolean encontrada = false;

                        switch (opcaoListar) {
                            case 1:
                                //Listar todas as tarefas
                                if (totalTarefas.isEmpty()) {
                                    System.out.println("A Lista de Tarefas está vazia.");
                                } else {
                                    for (Tarefas tarefa : totalTarefas) {
                                        tarefa.exibirDetalhes();
                                        encontrada = true;
                                    }
                                }
                                if (!encontrada){
                                    System.out.println("Nenhuma tarefa cadastrada.");
                                }
                                break;

                            case 2:
                                //Listar tarefas pendentes
                                for (Tarefas tarefa : totalTarefas) {
                                    if (tarefa.getStatus() == Status.PENDENTE) {
                                        tarefa.exibirDetalhes();
                                        encontrada = true;
                                    }
                                }
                                if (!encontrada) {
                                    System.out.println("Nenhuma tarefa pendente cadastrada.");
                                }
                                break;

                            case 3:
                                //Listar tarefas em andamento
                                for (Tarefas tarefa : totalTarefas) {
                                    if (tarefa.getStatus() == Status.EM_ANDAMENTO) {
                                        tarefa.exibirDetalhes();
                                        encontrada = true;
                                    }
                                }
                                if (!encontrada) {
                                    System.out.println("Nenhuma tarefa em andamento cadastrada.");
                                }
                                break;

                            case 4:
                                //Listar tarefas finalizadas
                                for (Tarefas tarefa : totalTarefas) {
                                    if (tarefa.getStatus() == Status.FINALIZADA) {
                                        tarefa.exibirDetalhes();
                                        encontrada = true;
                                    }
                                }
                                if (!encontrada) {
                                    System.out.println("Nenhuma tarefa finalizada cadastrada.");
                                }
                                break;

                            case 5:
                                //Sair do submenu
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("ERROR: Opção Inválida");
                        }

                    } while (opcaoListar != 5);
                    break;

                case 2:
                    //Iniciar Tarefa
                    System.out.println("Digite o nome da tarefa que deseja iniciar:");
                    String tarefaIniciar = sc.nextLine();
                    boolean encontradaIniciar = false;

                    if (tarefaIniciar.trim().isEmpty()) {
                        System.out.println("Inválido! O título está vazio. Retornando para o menu principal...");
                        break;
                    }
                    for (Tarefas tarefa : totalTarefas) {
                        if (tarefa.getTitulo().equalsIgnoreCase(tarefaIniciar)) {
                            encontradaIniciar = true;
                            System.out.println("Status: " + tarefa.getStatus());
                            if (tarefa.getStatus() == Status.PENDENTE) {
                                tarefa.setStatus(Status.EM_ANDAMENTO);
                                System.out.println("Tarefa iniciada com sucesso!");
                            } else {
                                System.out.println("A tarefa já está " + tarefa.getStatus() + ".");
                            }
                            break;
                        }
                    }
                    if (!encontradaIniciar) {
                        System.out.println("ERROR: Tarefa não encontrada!");
                    }
                    break;

                case 3:
                    //Finalizar Tarefa
                    System.out.println("Digite o nome da tarefa que deseja por como finalizada:");
                    String tarefaFinalizar = sc.nextLine();
                    boolean encontradaFinalizar = false;

                    if (tarefaFinalizar.trim().isEmpty()) {
                        System.out.println("Inválido! O título está vazio. Retornando para o menu principal...");
                        break;
                    }
                    for (Tarefas tarefa : totalTarefas) {
                        if (tarefa.getTitulo().equalsIgnoreCase(tarefaFinalizar)) {
                            encontradaFinalizar = true;
                            System.out.println("Status: " + tarefa.getStatus());
                            if (tarefa.getStatus() == Status.EM_ANDAMENTO) {
                                tarefa.setStatus(Status.FINALIZADA);
                                System.out.println("Tarefa finalizada com sucesso!");
                            } else if (tarefa.getStatus() == Status.PENDENTE) {
                                System.out.println("A tarefa está PENDENTE. Você precisa iniciá-la antes de finalizá-la.");
                            } else {
                                System.out.println("A tarefa já está " + tarefa.getStatus() + ".");
                            }
                            break;
                        }
                    }
                    if (!encontradaFinalizar)
                        System.out.println("ERROR: Tarefa não encontrada!");
                    break;

                case 4:
                    //Adicionar Nova Tarefa
                    System.out.println("Digite o tipo da tarefa (1 - Simples, 2 - Com Prazo):");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Insira o Título:");
                    String titulo = sc.nextLine();
                    if (titulo.trim().isEmpty()) {
                        System.out.println("Inválido! O título não foi inserido. Retornando para o menu principal...");
                        break;
                    }

                    System.out.println("Insira a Descrição:");
                    String descricao = sc.nextLine();
                        if (descricao.trim().isEmpty()) {
                            System.out.println("Inválido! A descrição não foi inserida. Retornando para o menu principal...");
                            break;
                        }

                    System.out.println("Insira o Nome do usuário responsável:");
                    String nomeUsuario = sc.nextLine();
                    if (nomeUsuario.trim().isEmpty()) {
                        System.out.println("Inválido! O nome do usuário não foi inserido. Retornando para o menu principal...");
                        break;
                    }

                    System.out.println("Insira Email do usuário responsável:");
                    String emailUsuario = sc.nextLine();
                    if (emailUsuario.trim().isEmpty()) {
                        System.out.println("Inválido! O email não foi inserido. Retornando para o menu principal...");
                        break;
                    }
                    Usuario usuario = new Usuario(nomeUsuario, emailUsuario);

                    Tarefas novaTarefa;
                    if (tipo == 2) {
                        System.out.println("Digite o prazo (yyyy-mm-dd / ano-mês-dia):");
                        String data = sc.nextLine();
                        LocalDate prazo = LocalDate.parse(data);
                        novaTarefa = new TarefaComPrazo(titulo, descricao, Status.PENDENTE, usuario, prazo);
                    } else {
                        novaTarefa = new TarefaSimples(titulo, descricao, Status.PENDENTE, usuario);
                    }
                    totalTarefas.add(novaTarefa);
                    System.out.println("Nova tarefa cadastrada com sucesso!");
                    break;

                case 5:
                    //Excluir Tarefa Pelo Título
                    System.out.println("Digite o título da tarefa que deseja excluir:");
                    String tarefasExcluidas = sc.nextLine();
                    boolean removida = false;
                    if (tarefasExcluidas.trim().isEmpty()) {
                        System.out.println("Inválido! O título está vazio. Retornando para o menu principal...");
                        break;
                    }

                    for (int i = 0; i < totalTarefas.size(); i++) {
                        if (totalTarefas.get(i).getTitulo().equalsIgnoreCase(tarefasExcluidas)) {
                            totalTarefas.remove(i);
                            removida = true;
                            System.out.println("Tarefa excluída com sucesso!");
                            break;
                        }
                    }
                    if (!removida) {
                        System.out.println("Tarefa não encontrada!");
                    }
                    break;
                case 6:
                    //Pesquisar Tarefa Pelo Título
                    System.out.println("Digite o nome da tarefa que você deseja pesquisar:");
                    String tarefaPesquisada = sc.nextLine();
                    boolean encontradaPesquisar = false;
                    if (tarefaPesquisada.trim().isEmpty()) {
                        System.out.println("Inválido! O título está vazio. Retornando para o menu principal...");
                        break;
                    }
                    for (Tarefas tarefa : totalTarefas) {
                        if (tarefa.getTitulo().equalsIgnoreCase(tarefaPesquisada)) {
                            encontradaPesquisar = true;
                            System.out.println("Tarefa encontrada com sucesso!");
                            System.out.println("Título: " + tarefa.getTitulo() + " | Status: " + tarefa.getStatus() + " | Descrição: " + tarefa.getDescricao());
                        }
                    }
                    if (!encontradaPesquisar) {
                        System.out.println("ERROR: Tarefa não encontrada");
                    }
                    break;

                case 7:
                    //Atualizar Tarefa Pelo Título
                    System.out.println("Digite o nome da tarefa que você deseja atualizar");
                    String tituloAtualizado = sc.nextLine();
                    boolean encontradaAtualizar = false;
                    if (tituloAtualizado.trim().isEmpty()) {
                        System.out.println("Inválido! O título está vazio. Retornando para o menu principal...");
                        break;
                    }

                    for (Tarefas tarefa : totalTarefas) {
                        if (tarefa.getTitulo().equalsIgnoreCase(tituloAtualizado)) {
                            encontradaAtualizar = true;
                            System.out.println("Tarefa encontrada: Título: " + tarefa.getTitulo() + " | Status: " + tarefa.getStatus() + " | Descrição: " + tarefa.getDescricao());
                            System.out.println("Digite o novo título da tarefa:");
                            String novoTitulo = sc.nextLine();
                            if (novoTitulo.trim().isEmpty()) {
                                System.out.println("Inválido! O título está vazio. Retornando para o menu principal...");
                                break;
                            } else if (!novoTitulo.isEmpty()) {
                                tarefa.setTitulo(novoTitulo);
                            }
                            System.out.println("Deseja atualizar o status para Pendente / Em andamento / Finalizada? (Deixe o campo vazio caso queira permanecer com o mesmo status/descrição)");
                            String novoStatus = sc.nextLine();
                            if (novoStatus.trim().isEmpty()) {
                                System.out.println("O status está vazio e o status continuará o mesmo junto com a descrição. Retornando para o menu principal...");
                                break;
                            }
                            String statusReescrito = novoStatus.trim().toLowerCase();
                            switch (statusReescrito) {
                                case "pendente":
                                    tarefa.setStatus(Status.PENDENTE);
                                    break;
                                case "em andamento":
                                    tarefa.setStatus(Status.EM_ANDAMENTO);
                                    break;
                                case "finalizada":
                                    tarefa.setStatus(Status.FINALIZADA);
                                    break;
                                default:
                                    System.out.println("ERROR: Status inválido! O status não foi atualizado.");
                            }
                            System.out.println("Digite a nova descrição da tarefa:");
                            String novaDescricao = sc.nextLine();

                            if (novaDescricao.trim().isEmpty()) {
                                System.out.println("A descrição está vazia e continuará a mesma. Retornando para o menu principal...");
                                break;
                            } else {
                                tarefa.setDescricao(novaDescricao);
                            }

                            System.out.println("Tarefa atualizada com sucesso!");
                            break;
                        }
                    }
                    if (!encontradaAtualizar) {
                        System.out.println("ERROR: Tarefa não encontrada!");
                    }
                    break;

                case 8:
                    //Sair do Sistema
                    System.out.println("Obrigado por utilizar nosso sistema! Saindo...");
                    break;

                default:
                    System.out.println("ERROR: Opção Inválida!");

            }

        } while (opcao != 8);
        sc.close();
    }
}


