package ru.kpfu.itis.group11408.zakirov.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anvar on 20.04.2015.
 */
public class Graph <T> {
    private Map<Vedge<T>, List<Vedge<T>>> links;

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        Vedge<String>[] vedges = new Vedge[]{
                new Vedge("Anvar"),
                new Vedge("Nail"),
                new Vedge("Sabina"),
                new Vedge("Safina")
        };
        graph.addVedge(vedges[0]);
        graph.addVedge(vedges[1]);
        graph.addVedge(vedges[2]);
        graph.addVedge(vedges[3]);
        graph.link(vedges[0], vedges[1]);
        System.out.println(graph.hasLinked(vedges[0], vedges[1]));
        System.out.println(graph.hasLinked(vedges[2], vedges[3]));
        graph.unlink(vedges[0], vedges[1]);
        System.out.println(graph.hasLinked(vedges[0], vedges[1]));
        graph.link(vedges[0], vedges[1]);
        graph.removeVedge(vedges[0]);
        System.out.println(graph.hasLinked(vedges[0], vedges[1]));
    }

    public Graph(){
        this.links = new HashMap<>();
    }

    public void addVedge(Vedge<T> vedge){
        if (links.containsKey(vedge))
            return;
        links.put(vedge, new ArrayList<Vedge<T>>());
    }

    public boolean link(Vedge<T> v1, Vedge<T> v2){
        if (!links.containsKey(v1) || !links.containsKey(v2))
            return false;

        links.get(v1).add(v2);
        links.get(v2).add(v1);
        return true;
    }

    public boolean unlink(Vedge<T> v1, Vedge<T> v2){
        if (!links.containsKey(v1) || !links.containsKey(v2))
            return false;

        links.get(v1).remove(v2);
        links.get(v2).remove(v1);
        return true;
    }

    public void removeVedge(Vedge<T> vedge){
        links.remove(vedge);
    }

    public boolean hasLinked(Vedge<T> v1, Vedge<T> v2){
        if (!links.containsKey(v1) || !links.containsKey(v2))
            return false;

        return (links.get(v1).contains(v2) && links.get(v2).contains(v1));
    }
}
