package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    
    private final Set<N> nodes;
    private final Map<N, Set<N>> edges;

    public GraphImpl() {
        nodes = new HashSet<>();
        edges = new HashMap<>();
    }

    @Override
    public void addNode(final N node) {
        if ( node != null && !nodes.contains(node)) {
            nodes.add(node);
            edges.put(node,new HashSet<>());
        }
        return;
    }

    @Override
    public void addEdge(N source, N target) {
        if (source == null || target == null) {
            return;
        }

        if(edges.containsKey(source) && edges.containsKey(target)) {
            edges.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(nodes);
    }

    @Override
    public Set<N> linkedNodes(N node) {
        if(edges.containsKey(node)) {
            return new HashSet<>(edges.get(node));
        }
        return new HashSet<>();
    }

    @Override
    public List<N> getPath(N source, N target) {
        List<N> path = new LinkedList<>();

        if(!edges.containsKey(source) || !edges.containsKey(target)) {
            return new LinkedList<>();
        }

        Set<N> visited = new HashSet<>();

        if(dfs(source, target, visited, path)) {
            return new LinkedList<>(path);
        }
        return new LinkedList<>(path);
    }

    private boolean dfs(
        final N current,
        final N target, 
        final Set<N> visited,
        final List<N> path
        ) {
        
        visited.add(current);
        path.add(current);

        if(current.equals(target)) {
            return true;
        }

        for(N next : this.nodeSet()) {
            if(!visited.contains(next)) {
                if(dfs(next, target, visited, path)) {
                    return true;
                }
            }
        }
        
        path.remove(path.size() - 1);
        return false;
        }
}
