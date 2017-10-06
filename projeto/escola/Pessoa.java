package projeto.escola;

public class Pessoa {
    private String nome,ocupacao;
    private int idade;
    private long codigo;
    public Pessoa (String nome, int idade, long codigo, String ocupacao){
        this.nome=nome;
        this.idade = idade;
        this.codigo = codigo;
        this.ocupacao = ocupacao;
    }
    public Pessoa(){}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getOcupacao() {return ocupacao; }

    public void setOcupacao(String ocupacao) {this.ocupacao = ocupacao;}

    public int getIdade(){ return idade; }

    public void setIdade(int idade){ this.idade = idade;}

    public long getCodigo(){ return codigo; }

    public void setCodigo(int codigo){ this.codigo = codigo;}
}