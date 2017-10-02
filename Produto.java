public class Produto {
    private String nomeProduto,tipo;
    private float valor;
    private short qtd=0;
    private float Gd, Ge, Gp;

    public Produto(){}


    public Produto (String nomeProduto,String tipo,float valor,short qtd){
        this.nomeProduto=nomeProduto;
        this.qtd=qtd;
        this.tipo=tipo;
        this.valor=valor;
    }

    public short getQtd(){
        return qtd;
    }

    public void setQtd(short qtd){
        this.qtd=qtd;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) { this.valor = valor; }

    public float  getGd(){ return Gd;}
    public void  setGd(float Gd){ this.Gd = Gd;}
    public float  getGe(){ return Ge;}
    public void  setGe(float Ge){ this.Gd = Ge;}
    public float  getGp(){ return Gp;}
    public void  setGp(float Gp){ this.Gd = Gp;}
}
