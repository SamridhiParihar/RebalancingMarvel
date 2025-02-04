package org.example.Tests.test1;



import java.util.*;


// just with normal for loops
public class Main2 {
    public int solution(Pizza[] menu, OrderItem[] order) {
        int result = withoutDiscount(order, menu);
        result = Math.min(result, afterDiscountOne(menu, order));
        result = Math.min(result, afterDiscountTwo(menu, order));
        result = Math.min(result, afterDiscountThree(menu, order));
        result = Math.min(result, afterDiscountFour(menu, order));
        return result;
    }

    public int sum(List<Integer> list) {
        int total = 0;
        for (int value : list) {
            total += value;
        }
        return total;
    }

    public Pizza fetchPizzaFromMenu(Pizza[] menu, String name) {
        for (Pizza pizza : menu) {
            if (pizza.name.equals(name)) {
                return pizza;
            }
        }
        return null;
    }

    public int withoutDiscount(OrderItem[] order, Pizza[] menu) {
        List<Integer> list = fetchPricesInList(order, menu);
        return sum(list);
    }

    public List<Integer> fetchPricesInList(OrderItem[] order, Pizza[] menu) {
        List<Integer> result = new ArrayList<>();

        for (OrderItem orderItem : order) {
            String name = orderItem.name;
            int quantity = orderItem.quantity;
            String size = orderItem.size;

            Pizza pizza = fetchPizzaFromMenu(menu, name);

            int price = 0;
            if (size.equals("Small")) price = pizza.price_S;
            if (size.equals("Medium")) price = pizza.price_M;
            if (size.equals("Large")) price = pizza.price_L;

            for (int i = 0; i < quantity; i++) {
                result.add(price);
            }
        }

        return result;
    }

    public int afterDiscountOne(Pizza[] menu, OrderItem[] order) {
        boolean flag = false;
        int noOfPizzas = 0;
        for (OrderItem item : order) {
            noOfPizzas += item.quantity;
            if (noOfPizzas >= 3) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return withoutDiscount(order, menu); // since this discount not possible
        }

        List<Integer> listOfPrices = fetchPricesInList(order, menu);
        Collections.sort(listOfPrices, Collections.reverseOrder());
        int thirdHighestPrice = (listOfPrices.size() >= 3) ? listOfPrices.get(2) : 0;
        int sumOfAllPrices = sum(listOfPrices);
        return sumOfAllPrices - thirdHighestPrice;
    }

    public int afterDiscountTwo(Pizza[] menu, OrderItem[] order) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (OrderItem orderItem : order) {
            String name = orderItem.name;
            int quantity = orderItem.quantity;
            String size = orderItem.size;

            Pizza pizza = fetchPizzaFromMenu(menu, name);
            int price = 0;
            if (size.equals("Small")) price = pizza.price_S;
            if (size.equals("Medium")) price = pizza.price_M;
            if (size.equals("Large")) price = pizza.price_L;

            List<Integer> priceList = map.getOrDefault(name, new ArrayList<>());
            for (int i = 0; i < quantity; i++) {
                priceList.add(price);
            }
            map.put(name, priceList);
        }

        int maxSum = 0;
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> priceList = entry.getValue();
            if (priceList.size() >= 5) {
                Collections.sort(priceList, Collections.reverseOrder());
                int sum = 0;
                for (int i = 0; i < 5; i++) {
                    sum += priceList.get(i);
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        int sumOfAllPrices = withoutDiscount(order, menu);
        return sumOfAllPrices - maxSum + 100;
    }

    public int afterDiscountThree(Pizza[] menu, OrderItem[] order) {
        Map<String, Integer> largePizzaQuantityMap = new HashMap<>();
        Map<String, Integer> smallPizzaQuantityMap = new HashMap<>();

        for (OrderItem orderItem : order) {
            String name = orderItem.name;
            int quantity = orderItem.quantity;
            String size = orderItem.size;

            if (size.equals("Large")) {
                largePizzaQuantityMap.put(name, largePizzaQuantityMap.getOrDefault(name, 0) + quantity);
            } else if (size.equals("Small")) {
                smallPizzaQuantityMap.put(name, smallPizzaQuantityMap.getOrDefault(name, 0) + quantity);
            }
        }

        int priceToBeReduced = 0;
        for (Map.Entry<String, Integer> entry : smallPizzaQuantityMap.entrySet()) {
            String pizzaName = entry.getKey();
            if (largePizzaQuantityMap.containsKey(pizzaName)) {
                int smallQuantity = entry.getValue();
                int largeQuantity = largePizzaQuantityMap.get(pizzaName);
                int freePizzas = Math.min(smallQuantity, largeQuantity);

                Pizza pizza = fetchPizzaFromMenu(menu, pizzaName);
                priceToBeReduced += freePizzas * pizza.price_S;
            }
        }

        int sumOfAllPrices = withoutDiscount(order, menu);
        return sumOfAllPrices - priceToBeReduced;
    }

    public int afterDiscountFour(Pizza[] menu, OrderItem[] order) {
        List<Integer> priceDifferences = new ArrayList<>();

        for (OrderItem orderItem : order) {
            if (orderItem.size.equals("Large")) {
                Pizza pizza = fetchPizzaFromMenu(menu, orderItem.name);
                if (pizza != null && pizza.price_L > pizza.price_M) {
                    int priceDifference = pizza.price_L - pizza.price_M;
                    for (int i = 0; i < orderItem.quantity; i++) {
                        priceDifferences.add(priceDifference);
                    }
                }
            }
        }

        Collections.sort(priceDifferences, Collections.reverseOrder());
        int discount = 0;
        for (int i = 0; i < Math.min(3, priceDifferences.size()); i++) {
            discount += priceDifferences.get(i);
        }

        int sumOfAllPrices = withoutDiscount(order, menu);
        return sumOfAllPrices - discount;
    }
}

