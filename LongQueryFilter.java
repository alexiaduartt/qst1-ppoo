/**
 * Strategy: Filtra consultas que possuem mais de 60 caracteres.
 */
public class LongQueryFilter implements WebSearchModel.QueryFilterStrategy {
    private static final int MAX_LENGTH = 60;

    @Override
    public boolean isInteresting(String query) {
        return query.length() > MAX_LENGTH;
    }
}