import javax.swing.JOptionPane;

public class Saida extends Armadilha { //pra reutilizar uma coisa lá
    private int cont;

    public Saida(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.cont=0;
    }

    public int getCont(){
        return cont;
    }

    public int setCont(int a){
        cont = cont + a;
        return 0;
    }

    @Override
    public boolean getFlag() {
        return true;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if(cont<50){
            JOptionPane.showMessageDialog(getRootPane(), "Você chegou no final! Você venceu!");
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(getRootPane(), "Você demorou demasiado! A saída trancou-se! Você perdeu!");
            System.exit(0);
        }
    }
    
}
