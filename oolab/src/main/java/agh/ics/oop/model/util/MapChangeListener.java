package agh.ics.oop.model.util;

import agh.ics.oop.model.WorldMap;

import java.util.Observable;
import java.util.Observer;

public interface MapChangeListener {
    void mapChanged(WorldMap map, String message);
}
