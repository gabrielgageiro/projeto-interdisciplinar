package projeto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Escola {
    private int qtdAluno, qtdProfessor;
    private float verba = 0, gastosDidatico, gastosEscritorio, gastosPedagogico;
    private String nomeDaEscola;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    public Escola() {
    }
    //impl
    public void cadastrarMateriais() throws InputMismatchException {

        try {
            Scanner l = new Scanner(System.in);
            l.useLocale(Locale.ENGLISH);
            System.out.print("Nome do item: ");
            String nome = l.nextLine();
            System.out.print("Tipo (Escritorio, Didatico, etc)):");
            String tipo = l.nextLine();
            System.out.print("Quantidade adquirida: ");
            short qt = l.nextShort();
            System.out.print("Valor unitario (Ex.: 15.75): ");
            float vlr = l.nextFloat();
            produtos.add(new Produto(nome, tipo, vlr, qt));
            calcularGastos(tipo,qt,vlr);

        } catch (InputMismatchException e) {
            System.err.println("ENTRADA INCOMPATIVEL! VERIFIQUE SE INFORMOU OS VALORSE NOS CAMPOS CORRETOS");
        }
    }

    public void calcularGastos(String tipo, int qtd, float valor){
        /*for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getTipo().equals("Didatico") || produtos.get(i).getTipo().equals("didatico")) {
                produtos.get(i).setGd((produtos.get(i).getValor() * produtos.get(i).getQtd()));
            }else if (produtos.get(i).getTipo().equals("Escritorio") || produtos.get(i).getTipo().equals("escritorio")){
                produtos.get(i).setGe((produtos.get(i).getValor() * produtos.get(i).getQtd()));
            }else if (produtos.get(i).getTipo().equals("Pedagogico") || produtos.get(i).getTipo().equals("pedagogico")){
                produtos.get(i).setGp((produtos.get(i).getValor() * produtos.get(i).getQtd()));
            }
            System.out.println("didatico: "+produtos.get(i).getGd());
            System.out.println("escritorio: "+produtos.get(i).getGe());
            System.out.println("pedagogico: "+produtos.get(i).getGp());
        }Este modo assim não atribui os proximos valores, se souber como fazer e preferir este modo ao de baixo.... se preferir o debaixo mais simples porem funcionando
        não esquecer de tirar as variaveis gd, ge, gp de Produto(Se fizer do modo de cima nao precisa de parametro porem a debaixo precisa)*/
        if (tipo.equals("Didatico") || tipo.equals("didatico")){
            gastosDidatico += valor * qtd;
        }else if (tipo.equals("Escritorio") || tipo.equals("escritorio")){
            gastosEscritorio += valor * qtd;
        }else if (tipo.equals("Pedagogico") || tipo.equals("pedagogico") || tipo.equals("Pedagógico")){
            gastosPedagogico += valor * qtd;
        }
        System.out.println("didatico: "+gastosDidatico);
        System.out.println("escritorio: "+gastosEscritorio);
        System.out.println("pedagogico: "+gastosPedagogico);
    }

    public void debitarGasto(float valor, String produto, String tipo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNomeProduto().contains(produto)) {
                verba -= valor;
                produtos.get(i).setQtd((short) (produtos.get(i).getQtd() - 1));
            } else {
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

    public void mostrarMateriais() {
        System.out.println("TODOS OS MATERIAIS ABAIXO:");
        for (Produto pro : produtos) {
            System.out.println(pro.getNomeProduto() + " " + pro.getQtd() + " " + pro.getValor());
        }
    }

    public void removerProduto(Produto p){
        produtos.remove(p);
    }
}