/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

import java.util.Scanner;

/**
 *
 * @author Samuel
 */
public class Mancala {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inteligencia inteligencia = new Inteligencia();
        int nivel = 0,
                casaEscolhida,
                teste,
                sair,
                jogador = 0;


        String jogada;
        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.InicializaMatriz();    // Inicializando o tabuleiro.

        do {
            System.out.println("ESCOLHA O NIVEL DE DIFULDADE DO JOGO (de 1 a 8): ");  // Pedindo a entrada para o nivel.
            Scanner input = new Scanner(System.in);
            nivel = Integer.parseInt(input.nextLine());

        } while ((nivel < 1) || (nivel > 8));  //Testando a entrada de nivel, nao podendo ser maior que 8 ou menor que 1.


        do {
            sair = 0;
            System.out.println("Jogador deseja ver o estado atual do tabuleiro e fazer uma jogada ? s/n");
            Scanner input = new Scanner(System.in);
            jogada = input.nextLine();            //Comando de jogada s para sim e n para nao
            if ("s".equals(jogada)) {
                tabuleiro.MostrarTabuleiro();

                do {//Escolhendo a casa para fazer semeadura
                    System.out.println("\nEscolha uma casa para fazer uma semeadura: ");
                    Scanner casa = new Scanner(System.in);
                    casaEscolhida = Integer.parseInt(casa.nextLine());
                    teste = tabuleiro.Mover(casaEscolhida, true);

                    if (teste == 2) {
                        System.out.println("");
                        System.out.println("");
                        tabuleiro.MostrarTabuleiro();
                        System.out.println("Escolha uma casa que possua pedras");
                        System.out.println("");
                        System.out.println("");
                    } else if (teste == 1) {
                        System.out.println("");
                        System.out.println("");
                        tabuleiro.MostrarTabuleiro();
                        System.out.println("Vc tem direito a mais uma jogada ");
                        System.out.println("");
                        System.out.println("");

                    }

                    if ((casaEscolhida > 6) || (casaEscolhida < 0)) { //Não existe casa menor que 0 e nem maior que 6 para o jogador 1
                        System.out.println("jogada inválida, relembre as regras e tente novamente");
                    }
                } while ((casaEscolhida < 0) || (casaEscolhida >= 6) || (teste == 2) || (teste == 1));//Casa não pode ser igual a 7 ou não pode estar vazia

                jogador = 2;
                System.out.println("");
                System.out.println("");
                tabuleiro.MostrarTabuleiro();
                System.out.println("Aguarde é a vez do computador!!!!!!");
                System.out.println("");
                int jog = inteligencia.inteligencia(nivel, tabuleiro);
                tabuleiro.Mover(jog, false);
                tabuleiro.MostrarTabuleiro();
                
                
                
            } else {
                sair = 1;

            }

        } while (sair == 0);


























//                System.out.println("Jogador 2 deseja ver o estado atual do Vetor e fazer uma jogada ? s/n");
//                Scanner input1 = new Scanner(System.in);
//                jogada = input1.nextLine();
//                do {//Escolhendo a casa para fazer semeadura
//                    System.out.println("\nEscolha uma casa para fazer uma semeadura: ");
//                    Scanner casa = new Scanner(System.in);
//                    casaEscolhida = Integer.parseInt(casa.nextLine());
//                    if ((casaEscolhida < 7) || (casaEscolhida > 12)) {//Não existe casa menor que 6 e nem maior que 12 para o jogador 2
//                        System.out.println("jogada inválida, relembre as regras e tente novamente");
//                    }
//                } while ((casaEscolhida < 7) || (casaEscolhida > 12));//Casa não pode ser igual a 7 ou não pode estar vazia
//
//            
//  
//        }

    }
}
