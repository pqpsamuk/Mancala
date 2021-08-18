/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

/**
 *
 * @author Samuel
 */
public class Tabuleiro {

    private int[] Vetor = new int[14];
    private int mao = 0;

    public void InicializaMatriz() {
        int i;
        for (i = 0; i <= 13; i++) {                                    //preenchendo o vetor com as pedras, menos as duas casas de captura
            getVetor()[i] = 4;
            if ((i == 6) || (i == 13)) {
                getVetor()[i] = 0;
            }
        }
    }

    public void MostrarTabuleiro() {
        int i;
        for (i = 0; i <= 13; i++) {          //Mostra o estado atual do tabuleiro ao jogador 1
            if (i <= 6) {
                if (i == 6) {                //Mostra as casas de semeadura
                    System.out.println("");
                    System.out.println(" Voce possui: " + getVetor()[i] + " pedras ");
                    System.out.println("");
                } else {
                    System.out.println(" |Sua Casa: " + i + " Qtd Pedras " + getVetor()[i]);   //Mostra a casa de captura
                }
            } else {
                if (i == 13) {//Mostra as casas de semeadura
                    System.out.println("");
                    System.out.println("A maquina possui: " + getVetor()[13] + " pedras ");
                    System.out.println("");
                } else {
                    System.out.println(" |Maquina Casa: " + i + " Qtd Pedras " + getVetor()[i]);   //Mostra a casa de captura
                }
            }
        }

    }

    public int Mover(int casaEscolhida, boolean Jogador) {
        int i = 0;

        if (getVetor()[casaEscolhida] == 0) {
            return 2;

        }
        setMao(getVetor()[casaEscolhida]);
        getVetor()[casaEscolhida] = 0;

//        if (casaEscolhida < 7) { //jogada Jogador
        if (Jogador == true) {
            for (i = 0; i < getMao(); i++) {//Semeando as pedras da casa escolhida
                if ((i == getMao()) && (getVetor()[casaEscolhida + getMao()] == 0)) {
                    getVetor()[casaEscolhida + getMao()]++;
                    getVetor()[6] = getVetor()[casaEscolhida + getMao()] + getVetor()[casaEscolhida + getMao() + 7] + getVetor()[6];
                    getVetor()[casaEscolhida + getMao()] = 0;
                    getVetor()[casaEscolhida + getMao() + 7] = 0;
                }else if (i == getMao()){
                    if (casaEscolhida + getMao() == 6) {
                        return 1;
                    }
                } else {
                    casaEscolhida++;
                    getVetor()[casaEscolhida]++;
                }
                if (casaEscolhida == 12) {
                    casaEscolhida = 0;
                }
            }
            return 0;
        } else if(Jogador == false){      //Jogada Inteligencia
            for (i = 0; i < getMao(); i++) {
                if ((i == getMao()) && (getVetor()[casaEscolhida + getMao()] == 0)) {
                    getVetor()[casaEscolhida + getMao()]++;
                    getVetor()[13] = getVetor()[casaEscolhida + getMao()] + getVetor()[casaEscolhida + getMao() - 7];
                    getVetor()[casaEscolhida + getMao()] = 0;
                    getVetor()[casaEscolhida + getMao() - 7] = 0;
                }else if( i == getMao()) {
                    if(casaEscolhida + getMao() == 13){
                        return 1;
                    }          
                }
                if (casaEscolhida == 12) {
                    casaEscolhida = 0;
                    getVetor()[13]++;
                } else if (casaEscolhida < 6) {
                    if (casaEscolhida + 1 > mao) {
                    } else {
                        getVetor()[casaEscolhida]++;
                        casaEscolhida++;
                    }
                } else if (casaEscolhida == 11) {
                    if (mao >= 2) {
                        getVetor()[12]++;
                        getVetor()[13]++;
                        casaEscolhida = 0;
                        i++;
                    } else {
                        getVetor()[12]++;
                        casaEscolhida++;
                    }
                } else {
                    if (casaEscolhida > 6) {
                        casaEscolhida++;
                        getVetor()[casaEscolhida]++;
                    }

                }
            }
        }
        return 0;
    }

    public Tabuleiro clone() {
        Tabuleiro tab = new Tabuleiro();
        int[] novoVetor = new int[14];
        for (int i = 0; i < 14; i++) {
            novoVetor[i] = Vetor[i];
        }
        tab.setVetor(novoVetor);
        tab.setMao(this.getMao());
        return tab;
    }

    /**
     * @return the Vetor
     */
    public int[] getVetor() {
        return Vetor;
    }

    /**
     * @param Vetor the Vetor to set
     */
    public void setVetor(int[] Vetor) {
        this.Vetor = Vetor;
    }

    /**
     * @return the mao
     */
    public int getMao() {
        return mao;
    }

    /**
     * @param mao the mao to set
     */
    public void setMao(int mao) {
        this.mao = mao;
    }
}
