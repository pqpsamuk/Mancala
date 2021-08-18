/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;

/**
 *
 * @author Samuel
 */
public class Elemento {
    public Object dado;
    public Elemento proximo;

    public Elemento() {
    }   
    
    public Elemento(Object dado, Elemento proximo) {
        this.dado = dado;
        this.proximo = proximo;
    }

    public Object getDado() {
        return dado;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setDado(Object dado) {
        this.dado = dado;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
    
      
    
}
