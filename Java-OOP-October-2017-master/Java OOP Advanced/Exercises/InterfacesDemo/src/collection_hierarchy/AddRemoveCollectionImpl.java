package collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollectionImpl<T> implements AddRemoveCollection<T> {

    private List<T> elements;

    public AddRemoveCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    public int add(T element) {
        elements.add(0, element);
        return 0;
    }

    public T remove() {
        return this.elements.remove(this.elements.size() - 1);
    }
}
