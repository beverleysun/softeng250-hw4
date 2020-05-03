package hw4;

import java.util.*;

/**
 * Performs a DFS search for cycles in a tree
 */
public class DFS {
    private List<List<Integer>> _outDegree;
    private Stack<Integer> _dfsTreeStack = new Stack<Integer>();
    private Set<Cycle> _cycles = new HashSet<Cycle>();
    private int _numCycles;
    private int _startVertex;
    private boolean[] _visited;

    public DFS(AdjacencyList adjList){
        _outDegree = adjList.getOutDegree();
        _visited = new boolean[adjList.getNumVertices()];

        for (int i = 0; i < adjList.getNumVertices(); i++){
            _startVertex = i;
            performCycleSearch(i);
        }
        _numCycles = _cycles.size();
    }

    private void performCycleSearch (int startVertex) {
        _visited[startVertex] = true;
        _dfsTreeStack.push(startVertex);

        // Check edges of the start vertex
        for (int vertexConnected : _outDegree.get(startVertex)) {

            // means there is a cycle going back to the _startVertex
            if (vertexConnected == _startVertex) {
                _cycles.add(new Cycle(_dfsTreeStack));
            }

            // Check if vertex has been visited
            if (!_visited[vertexConnected]){
                performCycleSearch(vertexConnected);
            }
        }
        _dfsTreeStack.pop(); // Remove vertex from stack when all edges have been checked
    }
    public int getNumCycles () {
        return _numCycles;
    }

    public String getOneCycleStr() {
        List<Cycle> cycles = new ArrayList<Cycle>(_cycles);
        return cycles.get(0).toString();

    }
}
