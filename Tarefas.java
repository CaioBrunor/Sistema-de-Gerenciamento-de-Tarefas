public abstract class Tarefas {
    protected String titulo;
    protected String descricao;
    protected Status status;
    protected Usuario usuarioResponsavel;

    public Tarefas(String titulo, String descricao, Status status, Usuario usuarioResponsavel){
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.usuarioResponsavel = usuarioResponsavel;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public Usuario getUsuarioResponsavel(){
        return usuarioResponsavel;
    }
    public void setUsuarioResponsavel(Usuario usuarioResponsavel){
        this.usuarioResponsavel = usuarioResponsavel;
    }
    public void exibirDetalhes() {
    }

}
