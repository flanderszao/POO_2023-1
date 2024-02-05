import javax.swing.JOptionPane;

public class Personagem extends ElementoBasico {
    private ElementoBasico anterior;

    public Personagem(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
    }

    public void setAnterior(ElementoBasico anterior){
        this.anterior = anterior;
    }
    
    public void moveDireita() {

        if (getTabuleiro().getCont()>=50) getTabuleiro().getElementoNaPosicao(TRAILING, UNDEFINED_CONDITION).acao(anterior);

        // Remove o Personagem da posicao atual e avança

        getTabuleiro().insereElemento(anterior);
        this.incCol();
        // Verifica se tem algum elemento de interesse na nova posicao
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (!(elemento instanceof Fundo) && !elemento.getFlag()) {
            elemento.acao(this);
            this.decCol();
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
            this.anterior = getTabuleiro().insereElemento(this);
        }
    }


    public void moveEsquerda() {
        // Remove o Personagem da posicao atual e avança

        getTabuleiro().insereElemento(anterior);
        this.decCol();
        // Verifica se tem algum elemento de interesse na nova posicao
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (!(elemento instanceof Fundo) && !elemento.getFlag()) {
            elemento.acao(this);
            this.incCol();
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
            this.anterior = getTabuleiro().insereElemento(this);
        }
    }


    public void moveCima() {
        // Remove o Personagem da posicao atual e avança

        getTabuleiro().insereElemento(anterior);
        this.decLin();
        // Verifica se tem algum elemento de interesse na nova posicao
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (!(elemento instanceof Fundo) && !elemento.getFlag()) {
            elemento.acao(this);
            this.incLin();
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
            this.anterior = getTabuleiro().insereElemento(this);
        }
    }

    public void moveBaixo() {
        // Remove o Personagem da posicao atual e avança

        getTabuleiro().insereElemento(anterior);
        this.incLin();
        // Verifica se tem algum elemento de interesse na nova posicao
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if ((elemento instanceof Armadilha) || !(elemento instanceof Fundo) && !elemento.getFlag()) {
            elemento.acao(this);
            this.decLin();
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
            this.anterior = getTabuleiro().insereElemento(this);
        }
    }

    public void acaoContexto(){
        ElementoBasico a = getTabuleiro().getElementoNaPosicao(this.getLin()+1, this.getCol());
        ElementoBasico b = getTabuleiro().getElementoNaPosicao(this.getLin()-1, this.getCol());
        ElementoBasico c = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol()+1);
        ElementoBasico d = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol()-1);
        if (!(a instanceof Fundo) && !(a instanceof Armadilha) && !(a instanceof Oponente)) a.acao(this);
        if (!(b instanceof Fundo) && !(b instanceof Armadilha) && !(b instanceof Oponente)) b.acao(this);
        if (!(c instanceof Fundo) && !(c instanceof Armadilha) && !(c instanceof Oponente)) c.acao(this);
        if (!(d instanceof Fundo) && !(d instanceof Armadilha) && !(d instanceof Oponente)) d.acao(this);
    }

    @Override
    public void acao(ElementoBasico outro) {
        JOptionPane.showMessageDialog(getRootPane(), "O seu Oponente lhe encontrou! Fim de Jogo!");
        System.exit(0);
    }

    @Override
    public boolean getFlag() {
        return false;
    }
}
