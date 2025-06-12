public class TarefaSimples extends Tarefas {

    public TarefaSimples(String titulo, String descricao, Status status, Usuario usuarioResponsavel) {
        super(titulo, descricao, status, usuarioResponsavel);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("📌 Tarefas Simples");
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
        usuarioResponsavel.exibirUsuario();
        System.out.println("-".repeat(40));
    }
}
