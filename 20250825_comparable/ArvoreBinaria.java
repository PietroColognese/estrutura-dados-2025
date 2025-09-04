public class ArvoreBinaria<T extends Comparable<T>> {
    private class No {
        T valor;
        No esquerda, direita;

        No(T valor) {
            this.valor = valor;
        }
    }

    private No raiz;

    public void inserir(T valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No atual, T valor) {
        if (atual == null) return new No(valor);

        if (valor.compareTo(atual.valor) < 0) {
            atual.esquerda = inserir(atual.esquerda, valor);
        } else {
            atual.direita = inserir(atual.direita, valor);
        }
        return atual;
    }

    public void imprimePreFixado() {
        imprimePreFixado(raiz);
    }

    private void imprimePreFixado(No no) {
        if (no != null) {
            System.out.print(no.valor);
            imprimePreFixado(no.esquerda);
            imprimePreFixado(no.direita);
        }
    }

    public void imprimeEmOrdem() {
        imprimeEmOrdem(raiz);
    }

    private void imprimeEmOrdem(No no) {
        if (no != null) {
            imprimeEmOrdem(no.esquerda);
            System.out.print(no.valor);
            imprimeEmOrdem(no.direita);
        }
    }
}
