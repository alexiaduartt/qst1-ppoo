import java.io.File;

/**
 * Launch the web-search example.
 * Configura os Observadores e Estratégias (Strategy)
 */
public class Main {
    public static void main(String[] args) {
        // Source file (in the project's data/ folder)
        // VERIFIQUE: A pasta 'data' deve existir na raiz do projeto com o 'Hamlet.txt' dentro.
        File inputTextFile = new File("data/Hamlet.txt");

        // 1. Build object graph (WebSearchModel)
        WebSearchModel model = new WebSearchModel(inputTextFile);
        
        // **IMPORTANTE**: A linha "Snooper snoop = new Snooper(model);" do código inicial foi removida.
        
        // 2. Criação e Configuração 1: Filtro por 'friend'
        WebSearchModel.QueryObserver friendObserver = new FriendQueryObserver();
        WebSearchModel.QueryFilterStrategy friendStrategy = new FriendQueryFilter();
        
        // 3. Criação e Configuração 2: Filtro por tamanho (> 60 caracteres)
        WebSearchModel.QueryObserver longObserver = new LongQueryObserver();
        WebSearchModel.QueryFilterStrategy longStrategy = new LongQueryFilter();
        
        // 4. Registro dos pares (Observer, Strategy) no modelo
        model.addQueryObserver(friendObserver, friendStrategy);
        model.addQueryObserver(longObserver, longStrategy);
        
        // 5. Execute
        model.pretendToSearch();
    }
}