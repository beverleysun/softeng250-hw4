package src.hw4;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

/**
 * Performs a DFS search for cycles in a tree
 */
public class DFS {
    private final List<List<Integer>> _outDegree;
    private final Stack<Integer> _dfsTreeStack = new Stack<Integer>();
    private final Set<Cycle> _cycles = new HashSet<Cycle>();
    private final boolean[] _visited;
    private final int _numCycles;
    private int _startVertex;

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
