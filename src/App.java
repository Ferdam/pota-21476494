import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Console;
import java.util.LinkedList;
import java.text.Collator;

public class App {

    public static final Collator collatorObj = Collator.getInstance();
    public static LinkedList<Person> lstPerson = new LinkedList<Person>();
    public static int lstPersonSize = 0;

    public static void main(String[] args) throws Exception {
        // Daniel Meyer Dammous - RA: 21476494
        init();
        Console console = System.console();
        do {
            String searchTerm = console.readLine("Insira um nome para buscar na lista: ");
            if (searchTerm.isBlank() || searchTerm == null) {
                continue;
            }
            if (searchTerm.equalsIgnoreCase("exit")) {
                break;
            }
            SearchResult searchResult = stringBinarySearch(searchTerm.toLowerCase());
            if (searchResult.indexFound < 0) {
                System.out.println("Nenhum registro foi encontrado.\n" + "Quantidade de comparações: " + searchResult.comparisons);
                continue;
            }
            System.out.println("\nDados da pessoa encontrada: " + searchResult.result.toString());
            System.out.println("Índice na lista: " + searchResult.indexFound);
            System.out.println("Quantidade de comparações: " + searchResult.comparisons + "\n\n");
        } while (true);
    }

    public static void init() throws Exception {
        collatorObj.setStrength(Collator.NO_DECOMPOSITION);
        FileInputStream varFIS = new FileInputStream("files/arquivoDados.csv");
        BufferedReader varBuffReader = new BufferedReader(new InputStreamReader(varFIS));
        String eachLine;
        lstPersonSize = 0;
        while ((eachLine = varBuffReader.readLine()) != null) {
            String[] lstProps = eachLine.split(",");
            lstPerson.add(new Person() {
                {
                    nome     = lstProps[0];
                    sexo     = lstProps[1];
                    endereço = lstProps[2];
                    cidade   = lstProps[3];
                    email    = lstProps[4];
                    telefone = lstProps[5];
                    idade    = lstProps[6];
                }
            });
            lstPersonSize++;
        }
        varFIS.close();
    }

    public static SearchResult stringBinarySearch(String term) {
        int left = 0;
        int right = lstPerson.size() - 1;
        int mid;
        SearchResult searchResult = new SearchResult() {{ comparisons = 0; }};

		while (left <= right) {
			mid = (left + right) / 2;
            searchResult.comparisons++;
			// if (lstPerson.get(mid).nome.compareToIgnoreCase(term) < 0)
			if (collatorObj.compare(lstPerson.get(mid).nome.toLowerCase(), term) < 0) {
				left = mid + 1;
			}
			// else if (lstPerson.get(mid).nome.compareToIgnoreCase(term) > 0) {
			else if (collatorObj.compare(lstPerson.get(mid).nome.toLowerCase(), term) > 0) {
				right = mid - 1;
			} 
			else {
                searchResult.result = lstPerson.get(mid);
                searchResult.indexFound = mid;
				return searchResult;
			}
		}
        searchResult.result = null;
        searchResult.indexFound = -1;
		return searchResult;
	}
}