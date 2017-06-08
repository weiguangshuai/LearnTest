package com.cqupt.text.InnerClass.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weigs
 * @date 2017/6/8 0008
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

}
