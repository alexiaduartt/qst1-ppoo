import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Perform "web search" (from a  file), notify the interested observers of each query,
 * filtering the queries using the Strategy pattern.
 */
public class WebSearchModel {
    private final File sourceFile;
    
    // Classe interna para emparelhar o observador com sua estratégia de filtro.
    private static class ObserverStrategyPair {
        final QueryObserver observer;
        final QueryFilterStrategy strategy;

        ObserverStrategyPair(QueryObserver observer, QueryFilterStrategy strategy) {
            this.observer = observer;
            this.strategy = strategy;
        }
    }

    private final List<ObserverStrategyPair> observers = new ArrayList<>();

    // Interface do Observador (inalterada)
    public interface QueryObserver {
        void onQuery(String query);
    }
    
    // Interface para a Strategy do Filtro (NOVA INTERFACE)
    public interface QueryFilterStrategy {
        /**
         * Retorna true se a consulta for considerada "interessante" para este filtro.
         */
        boolean isInteresting(String query);
    }


    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                notifyAllObservers(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método de registro alterado para aceitar a estratégia de filtro.
    public void addQueryObserver(QueryObserver queryObserver, QueryFilterStrategy filterStrategy) {
        observers.add(new ObserverStrategyPair(queryObserver, filterStrategy));
    }

    private void notifyAllObservers(String line) {
        for (ObserverStrategyPair pair : observers) {
            // Aplicação da Strategy: Verifica se a consulta é interessante para o observador.
            if (pair.strategy.isInteresting(line)) {
                pair.observer.onQuery(line);
            }
        }
    }
}