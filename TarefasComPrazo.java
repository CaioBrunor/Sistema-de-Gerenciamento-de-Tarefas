import java.time.LocalDate;

public class TarefaComPrazo extends Tarefas{
    public LocalDate prazo;

    public TarefaComPrazo(String titulo, String descricao, Status status, Usuario usuarioResponsavel, LocalDate prazo) {
        super(titulo, descricao, status, usuarioResponsavel);
        this.prazo = prazo;
    }
    public LocalDate getPrazo(){
        return prazo;
    }
    public void setPrazo(LocalDate prazo){
        this.prazo = prazo;
    }
    public boolean tarefaAtrasada() {
        return getStatus() != Status.FINALIZADA && LocalDate.now().isAfter(prazo);
    }
    public void exibirDetalhes() {
        System.out.println("⏳ Tarefa com Prazo");
        System.out.println("Título: " + titulo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
        System.out.println("Prazo: " + prazo);
        usuarioResponsavel.exibirUsuario();
        System.out.println("-".repeat(40));
        if (tarefaAtrasada()) {
            System.out.println("⚠️ ATENÇÃO: Esta tarefa está atrasada!");
        }
    }
}
