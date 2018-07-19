import java.util.Comparator;

public class ComparatorByStatus implements Comparator {							//сортировка по статусу
    public int compare(Object o1, Object o2) {
        return ((Link)o1).GetStatus() - ((Link)o2).GetStatus();
    }
}
