package com.rdc.androidtestappa.utils;

import com.rdc.androidtestappa.utils.ComparatorByDate;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComparatorByDateTest {

        @Test
        public void compare() {
            ComparatorByDate cbd = new ComparatorByDate();
            Link link1 = new Link(199, "url11", 2, new Date(2016, 5, 23, 12, 12, 25));
            try {
                wait(2000);
            } catch (Exception e) {
            }
            Link link2 = new Link(13, "url12", 0, new Date(2016, 5, 23, 12, 12, 27));
            try {
                wait(2000);
            } catch (Exception e) {
            }
            int f12 = cbd.compare(link1, link2);
            boolean result1 = f12 > 0;
            boolean expected1 = false;
            assertEquals(expected1, result1);

            List<Link> links = new ArrayList<Link>();
            links.add(link1);                                                   //id 199
            links.add(new Link(115, "url13", 2, new Date(2020, 5, 23, 12, 12, 27)));       //id 115
            links.add(link2);                                                   //id 13
            Collections.sort(links, cbd);
            int resultFirst = links.get(0).getId();
            int resultSecond = links.get(1).getId();
            int resultThird = links.get(2).getId();
            int expectedFirst = 199;
            int expectedSecond = 13;
            int expectedThird = 115;
            assertEquals(expectedFirst, resultFirst);
            assertEquals(expectedSecond, resultSecond);
            assertEquals(expectedThird, resultThird);
        }
    }
