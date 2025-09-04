public class Ajudante implements Comparable<Ajudante> {
    private String nome;
    private String cpf;
    private String telefone;
    private String cep;
    private String email;
    private String pessoaResponsavel;

    public Ajudante(String nome, String cpf, String telefone, String cep, String email, String pessoaResponsavel) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.email = email;
        this.pessoaResponsavel = pessoaResponsavel;
    }

    @Override
    public int compareTo(Ajudante outro) {
        // Comparar por nome + CPF para evitar duplicidade
        return (this.nome + this.cpf).compareTo(outro.nome + outro.cpf);
    }

    @Override
    public String toString() {
        return "Ajudante: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone + ", CEP: " + cep +
                ", Email: " + email + ", Responsável: " + pessoaResponsavel + "\n";
    }
}
