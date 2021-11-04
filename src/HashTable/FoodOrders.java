package HashTable;

import java.util.*;

/**
 * Given the array orders, which represents the orders that customers have done in a restaurant.
 * More specifically orders[i]=[customerName_i,tableNumber_i,foodItem_i] where
 *  customerName_i is the name of the customer,
 *  tableNumber_i is the table customer sit at,
 *  and foodItem_i is the item customer orders.
 *
 * Return the restaurant's “display table”. The “display table” is a table whose row entries denote how many of each food item each table ordered.
 * The first column is the table number and the remaining columns correspond to each food item in alphabetical order.
 * The first row should be a header whose first column is “Table”, followed by the names of the food items.
 * Note that the customer names are not part of the table.
 * Additionally, the rows should be sorted in numerically increasing order.
 */

/*
Input: orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]

Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
Output: [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 */

public class FoodOrders {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Given the orders:");
        String orderString = scanner.nextLine();
        orderString = orderString.substring(2,orderString.length()-2);
        String[] orders = orderString.split("],\\[");
        List<List<String>> orderList = new ArrayList<>();
        for (String s : orders) {
            String[] order = s.replace("\"","").split(",");
            List<String> orderDetail= Arrays.asList(order);
            orderList.add(orderDetail);
        }
        FoodOrders foodOrders = new FoodOrders();
        List<List<String>> res = foodOrders.displayTable(orderList);
        System.out.println(res.toString());
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, TreeMap<String, Integer>> orderTreeMap = new TreeMap<>();
        TreeMap<String, Integer> foods = new TreeMap<>();
        for (List<String> order : orders) {
            if (!foods.containsKey(order.get(2))){
                foods.put(order.get(2), 0);
            }
        }
        for (List<String> order : orders) {
            Integer tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            TreeMap<String, Integer> tableItem = orderTreeMap.getOrDefault(tableNumber, new TreeMap<>(foods));
            System.out.println(tableItem.toString());
            tableItem.put(foodItem, tableItem.get(foodItem) + 1);
            orderTreeMap.put(tableNumber, tableItem);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> tableHeader = new ArrayList<>();
        tableHeader.add("Table");
        tableHeader.addAll(foods.keySet());
        res.add(tableHeader);
        for (Map.Entry<Integer, TreeMap<String, Integer>> entry : orderTreeMap.entrySet()){
            List<String> tableItem = new ArrayList<>();
            tableItem.add(entry.getKey().toString());
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                tableItem.add(entry1.getValue().toString());
            }
            res.add(tableItem);
        }
        return res;
    }
}
