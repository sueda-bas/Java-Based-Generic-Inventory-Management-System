import java.util.ArrayList;
import java.util.List;

/**
 * The Inventory class manages a collection of items of a specific type.
 * It provides methods to add, remove, search, and retrieve all items in the inventory.
 *
 * @param <T> the type of items that this inventory holds, which must extend the Item class.
 */
public class Inventory <T extends Item>{
    private List<T> items;

    /**
     * Constructs a new, empty inventory.
     */
    public Inventory() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the inventory.
     *
     * @param item the item to be added.
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Removes an item from the inventory based on its barcode.
     *
     * @param barcode the barcode of the item to be removed.
     * @return true if the item was found and removed, false otherwise.
     */
    public boolean removeItem(String barcode) {
        List<T> itemsToRemove = new ArrayList<>();
        boolean isRemoved = false;
        for (T item : this.items) {
            if (item.getBarcode().equals(barcode)) {
                itemsToRemove.add(item);
                isRemoved = true;
            }
        }
        this.items.removeAll(itemsToRemove);
        return isRemoved;
    }

    /**
     * Searches for an item in the inventory by its barcode.
     *
     * @param barcode the barcode of the item to search for.
     * @return the item with the specified barcode, or null if no such item exists.
     */
    public T searchByBarcode(String barcode) {
        for (T item : this.items) {
            if (item.getBarcode().equals(barcode)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Searches for an item in the inventory by its name.
     *
     * @param name the name of the item to search for.
     * @return the item with the specified name, or null if no such item exists.
     */
    public T searchByName(String name) {
        for (T item : this.items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Retrieves all items in the inventory.
     *
     * @return a list of all items in the inventory.
     */
    public List<T> getItems() {
        return this.items;
    }
}
