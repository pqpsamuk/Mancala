/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

/**
 *
 * @author Samuel
 */
public class No {

    private boolean max;
    private ListaLigada filhos = new ListaLigada();
    private Tabuleiro tabuleiro;
    private int posJogada;

    public int getPosJogada() {
        return posJogada;
    }

    public void setPosJogada(int posJogada) {
        this.posJogada = posJogada;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Object valor) {
        //this.valor = valor;
    }

    public void insereFilho(No filho) {
        filhos.adicionaInicio(filho);

    }

    public int avalia() {
        return tabuleiro.getVetor()[13] - tabuleiro.getVetor()[6];
    }

    public void setMax(boolean max) {
        this.max = max;
    }

    public int MinMax(){
        if (filhos.estaVazia()) {
            return avalia();
        } else {
            if (max) {
                try {
                    
                    int max = ((No) getFilhos().getDado(1)).MinMax();
                    for (int i = 2; i <= getFilhos().getNumDados(); i++) {
                        int m1 = ((No) getFilhos().getDado(i)).MinMax();
                        if (m1 > max) {
                            max = m1;
                        }
                    }
                    return max;
                } catch (Exception e) {
                    e.printStackTrace();
                    return 7;
                }
            } else {
                try {
                    int min = ((No) getFilhos().getDado(1)).MinMax();
                    for (int i = 2; i <= getFilhos().getNumDados(); i++) {
                        int m1 = ((No) getFilhos().getDado(i)).MinMax();
                        if (m1 < min) {
                            min = m1;
                            return min;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return 7;
                }
            }

        }   
        return 0;
    }

    /**
     * @return the filhos
     */
    public ListaLigada getFilhos() {
        return filhos;
    }

    /**
     * @param filhos the filhos to set
     */
    public void setFilhos(ListaLigada filhos) {
        this.filhos = filhos;
    }

    /**
     * @return the tabuleiro
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    /**
     * @param tabuleiro the tabuleiro to set
     */
    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
