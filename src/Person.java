public class Person {
    public String nome;
    public String sexo;
    public String endereço;
    public String cidade;
    public String email;
    public String telefone;
    public String idade;

    public Person() {
        
    }

    @Override
    public String toString() {
        return  "\nˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍˍ"
        + "\nNome: "     + this.nome
        + "\nSexo: "     + this.sexo
        + "\nEndereço: " + this.endereço
        + "\nCidade: "   + this.cidade
        + "\nEmail: "    + this.email
        + "\nTelefone: " + this.telefone
        + "\nIdade: "    + this.idade
        +       "\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯"
        ;
    }
}
