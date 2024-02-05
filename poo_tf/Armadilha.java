import javax.swing.JOptionPane;

public class Armadilha extends ElementoBasico {

    public Armadilha(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), "Você pisou em uma armadilha! Fim de Jogo!");
        System.exit(0);
    }

    @Override
    public boolean getFlag() {
        throw new UnsupportedOperationException("Unimplemented method 'getFlag'");
    }
    
}
