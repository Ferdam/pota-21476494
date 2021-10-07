public class SearchResult {
    public Person result;
    public int comparisons;
    public int indexFound;

    public SearchResult() {
        this.result = new Person() {{
            nome     = "";
            sexo     = "";
            endereço = "";
            cidade   = "";
            email    = "";
            telefone = "";
            idade    = "";
        }};
    }
}
