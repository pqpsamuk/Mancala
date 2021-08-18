/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mancala;


/**
 *
 * @author Samuel
 */
public class ListaLigada {

    protected Elemento cabeca;
    protected Elemento cauda;

    public ListaLigada() {
    }

    public void esvazia() {
        this.cabeca = null;
        this.cauda = cabeca;
    }

     public Elemento getCabeca() {
        return cabeca;
    }

    public Elemento getCauda() {
        return cauda;
    }

    public boolean estaVazia() {
        return (cabeca == null);
    }

    public Object getPrimeiro() throws ContainerVazioException {
        if (cabeca == null) {
            throw new ContainerVazioException("Lista Vazia!");
        }
        return cabeca.getDado();

    }

    public Object getUltimo() throws ContainerVazioException {
        if (cauda == null) {
            throw new ContainerVazioException("Lista Vazia!");
        }
        return cauda.getDado();


    }

    public void adicionaInicio(Object item) {
        //Elemento tmp = new Elemento(item, cabeca);
        Elemento tmp = new Elemento();
        tmp.dado = item;
        tmp.proximo = cabeca;
        if (cabeca == null) {
            cauda = tmp;
        }
        cabeca = tmp;
    }

    public void adicionaFim(Object item) {
        Elemento tmp = new Elemento(item, null);
        if (cabeca == null) {
            cabeca = tmp;
        } else {
            cauda.setProximo(tmp);
        }
        cauda = tmp;
    }

    public int getNumDados() {
        int n = 0;
        Elemento tmp = cabeca;
        while (tmp != null) {
            tmp = tmp.getProximo();
            n++;
        }
        return n;
    }

    public void adicione(Object item, int posicao) {
        if (posicao > this.getNumDados()) {
            adicionaFim(item);
        } else {
            if (posicao == 1) {
                this.adicionaInicio(item);
            } else {
                Elemento tmp = cabeca;
                for (int i = 1; i < posicao - 1; i++) {
                    tmp = tmp.getProximo();
                }
                tmp.setProximo(new Elemento(item, tmp.getProximo()));
                if (tmp == cauda) {
                    cauda = tmp.getProximo();
                }

            }
        }
    }

    public void remova(Object dado) {
        Elemento ptr = cabeca;
        Elemento prevPtr = null;
        while (ptr != null && ptr.getDado() != dado) {
            prevPtr = ptr;
            ptr = ptr.getProximo();
        }
        if (ptr == null) {
            throw new IllegalArgumentException("item não encontrado");
        }
        if (ptr == cabeca) {
            cabeca = ptr.getProximo();
        } else {
            prevPtr.setProximo(ptr.getProximo());
        }
        if (ptr == cauda) {
            cauda = prevPtr;
        }
    }

    public Object remova(int posicao) throws ContainerVazioException {
        if (estaVazia()) {
            throw new ContainerVazioException("Lista Vazia!");
        } else {
            if (posicao <= this.getNumDados()) {
                Elemento removido = cabeca;
                Elemento anteriorRemovido = null;
                for (int i = 1; i < posicao; i++) {
                    anteriorRemovido = removido;
                    removido = removido.getProximo();
                }
                if (removido == cabeca) {
                    cabeca = removido.getProximo();
                } else {
                    anteriorRemovido.setProximo(removido.getProximo());
                }
                if (removido == cauda) {
                    cauda = anteriorRemovido;
                }
                return removido.getDado();
            } else {
                return null;
            }
        }
    }

    public Object getDado(int posicao) throws ContainerVazioException {
        if (estaVazia()) {
            throw new ContainerVazioException("Lista Vazia!");
        } else {
            if (posicao <= this.getNumDados()) {
                Elemento tmp = cabeca;
                for (int i = 1; i < posicao; i++) {
                    tmp = tmp.getProximo();
                }

                return tmp.getDado();
            } else {
                return null;
            }
        }
    }

    public void removaOcorrencias(Object dado) throws ContainerVazioException {
        if (estaVazia()) {
            throw new ContainerVazioException("Lista Vazia!");
        } else {
            for (int i = 1; i <= this.getNumDados(); i++) {
                if (this.getDado(i).equals(dado)) {
                    this.remova(i);
                    i--;
                }
            }
        }
    }

    @Override
    public String toString() {
        
        String ret = "Lista:";
        for (int i = 1; i <= this.getNumDados(); i++) {
            try {
                ret = ret +" "+this.getDado(i).toString();
            } catch (ContainerVazioException ex) {
                return ex.getMessage();
            }
         }
         return ret;
    }
    
    
    
}
