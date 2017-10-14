package projeto.escola;
import projeto.bancoDeDados.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Escola {
    private BancoDeDados bd = new BancoDeDados();
    private int qtdAluno, qtdProfessor;
    private float verba = 0, gastosDidatico, gastosEscritorio, gastosPedagogico;
    private String nomeDaEscola;
    Pessoa p = new Pessoa();
    Produto pro = new Produto();
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private ArrayList<Pessoa> integrantes = new ArrayList<Pessoa>();

    public Escola() {
    }
    public float calculaCustoMedioAluno(){
        return gastosDidatico / qtdAluno;
    }
    public void cadastrarMateriais() throws InputMismatchException {

        try {
        	
            Scanner l = new Scanner(System.in);
            l.useLocale(Locale.ENGLISH);
            System.out.print("Nome do item: ");
            pro.setNomeProduto(l.nextLine());
            System.out.print("Tipo (Escritorio, Didatico, etc)):");
            pro.setTipo(l.nextLine());
            System.out.print("Quantidade adquirida: ");
            pro.setQtd(l.nextShort());
            System.out.print("Valor unitario (Ex.: 15.75): ");
            pro.setValor(l.nextFloat());
            produtos.add(pro);
        } catch (InputMismatchException e) {
            System.err.println("ENTRADA INCOMPATIVEL! VERIFIQUE SE INFORMOU OS VALORSE NOS CAMPOS CORRETOS");
        }
       // String nome,String tipo,short qtd,float valor

        bd.inserirDados(pro.getNomeProduto(),pro.getTipo(),pro.getQtd(),pro.getValor());

    }
    public void cadastrarIntegrantesEscola() throws  InputMismatchException{
        try{
            Scanner l = new Scanner(System.in);
            l.useLocale(Locale.ENGLISH);
            System.out.print("Nome: ");
            p.setNome(l.nextLine());
            System.out.print("Ocupação do integrante(Aluno, Professor, Secretário, Diretor): ");
            p.setOcupacao(l.nextLine());
            System.out.print("Idade: ");
            p.setIdade(l.nextShort());
            System.out.print("Código: ");
            p.setCodigo(l.nextShort());
            integrantes.add(p);
            if (p.getOcupacao().equals("Aluno") || p.getOcupacao().equals("aluno")) {
                qtdAluno++;
            }else if (p.getOcupacao().equals("Professor") || p.getOcupacao().equals("professor")){
                qtdProfessor++;
            }
        }catch(InputMismatchException e){
            System.err.println("ENTRADA INCOMPATIVEL! VERIFIQUE SE INFORMOU OS VALORSE NOS CAMPOS CORRETOS");
        }
    }
    public void calcularGastos(){
            if (pro.getTipo().equals("Didatico") || pro.getTipo().equals("didatico") ){
                gastosDidatico += pro.getValor() * pro.getQtd();
            }else if (pro.getTipo().equals("Escritorio") || pro.getTipo().equals("escritorio")){
                gastosEscritorio += pro.getValor() * pro.getQtd();
            }else if (pro.getTipo().equals("Pedagogico") || pro.getTipo().equals("pedagogico") || pro.getTipo().equals("Pedagógico")) {
                gastosPedagogico += pro.getValor() * pro.getQtd();
            }
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
        System.out.println(bd.mostrarDados());
    }
    public void mostrarIntegrantesEscola(){
        System.out.println("TODOS OS PROFESSORES ABAIXO:");
        for (Pessoa integra : integrantes){
            System.out.println(integra.getNome() + " " + integra.getCodigo() + " " + integra.getIdade());
        }
    }
    public void removerProduto(Produto p){
        produtos.remove(p);
        }
}
