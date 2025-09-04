import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria<Ajudante> arvore = new ArvoreBinaria<>();

        Ajudante[] ajudantes = {
            new Ajudante("Carlos Silva", "11111111111", "11999999999", "01234000", "carlos@email.com", "João"),
            new Ajudante("Mariana Lima", "22222222222", "21988888888", "22041000", "mariana@email.com", "Fernanda"),
            new Ajudante("Pedro Souza", "33333333333", "31977777777", "30140000", "pedro@email.com", "Lucia"),
            new Ajudante("Ana Costa", "44444444444", "41966666666", "80010000", "ana@email.com", "Roberto"),
            new Ajudante("Lucas Rocha", "55555555555", "51955555555", "90010000", "lucas@email.com", "Patrícia"),
            new Ajudante("Beatriz Ramos", "66666666666", "61944444444", "70040000", "beatriz@email.com", "Renata"),
            new Ajudante("João Pedro", "77777777777", "71933333333", "40010000", "joao@email.com", "Carlos"),
            new Ajudante("Larissa Alves", "88888888888", "81922222222", "50020000", "larissa@email.com", "Paulo"),
            new Ajudante("Rafael Duarte", "99999999999", "91911111111", "60030000", "rafael@email.com", "Marcos"),
            new Ajudante("Fernanda Teixeira", "00000000000", "10192222222", "30010000", "fernanda@email.com", "Adriana")
        };

        embaralhar(ajudantes);

        for (Ajudante a : ajudantes) {
            arvore.inserir(a);
        }

        System.out.println("Impressão Pré-Fixada:");
        arvore.imprimePreFixado();

        System.out.println("\nImpressão Em Ordem:");
        arvore.imprimeEmOrdem();
    }

    public static void embaralhar(Ajudante[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int j = rand.nextInt(array.length);
            Ajudante temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
