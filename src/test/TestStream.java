package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();

        itemList.add(new Item("1", "a"));
        itemList.add(new Item("1", "a"));
        itemList.add(new Item("1", "a"));

        Item coolItem = new Item("1", "a");

        ItemPredicateBuilder builder = new ItemPredicateBuilder();
        List<Predicate<Item>> predicateList = builder.getCoolPredicates(coolItem);
        List<Predicate<Item>> predicateList2 = builder.getCoolPredicates(coolItem);

        List<Item> itemList2 = itemList.stream().filter(predicateList.get(0)).collect(Collectors.toList());

        List<Item> itemList3 = itemList.stream().filter(predicateList.get(0)).collect(Collectors.toList());

        System.out.println(itemList2);
    }
}
