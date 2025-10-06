/**
 * Observer: Imprime consultas filtradas com a palavra 'friend'.
 */
public class FriendQueryObserver implements WebSearchModel.QueryObserver {
    @Override
    public void onQuery(String query) {
        System.out.println("Oh Yes! " + query);
    }
}