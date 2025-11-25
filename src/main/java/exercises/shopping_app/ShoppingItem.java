package exercises.shopping_app;

/**
 * Requirements for ShoppingItem
 * Fields:
 * String aisle; (you may also use int if you prefer numeric aisles)
 * String name;
 * A constructor that sets both fields.
 * getAisle() and getName() accessor methods (and toString() for nice printing).
 * Implement Comparable<ShoppingItem> so that items are ordered by:
 * Aisle (ascending), then
 * Name (alphabetically) when aisles are equal
 */
public class ShoppingItem implements Comparable<ShoppingItem> {
    //TODO
    String aisle;
    String name;

    public ShoppingItem(String aisle, String name) {
        this.aisle = aisle;
        this.name = name;
    }
    public String getAisle() {
        return aisle;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShoppingItem" + name);
        sb.append("Aisle" + aisle);
        return sb.toString();
    }
    @Override
    public int compareTo(ShoppingItem o) {
        int aisleCompare = this.aisle.compareTo(o.aisle);
        if (aisleCompare != 0) {
            return aisleCompare;
        }
        int nameCompare = this.name.compareTo(o.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        return 0;
    }
}
