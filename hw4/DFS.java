package hw4;

import java.util.*;

public class DFS {

    private List<List<Integer>> _outDegree;
    private boolean[] _visited;
    private int _startVertex;
    private Stack<Integer> _dfsTreeStack = new Stack<Integer>();
    private Set<Cycle> _cycles = new HashSet<Cycle>();
    private int _numCycles;

    public DFS(AdjacencyList adjList, int startVertex){
        _outDegree = adjList.getOutDegree();
        _visited = new boolean[adjList.getNumVertices()];
        _startVertex = startVertex;

        performCycleSearch(startVertex);
    }

    private void performCycleSearch (int startVertex) {
        _visited[startVertex] = true;
        _dfsTreeStack.push(startVertex);

        // Check edges of the start vertex
        for (int vertexConnected : _outDegree.get(startVertex)) {

            // means there is a cycle going back to the _startVertex
            if (vertexConnected == _startVertex) {
                _numCycles++;
                _cycles.add(new Cycle(_dfsTreeStack));
            }

            // Check if vertex has been visited
            if (!_visited[vertexConnected]){
                performCycleSearch(vertexConnected);
            }
        }
        _dfsTreeStack.pop();
    }
    public int getNumCycles () {
        return _numCycles;
    }

    public Set<Cycle> getCycleSet() {
        return _cycles;
    }
}
