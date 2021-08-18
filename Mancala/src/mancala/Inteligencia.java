/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

/**
 *
 * @author Samuel
 */
public class Inteligencia {

    public int inteligencia(int nivel, Tabuleiro tabuleiro) {
        No no = new No();
        no.setTabuleiro(tabuleiro);
        no.setMax(true);

        criarArvore(no, nivel, false);
        
        
        //executar minimax em cada filho de no (raiz) e retornar a jogada armazenada naquele no
        try{
           int max = ((No)no.getFilhos().getDado(1)).MinMax();
           int pos = 1;
           for(int i = 2; i <= no.getFilhos().getNumDados();i++){
               int m1 = ((No)no.getFilhos().getDado(i)).MinMax();
               if(m1 > max){
                   max = m1;
                   pos = i;
               }
           }
            return ((No)no.getFilhos().getDado(pos)).getPosJogada();
        }catch(Exception e){
            e.printStackTrace();
            return 7;
        }
    }

    public void criarArvore(No no, int nivel, boolean jogador) {
        if (nivel == 0) {
            return;
        }
        Tabuleiro t = no.getTabuleiro();
        if (jogador == true) {
            for (int i = 0; i < 6; i++) {
                if (t.getVetor()[i] > 0) {
                    No nofilho = new No();
                    nofilho.setPosJogada(i);
                    nofilho.setMax(false);
                    Tabuleiro clone = t.clone();
                    clone.Mover(i, jogador);
                    nofilho.setTabuleiro(clone);
                    no.insereFilho(nofilho);
                    criarArvore(nofilho, nivel - 1, !jogador);
                }
            }
        } else {
            for (int i = 7; i < 13; i++) {
                if (t.getVetor()[i] > 0) {
                    No nofilho = new No();
                    nofilho.setPosJogada(i);
                    nofilho.setMax(true);
                    Tabuleiro clone = t.clone();
                    clone.Mover(i, jogador);
                    nofilho.setTabuleiro(clone);
                    no.insereFilho(nofilho);
                    criarArvore(nofilho, nivel - 1, !jogador);
                }



            }
        }
        return;

    }
}
