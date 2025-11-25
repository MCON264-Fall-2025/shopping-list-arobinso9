package exercises.shopping_app;

import edu.touro.mcon264.apps.collections.ArrayBasedList;
import edu.touro.mcon264.apps.collections.LinkedBasedList;
import edu.touro.mcon264.apps.collections.ListInterface;

import javax.swing.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Creates a ListInterface<ShoppingItem> instance.
 * Has a main method that runs a console application.
 * Provides a simple text-based menu to:
 * Add items (in sorted order).
 * View the current list.
 * “Shop” the next item on the list.
 * Exit the program.
 */
public class ShoppingListApp {
    public static void main(String[] args) {
        //TODO
        ListInterface<ShoppingItem> shoppingList;
        // Option 1:
        shoppingList = new ArrayBasedList<>();
        // Option 2:
        shoppingList = new LinkedBasedList<>();
        Scanner sc = new Scanner(System.in);
        menu();
        int option= sc.nextInt();
        while(option!=4){
            switch(option){
                case 1:
                    System.out.println("Enter aisle name of item");
                    String aisleName = sc.next();
                    System.out.println("Enter name of item");
                    String itemName = sc.next();
                    insertSorted(shoppingList, new ShoppingItem(aisleName,itemName));
                    break;
                case 2:
                    printList(shoppingList);
                    break;
                case 3:
                    ShoppingItem next = shopNext(shoppingList);
                    if (next == null) {
                        System.out.println("All done! No items left to shop.");
                    } else {
                        System.out.println("Next item to buy: " + next);
                    }
                    break;
            }
        }
    }
    private static void menu(){
        System.out.println("Enter an option");
        System.out.println("1. Add Shopping Item");
        System.out.println("2. Show Current Shopping list");
        System.out.println("3. Shop next item");
        System.out.println("4. Exit");
    }

    /**
     * Inserts the given item into the list so that the list remains sorted
     * by aisle and then item name.
     */
    public static void insertSorted(ListInterface<ShoppingItem> list, ShoppingItem item) {
        // TODO: implement using list.get(i), list.add(i, item), list.size()
        for(int i=0;i<list.size();i++){
            ShoppingItem current = list.get(i);
            if (item.compareTo(current) < 0) {
                list.add(i, item);
                return;
            }
        }
        list.add(list.size(), item);

    }
    /**
     * Returns the "next" item to shop and removes it from the list.
     * If the list is empty, returns null.
     */
    public static ShoppingItem shopNext(ListInterface<ShoppingItem> list) {
        // TODO: implement using ListInterface methods

        if( list.size()==0){
            return null;
        }
        ShoppingItem next = list.get(0);
        list.remove(0);
        return next;
    }
    private static void printList(ListInterface<ShoppingItem> list) {
        Iterator<ShoppingItem> iterator = list.iterator();
        while(iterator.hasNext()){
           System.out.println(iterator.next());
        }



        }
    }



