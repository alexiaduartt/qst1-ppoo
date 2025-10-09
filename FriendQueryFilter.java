/**
 * Strategy: Filtra consultas que contêm a palavra 'friend' (não diferencia maiúsculas de minúsculas).
 */
public class FriendQueryFilter implements WebSearchModel.QueryFilterStrategy {
    @Override
    public boolean isInteresting(String query) {
        // A conversão para minúsculas garante a insensibilidade ao caso.
        return query.toLowerCase().contains("friend");
    }
}