/**
 * The Toy class represents a toy item and extends the Item class.
 * It includes an additional attribute for the color of the toy.
 */
public class Toy extends Item{
    private String color;

    /**
     * Constructs a new Toy object with the specified name, barcode, price, and color.
     *
     * @param name the name of the toy.
     * @param barcode the barcode of the toy.
     * @param price the price of the toy.
     * @param color the color of the toy.
     */
    public Toy(String name, String barcode, double price, String color) {
        super(name, barcode, price);
        this.color = color;
    }

    /**
     * Returns the color of the toy.
     *
     * @return the color of the toy.
     */
    public String getColor() {
        return color;
    }
}
