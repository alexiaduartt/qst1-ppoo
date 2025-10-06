/**
 * Observer: Imprime consultas filtradas com mais de 60 caracteres.
 */
public class LongQueryObserver implements WebSearchModel.QueryObserver {
    @Override
    public void onQuery(String query) {
        // Nota: Mantive os quatro pontos (".... ") para garantir a correspondência exata do output
        System.out.println("So long.... " + query); 
    }
}