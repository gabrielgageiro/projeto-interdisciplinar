import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Escola {
    private int qtdAluno,qtdProfessor;
    private float verba=0;
    private String nomeDaEscola;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    public Escola(){

    }

    public void cadastrarMateriais()throws InputMismatchException {

        try {
            Scanner l= new Scanner(System.in);
            l.useLocale(Locale.ENGLISH);
            System.out.print("Nome do item: ");
            String nome = l.nextLine();
            System.out.print("Tipo (Escritorio,Didatico, etc)):");
            String tipo=l.nextLine();
            System.out.print("Quantidade adquirida: ");
            short qt=l.nextShort();
            System.out.print("Valor unitario (Ex.: 15.75): ");
            float vlr=l.nextFloat();
            produtos.add(new Produto(nome,tipo,vlr,qt));
        }catch (InputMismatchException e){
            System.err.println("ENTRADA INCOMPATIVEL! VERIFIQUE SE INFORMOU OS VALORSE NOS CAMPOS CORRETOS");
        }
    }

    public void debitarGasto(float valor,String produto){
        for(int i=0;i<produtos.size();i++){
            if(produtos.get(i).getNomeProduto().contains(produto)){
                verba-=valor;
                produtos.get(i).setQtd((short) (produtos.get(i).getQtd()-1));
            }
            else {

                System.out.println("Item não cadastrado. Por favor, cadastre.");
                cadastrarMateriais();
                break;
            }
        }
    }

    public float getVerba() {
        return verba;
    }

    public void setVerba(float verba) {
        this.verba = verba;
    }

    public void mostrarMateriais(){
        System.out.println("TODOS OS MATERIAIS ABAIXO:");
        for (Produto pro:produtos) {
            System.out.println(pro.getNomeProduto() + " "+pro.getQtd()+" "+pro.getValor());
        }
    }
}

