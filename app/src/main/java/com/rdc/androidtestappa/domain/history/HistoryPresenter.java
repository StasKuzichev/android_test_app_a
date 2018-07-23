package com.rdc.androidtestappa.domain.history;

import com.rdc.androidtestappa.Link;
import com.rdc.androidtestappa.utils.ComparatorByDate;
import com.rdc.androidtestappa.utils.ComparatorByStatus;

import java.util.Arrays;

public class HistoryPresenter implements HistoryContract.Presenter {
    private HistoryTab historyTab = new HistoryTab();

    public void setInitialData() {

        historyTab.links.add(new Link(1, "https://ru.stackoverflow.com/questions/470518/%D0%92-%D1%82%D0%B5%D0%BA%D1%81%D1%82-%D0%B2-textview-%D0%BF%D0%BE-%D1%83%D0%BC%D0%BE%D0%BB%D1%87%D0%B0%D0%BD%D0%B8%D1%8E-%D0%B8%D0%B4%D0%B5%D1%82-%D0%B2%D1%8B%D1%80%D0%B0%D0%B2%D0%BD%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%82%D0%B5%D0%BA%D1%81%D1%82%D0%B0-%D0%BF%D0%BE-%D0%BB%D0%B5%D0%B2%D0%BE%D0%BC%D1%83-%D0%BA%D1%80%D0%B0%D1%8E-%D0%9A%D0%B0%D0%BA-%D0%B2%D1%8B%D1%80", 0));
        historyTab.links.add(new Link(2, "https://ru.stackoverflow.com/questions/470518/%D0%92-%D1%82%D0%B5%D0%BA%D1%81%D1%82-%D0%B2-textview-%D0%BF%D0%BE-%D1%83%D0%BC%D0%BE%D0%BB%D1%87%D0%B0%D0%BD%D0%B8%D1%8E-%D0%B8%D0%B4%D0%B5%D1%82-%D0%B2%D1%8B%D1%80%D0%B0%D0%B2%D0%BD%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%82%D0%B5%D0%BA%D1%81%D1%82%D0%B0-%D0%BF%D0%BE-%D0%BB%D0%B5%D0%B2%D0%BE%D0%BC%D1%83-%D0%BA%D1%80%D0%B0%D1%8E-%D0%9A%D0%B0%D0%BA-%D0%B2%D1%8B%D1%80", 2));
        historyTab.links.add(new Link(3, "00000", 2));
        historyTab.links.add(new Link(5, "google2", 1));
        historyTab.links.add(new Link(6, "google3", 1));
        historyTab.links.add(new Link(7, "google4", 0));
        historyTab.links.add(new Link(8, "http://ptolmachev.ru/wp-content/uploads/2017/02/%D0%A1%D0%B8%D0%BC%D0%BF%D1%81%D0%BD%D1%8B.jpg", 0));

    }

    public void sort(boolean b) {
        Link[] linksArray = new Link[historyTab.links.size()];
        linksArray = historyTab.links.toArray(linksArray);
        if (b) {
            Arrays.sort(linksArray, new ComparatorByDate());

        } else {
            Arrays.sort(linksArray, new ComparatorByStatus());
        }
        historyTab.links.clear();
        historyTab.links.addAll(Arrays.asList(linksArray));
        historyTab.adapter.notifyDataSetChanged();

    }

}
