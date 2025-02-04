package org.example.Tests.test1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public int solution(Pizza[] menu, OrderItem[] order){
        int result =withoutDiscount(order,menu);
        result= Math.min(result,afterDiscountOne(menu,order));
        result = Math.min(result,afterDiscountTwo(menu,order));
        result = Math.min(result,afterDiscountThree(menu,order));
        result = Math.min(result,afterDiscountFour(menu,order));
        return result;
    }

    public int sum (List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public Pizza fetchPizzaFromMenu(Pizza[] menu , String name){
        for(Pizza pizza : menu){
            if(pizza.name.equals(name)){
                return pizza;
            }
        }
        return null;
    }

    public  int withoutDiscount(OrderItem[] order, Pizza[]menu){
        List<Integer> list = fetchPricesInList(order,menu);
        return sum(list);
    }

    public List<Integer> fetchPricesInList(OrderItem[] order, Pizza[]menu){
        List<Integer> result = new ArrayList<>();

        for(OrderItem orderItem : order){

            String name = orderItem.name;
            int quantity = orderItem.quantity;
            String size = orderItem.size;

            Pizza pizza = fetchPizzaFromMenu(menu,name);

            int price = 0;
            if(size.equals("Small")) price = pizza.price_S;
            if(size.equals("Medium")) price = pizza.price_M;
            if(size.equals("Large")) price  = pizza.price_L;

            for (int i = 0; i < quantity; i++) {
                result.add(price);
            }

        }

        return result;
    }
    public int afterDiscountOne(Pizza[] menu, OrderItem[] order){
        boolean flag = false;
        int noOfPizzas =0;
        for(OrderItem item: order){
            noOfPizzas+=item.quantity;
            if(noOfPizzas>=3) {
                flag =true;
                break;
            }
        }

        if(!flag){
            return withoutDiscount(order,menu); // since this discount not possible
        }

        List<Integer> listOfPrices = fetchPricesInList(order,menu);
        int thirdHighestPrice = listOfPrices.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(0);
        int sumOfAllPrices = sum(listOfPrices);
        return sumOfAllPrices-thirdHighestPrice;

    }


    public int afterDiscountTwo(Pizza[] menu, OrderItem[] order){

        Map<String, List<Integer>> map = Arrays.stream(order)
                .collect(Collectors.groupingBy(
                        orderItem -> orderItem.name,
                        Collectors.flatMapping(
                                orderItem -> {
                                    Pizza pizza = fetchPizzaFromMenu(menu, orderItem.name);
                                    if (pizza != null) {
                                        int price = switch (orderItem.size) {
                                            case "Small" -> pizza.price_S;
                                            case "Medium" -> pizza.price_M;
                                            case "Large" -> pizza.price_L;
                                            default -> 0;
                                        };
                                        // Create a stream of the price repeates for the quantity of the item
                                        return IntStream.generate(() -> price)
                                                .limit(orderItem.quantity)
                                                .boxed();
                                    }
                                    return Stream.empty(); // In case pizza is not found, return empty stream
                                },
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list->list.stream().sorted(Comparator.reverseOrder()).limit(5).toList()
                                )
                        )
                ));

        int maxSum = map.values().stream()
                .filter(list -> list.size() >= 5)
                .mapToInt(list -> list.stream().limit(5).mapToInt(Integer::intValue).sum())
                .max()
                .orElse(0);

        int sumOfAllPrices = withoutDiscount(order,menu);

        return sumOfAllPrices-maxSum+100;

    }

    public int afterDiscountThree(Pizza[] menu, OrderItem[] order){

        Map<String,Integer> largePizzaQuantityMap =
                Arrays.stream(order).filter(orderItem -> orderItem.size.equals("Large"))
                        .collect(Collectors.groupingBy(
                                orderItem -> orderItem.name,
                                Collectors.summingInt(orderItem->orderItem.quantity)
                        ));

        Map<String,Integer> smallPizzaQuantityMap =
                Arrays.stream(order).filter(orderItem -> orderItem.size.equals("Small"))
                        .collect(Collectors.groupingBy(
                                orderItem -> orderItem.name,
                                Collectors.summingInt(orderItem->orderItem.quantity)
                        ));

        int priceToBeReduced = smallPizzaQuantityMap.entrySet().stream()
                .filter(entry -> largePizzaQuantityMap.containsKey(entry.getKey()))
                .mapToInt(entry -> {
                    String pizzaName = entry.getKey();
                    int smallQuantity = entry.getValue();
                    int largeQuantity = largePizzaQuantityMap.get(pizzaName);
                    int freePizzas = Math.min(smallQuantity, largeQuantity);

                    Pizza pizza = fetchPizzaFromMenu(menu, pizzaName);
                    return freePizzas * pizza.price_S;
                })
                .sum();

        int sumOfAllPrices = withoutDiscount(order,menu);

        return sumOfAllPrices-priceToBeReduced;

    }

    public int afterDiscountFour(Pizza[] menu, OrderItem[] order){

        List<Integer> priceDifferences = Arrays.stream(order)
                .filter(orderItem -> orderItem.size.equals("Large"))
                .flatMap(orderItem -> {
                    Pizza pizza = fetchPizzaFromMenu(menu, orderItem.name);
                    if (pizza != null && pizza.price_L > pizza.price_M) {
                        int priceDifference = pizza.price_L - pizza.price_M;
                        return IntStream.range(0, orderItem.quantity)
                                .mapToObj(i -> priceDifference);
                    }
                    return Stream.empty();
                })
                .toList();


        int discount = priceDifferences.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();

        int sumOfAllPrices = withoutDiscount(order,menu);

        return sumOfAllPrices-discount;
    }

}
