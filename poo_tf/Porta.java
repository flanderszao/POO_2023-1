import javax.swing.ImageIcon;

public class Porta extends ElementoBasico{
    private boolean flag;
    private ImageIcon image = Tabuleiro.createImageIcon("fundo.jpg");

    public Porta(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        flag = false;
    }

    @Override
    public boolean getFlag(){
        return flag;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if(flag){
            throw new UnsupportedOperationException("Unimplemented method 'acao'");
        }
        flag = true;
        this.setImage(image);
    }
    
}
