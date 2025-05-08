package W_6.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void populate() {
        Book multiGenreBook1 = new Book("title1", "author name", new ArrayList<>(Arrays.asList("fantasy", "romance", "horror")), 2021);

        Book horrorBook = new Book("horrorbook", "author name", "horror", 2023);
        Book romanceBook = new Book("romancebook", "author name", "romance", 2021);
        Book horrorBook2 = new Book("horrorbook", "author name", "horror", 2021);
        Recommendation rec = new Recommendation("horror fans", new ArrayList<>(Arrays.asList(horrorBook, horrorBook2)));

        rec.setTargetAudience("author name fans");
        rec.addBook(romanceBook);
        rec.addBook(multiGenreBook1);

        new Book("new book", "someone", "fantasy", 2021);
    }

    public static void createBook(){
        System.out.println("Adding a new book");
        sc.nextLine();

        System.out.println("Name of the book: ");
        String title = sc.nextLine();

        System.out.println("Author of the book: ");
        String author = sc.nextLine();

        System.out.println("Genre(s) of the book (separate multiple genres with a comma): ");
        String genreInput = sc.nextLine();
        List<String> genres = Arrays.asList(genreInput.split("\\s*,\\s*"));

        System.out.println("Publication year: ");
        int publicationYear = sc.nextInt();

        new Book(title, author, genres, publicationYear);
    }

    public static void createRecommendation(){
        System.out.println("Making a new recommendation list");
        sc.nextLine();

        System.out.println("Who's the target audience?");
        String targetAudience = sc.nextLine();

        ArrayList<Book> booksList = new ArrayList<>();
        ArrayList<Book> allBooks = Book.getAllBooks();

        System.out.println("Enter which books to add by list number (separate multiple entries with a comma)");

        for (int i = 0; i < Book.getAllBooks().size(); i++){
            System.out.println("[" + (i + 1) + "] " + Book.getAllBooks().get(i).toString());
        }

        System.out.println();
        String idInput = sc.nextLine();
        for (String id : idInput.split("\\s*,\\s*")) {
            booksList.add(allBooks.get(Integer.parseInt(id) - 1));
        }

        new Recommendation(targetAudience, booksList);
    }

    public static void seeRecommendations(){
        System.out.println("Enter number to see the list or [0] to go back to menu");
        for (int i = 0; i < Recommendation.getAllRecommendations().size(); i++){
            System.out.println("[" + (i + 1) + "] " + Recommendation.getAllRecommendations().get(i).getTargetAudience());
        }
        int choice = sc.nextInt();
        if (choice > 0 && choice <= Recommendation.getAllRecommendations().size()){
            Recommendation rec = Recommendation.getAllRecommendations().get(choice-1);
            System.out.println(rec);

            recommendationOperations(rec);
        }
    }

    public static void recommendationOperations(Recommendation rec){
        System.out.println("Recommendation List Options");
        System.out.println("[1] Clone");
        System.out.println("[2] Add Book To List");
        System.out.println("[3] Remove Book From List");
        System.out.println("[4] Go Back");

        int choice = sc.nextInt();

        if (choice == 1){
            rec.clone();
            System.out.println("Recommendation List Cloned");
            seeRecommendations();
        } else if (choice == 2){
            System.out.println("Which book to add?");
            for (int i = 0; i < Book.getAllBooks().size(); i++){
                System.out.println("[" + (i + 1) + "] " + Book.getAllBooks().get(i).toString());
            }

            int choice2 = sc.nextInt() - 1;
            rec.addBook(Book.getAllBooks().get(choice2));

            recommendationOperations(rec);
        } else if (choice == 3) {
            System.out.println("Which book to remove?");
            for (int i = 0; i < Book.getAllBooks().size(); i++){
                System.out.println("[" + (i + 1) + "] " + Book.getAllBooks().get(i).toString());
            }

            int choice2 = sc.nextInt() - 1;
            rec.removeBook(Book.getAllBooks().get(choice2));

            recommendationOperations(rec);
        } else {
            seeRecommendations();
        }
    }

    public static void main(String[] args) {
        boolean running = true;

        populate();

        while (running) {
            System.out.println("Welcome to Prototype demo!");
            System.out.println("[1] See All Books");
            System.out.println("[2] See All Recommendation Lists");
            System.out.println("[3] Add new book");
            System.out.println("[4] Make new Recommendation List");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    Book.getAllBooks().forEach(System.out::println);
                    break;
                case 2:
                    seeRecommendations();
                    break;
                case 3:
                    createBook();
                    break;
                case 4:
                    createRecommendation();
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }
}
