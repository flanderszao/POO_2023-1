import javax.swing.JOptionPane;

public class Oponente extends Personagem {
    private int cont;

    public Oponente(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.cont = 0;
    }

    public int getCont(){
        return cont;
    }

    public void setCont(int a){
        cont = a;
    }

    @Override
    public boolean getFlag(){
        return false;
    }

    @Override
    public void acao(ElementoBasico outro){
        JOptionPane.showMessageDialog(getRootPane(), "O seu Oponente lhe encontrou! Fim de Jogo!");
        System.exit(0);
    }
    
}
