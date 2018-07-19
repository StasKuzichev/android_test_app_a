import java.util.ArrayList;
import java.util.Arrays;

public class SortLinks {
    public ArrayList<Link> linksArrayList = new ArrayList<>();                          //Список отсортированных ссылок на выход(требуется прямое обращение)
    SortLinks(ArrayList<Link> linksal, boolean sort_switch){                            //sort_switch переключает сортировку: true - по статусу, false - по дате
        Link[] links = new Link[linksal.size()];
        links = linksal.toArray(links);                                                 //ArrayList => массив
        if(sort_switch){
            Arrays.sort(links, new ComparatorByDate());                                 //Отсортировать по дате
        }else{
            Arrays.sort(links, new ComparatorByStatus());                               //Отсортировать по статусу
        }
        for (Link link:links) {
           linksArrayList.add(link);
        }
    }
}
