/**
 * The Item class represents item with a name, barcode, and price.
 * It serves as a base class for specific types of items such as books, toys, and stationery.
 */
public class Item {
    private String name;
    private String barcode;
    private double price;

    /**
     * Constructs a new Item object with the specified name, barcode, and price.
     *
     * @param name the name of the item.
     * @param barcode the barcode of the item.
     * @param price the price of the item.
     */
    public Item(String name, String barcode, double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the barcode of the item.
     *
     * @return the barcode of the item.
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item.
     */
    public double getPrice() {
        return price;
    }
}
