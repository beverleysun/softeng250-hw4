package src.hw4;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs a topological sort on a graph
 */
public class TopologicalSort {
    private final List<List<Integer>> _inDegree;
    private final List<Integer> _candidates = new ArrayList<Integer>();
    private final List<Integer> _topologicalOrder = new ArrayList<Integer>();
    private final boolean[] _added;

    private final int _numVertices;

    public TopologicalSort(AdjacencyList adjList) {
        _inDegree = adjList.getInDegree();
        _numVertices = adjList.getNumVertices();
        _added = new boolean[_numVertices];
        performSort();
    }

    private void performSort(){

        /* Will get topological order. If vertices have same layer, they will be numerically sorted
           because we go through the vertices in order each time. */
        while(_topologicalOrder.size() < _numVertices){

            // Find all vertices with no incoming edges
            for(int i = 0; i < _inDegree.size(); i++) {
                List<Integer> vertexList = _inDegree.get(i); // Get the adjacency list of the vertex i
                if (vertexList.isEmpty() && !_added[i]) { // If empty, means the vertex has no incoming edges
                    _added[i] = true;
                    _topologicalOrder.add(i);
                    _candidates.add(i);
                }
            }

            // Removed the vertices that have no incoming edges from the _inDegree list
            for (int vertex: _candidates) {
                for (List<Integer> otherVertexList : _inDegree) {
                    otherVertexList.remove((Integer)vertex);
                }
            }
            _candidates.clear();
        }
    }

    public String getTopOrderStr(){
        StringBuilder str = new StringBuilder();
        for (int vertex: _topologicalOrder) {
            str.append(vertex).append(" ");
        }
        return str.toString().trim();
    }
}
