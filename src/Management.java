import java.util.HashMap;
import java.util.Map;

/**
 * The Management class handles the management of various types of items as Books, Toys, and Stationery.
 * It provides methods to add, remove, search, and display items from the respective inventories.
 */
public class Management {
    private Map<String, Inventory<? extends Item>> inventories;
    private Inventory<Book> bookInventory = new Inventory<>();
    private Inventory<Toy> toyInventory = new Inventory<>();
    private Inventory<Stationery> stationeryInventory = new Inventory<>();

    /**
     * Constructs a new Management object and initializes the inventories for different item types.
     */
    public Management() {
        inventories = new HashMap<>();
        inventories.put("Book", bookInventory);
        inventories.put("Toy", toyInventory);
        inventories.put("Stationery", stationeryInventory);
    }

    /**
     * Manages various commands such as ADD, REMOVE, SEARCHBYBARCODE, SEARCHBYNAME, and DISPLAY.
     *
     * @param parts the parts of the command split by tabs.
     * @param args the command line arguments where:
     *             args[1] is the output file path.
     */
    public void manageCommand(String[] parts, String[] args) {
        String command = parts[0];
        switch (command) {
            case "ADD":
                manageAdd(parts);
                break;
            case "REMOVE":
                FileOutput.writeToFile(args[1], "REMOVE RESULTS:", true, true);
                manageRemove(parts[1], args);
                FileOutput.writeToFile(args[1], "------------------------------", true, true);
                break;
            case "SEARCHBYBARCODE":
                FileOutput.writeToFile(args[1], "SEARCH RESULTS:", true, true);
                manageSearchByBarcode(parts[1], args);
                FileOutput.writeToFile(args[1], "------------------------------", true, true);
                break;
            case "SEARCHBYNAME":
                FileOutput.writeToFile(args[1], "SEARCH RESULTS:", true, true);
                manageSearchByName(parts[1], args);
                FileOutput.writeToFile(args[1], "------------------------------", true, true);
                break;
            case "DISPLAY":
                FileOutput.writeToFile(args[1], "INVENTORY:", true, true);
                manageDisplay(args);
                FileOutput.writeToFile(args[1], "------------------------------", true, true);
                break;
            default:
                break;
        }
    }

    /**
     * Manages the addition of a new item to the appropriate inventory based on the item type.
     *
     * @param parts the parts of the command containing item details.
     */
    private void manageAdd(String[] parts) {
        String itemType = parts[1];
        String name = parts[2];
        String info = parts[3];
        String barcode = parts[4];
        double price = Double.parseDouble(parts[5]);
        switch (itemType) {
            case "Book":
                bookInventory.addItem(new Book(name, barcode, price, info));
                break;
            case "Toy":
                toyInventory.addItem(new Toy(name, barcode, price, info));
                break;
            case "Stationery":
                stationeryInventory.addItem(new Stationery(name, barcode, price, info));
        }
    }

    /**
     * Manages the removal of an item from the inventories based on its barcode.
     *
     * @param barcode the barcode of the item to be removed.
     * @param args the command line arguments where:
     *             args[1] is the output file path.
     */
    private void manageRemove(String barcode, String[] args) {
    for (Inventory<? extends Item> inventory : inventories.values()) {
        if (inventory.removeItem(barcode)) {
            FileOutput.writeToFile(args[1], "Item is removed.", true, true);
            return;
        }
    }FileOutput.writeToFile(args[1], "Item is not found.", true, true);
    }

    /**
     * Manages the search for an item by its barcode.
     *
     * @param barcode the barcode of the item to search for.
     * @param args the command line arguments where:
     *             args[1] is the output file path.
     */
    private void manageSearchByBarcode(String barcode, String[] args) {
        for (Inventory<? extends Item> inventory : inventories.values()) {
            Item item = inventory.searchByBarcode(barcode);
            if (item != null) {
                writeWantedItem(item, args);
                return;
            }
        }FileOutput.writeToFile(args[1], "Item is not found.", true, true);
    }

    /**
     * Manages the search for an item by its name.
     *
     * @param name the name of the item to search for.
     * @param args the command line arguments where:
     *             args[1] is the output file path.
     */
    private void manageSearchByName(String name, String[] args) {
        for (Inventory<? extends Item> inventory : inventories.values()) {
            Item item = inventory.searchByName(name);
            if (item != null) {
                writeWantedItem(item, args);
                return;
            }
        }FileOutput.writeToFile(args[1], "Item is not found.", true, true);
    }

    /**
     * Writes the details of the found item to the output file.
     *
     * @param item the item whose details are to be written.
     * @param args the command line arguments where:
     *             args[1] is the output file path.
     */
    private void writeWantedItem(Item item, String[] args) {
        String name = item.getName();
        String barcode = item.getBarcode();
        double price = item.getPrice();
        if (item instanceof Book) {
            String author = ((Book) item).getAuthor();
            FileOutput.writeToFile(args[1], "Author of the " + name + " is " + author + ". Its barcode is " + barcode + " and its price is " + price, true, true);
        } else if (item instanceof Toy) {
            String color = ((Toy) item).getColor();
            FileOutput.writeToFile(args[1], "Color of the " + name + " is " + color + ". Its barcode is " + barcode + " and its price is " + price, true, true);
        } else if (item instanceof Stationery) {
            String kind = ((Stationery) item).getKind();
            FileOutput.writeToFile(args[1], "Kind of the " + name + " is " + kind + ". Its barcode is "+ barcode + " and its price is " + price, true, true);
        }
    }

    /**
     * Manages the display of all items in the inventories.
     *
     * @param args the command line arguments where:
     *             args[1] is the output file path.
     */
    private void manageDisplay(String[] args) {
        for (Item book : bookInventory.getItems()) {
            String name = book.getName();
            String author = ((Book) book).getAuthor();
            String barcode = book.getBarcode();
            double price = book.getPrice();
            FileOutput.writeToFile(args[1], "Author of the " + name + " is " + author + ". Its barcode is " + barcode + " and its price is " + price, true, true);

        }
        for(Item toy : toyInventory.getItems()){
            String name = toy.getName();
            String color = ((Toy) toy).getColor();
            String barcode = toy.getBarcode();
            double price = toy.getPrice();
            FileOutput.writeToFile(args[1], "Color of the " + name + " is " + color + ". Its barcode is " + barcode + " and its price is " + price, true, true);

        }
        for(Item stationary : stationeryInventory.getItems()){
            String name = stationary.getName();
            String kind = ((Stationery) stationary).getKind();
            String barcode = stationary.getBarcode();
            double price = stationary.getPrice();
            FileOutput.writeToFile(args[1], "Kind of the " + name + " is " + kind + ". Its barcode is "+ barcode + " and its price is " + price, true, true);
        }
    }
}

