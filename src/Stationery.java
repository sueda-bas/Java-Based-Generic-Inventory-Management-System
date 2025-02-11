/**
 * The Stationery class represents a stationery item and extends the Item class.
 * It includes an additional attribute for the kind of stationery.
 */
public class Stationery extends Item{
    private String kind;

    /**
     * Constructs a new Stationery object with the specified name, barcode, price, and kind.
     *
     * @param name the name of the stationery item.
     * @param barcode the barcode of the stationery item.
     * @param price the price of the stationery item.
     * @param kind the kind of the stationery item.
     */
    public Stationery(String name, String barcode, double price, String kind) {
        super(name, barcode, price);
        this.kind = kind;
    }

    /**
     * Returns the kind of the stationery item.
     *
     * @return the kind of the stationery item.
     */
    public String getKind() {
        return kind;
    }
}
