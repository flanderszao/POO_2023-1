import javax.swing.JOptionPane;

public class Placa extends ElementoBasico {

    public Placa(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
    }

    @Override
    public boolean getFlag() {
        return false;
    }

    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), "Os caminhos 1 e 2 tem armadilhas!");
    }
    
}
