package W_6.prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    String targetAudience;
    ArrayList<Book> recommended;

    private static final ArrayList<Recommendation> allRecommendations = new ArrayList<>();

    public Recommendation(String targetAudience, ArrayList<Book> recommendations) {
        this.targetAudience = targetAudience;
        this.recommended = recommendations;

        allRecommendations.add(this);
    }

    public void addBook(Book book) {
        this.targetAudience = targetAudience;
        recommended.add(book.clone());
    }

    public void removeBook(Book book) {
        recommended.remove(book);
    }

    public List<Book> getRecommended() {
        return recommended;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public static ArrayList<Recommendation> getAllRecommendations() {
        return allRecommendations;
    }

    @Override
    public Recommendation clone(){
        try {
            Recommendation clonedRecommendation = (Recommendation) super.clone();
            clonedRecommendation.recommended = new ArrayList<>();

            for (Book book : this.recommended) {
                clonedRecommendation.recommended.add(book.clone());
            }
            clonedRecommendation.setTargetAudience(this.targetAudience + " (Copy)");
            allRecommendations.add(clonedRecommendation);
            return clonedRecommendation;
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        for (Book book : recommended) {
            string.append(String.format("%s by %s (%s)\n", book.getTitle(), book.getAuthor(), book.getPublicationYear()));
        }

        return "Recommendations for " + this.targetAudience + ":\n" + string;
    }
}
