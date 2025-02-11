/**
 * The Book class represents a book item and extends the Item class.
 * It includes an additional attribute for the author of the book.
 */
public class Book extends Item{
    private String author;

    /**
     * Constructs a new Book object with the specified name, barcode, price, and author.
     *
     * @param name the name of the book.
     * @param barcode the barcode of the book.
     * @param price the price of the book.
     * @param author the author of the book.
     */
    public Book(String name, String barcode, double price, String author) {
        super(name, barcode, price);
        this.author = author;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author of the book.
     */
    public String getAuthor() {
        return author;
    }
}
