package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ItemPredicateBuilder {

    // можно и филды финальные


    public List<Predicate<Item>> getCoolPredicates(Item other) {
        List<Predicate<Item>> predicateList = new ArrayList();
        predicateList.add(namePredicate());
        colorFilter().apply(other).and(nameFilter().apply(other));
        return predicateList;
    }

    private final Function<Item, Predicate<Item>> colorFilter() {
        return other -> item -> item.getColor().equals(other.getColor());
    }

    private final Function<Item, Predicate<Item>> nameFilter() {
        return other -> item -> item.getName().equals(other.getName());
    }

    private final Predicate<Item> namePredicate() {
        return item -> item.getName().equals("Volodya");
    }

    public ItemPredicateBuilder() {
    }
}
