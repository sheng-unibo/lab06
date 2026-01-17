package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
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
        if ( !nodes.contains(node)) {
            edges.put(node,new HashSet<>());
        }
        return;
    }

    @Override
    public void addEdge(N source, N target) {
        if (nodeExist(source, target)) {
            edges.get(source).add(target);
        }
    }

    private boolean nodeExist(final N... nodes) {
        for(final N node : nodes) {
            if (!edges.containsValue(node)) {
                throw new IllegalArgumentException("No such node" + node);
            }
        }
        return true;
    }

    @Override
    public Set nodeSet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nodeSet'");
    }

    @Override
    public Set linkedNodes(N node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linkedNodes'");
    }

    @Override
    public List getPath(N source, N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }

}
