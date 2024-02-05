import javax.swing.ImageIcon;

public class Chave extends ElementoBasico {
    ImageIcon image = Tabuleiro.createImageIcon("fundo.jpg");
    Boolean flag;

    public Chave(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        flag = false;
    }

    @Override
    public boolean getFlag(){
        return flag;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (flag) throw new UnsupportedOperationException("Unimplemented method 'acao'");
        else { 
            flag = true;
            this.setImage(image);
        }
    }
    
}
