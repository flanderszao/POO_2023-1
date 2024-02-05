import javax.swing.ImageIcon;

public class PortaChave extends Porta {
    private ImageIcon image = Tabuleiro.createImageIcon("fundo.jpg");
    private boolean flag;
    private int chaveLin, chaveCol;

    public PortaChave(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, int chaveLin, int chaveCol) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.flag = false;
        this.chaveLin = chaveLin;
        this.chaveCol = chaveCol;
    }
    
    private void abrirPorta(Boolean flag2){
        if (flag2){
            this.flag = true;
            this.setImage(image);
        }
    }

    public boolean getFlag(){
        return flag;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (!flag) abrirPorta(getTabuleiro().getElementoNaPosicao(this.chaveLin, this.chaveCol).getFlag());
    }
}
