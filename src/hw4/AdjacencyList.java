package src.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads from a text file of edges and puts each edge into and inDegree list and outDegree list
 * See more info on the contents of the text file in hw4.pdf
 */
public class AdjacencyList {

    private final List<LinkedList<Integer>> _inDegree = new ArrayList<LinkedList<Integer>>();
    private final List<LinkedList<Integer>> _outDegree = new ArrayList<LinkedList<Integer>>();

    int _numVertices;

    public AdjacencyList(String fileName){
        File input = new File(fileName);
        Scanner readFile = null;

        try {
            readFile = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
            System.exit(0);
        }

        _numVertices = Integer.parseInt(readFile.nextLine());
        constructList(readFile);
        readFile.close();
    }

    private void constructList(Scanner readFile) {
        // New array list for each vertex in the graph
        for (int i = 0; i < _numVertices; i++) {
            _inDegree.add(new LinkedList<Integer>());
            _outDegree.add(new LinkedList<Integer>());
        }

        // Adds edges to the lists where an edge starts from vOrigin and ends at vDestination
        while (readFile.hasNextLine()){
            String pair = readFile.nextLine();
            int vOrigin = Integer.parseInt(pair.substring(0,1));
            int vDestination = Integer.parseInt(pair.substring(2));

            _inDegree.get(vDestination).add(vOrigin);
            _outDegree.get(vOrigin).add(vDestination);
        }
    }

    public List<Integer> sameInOut () {
        List<Integer> sameInOut = new ArrayList<Integer>();

        for (int i = 0; i < _numVertices; i++) {
            if (_inDegree.get(i).size() == _outDegree.get(i).size()) {
                sameInOut.add(i);
            }
        }
        return sameInOut;
    }

    public List<Double> averageInOut () {
        double sumIn = 0;
        double sumOut = 0;
        List<Double> averageInOut = new ArrayList<Double>();

        for (List<Integer> list: _inDegree){
            sumIn += list.size();
        }

        for (List<Integer> list: _outDegree){
            sumOut += list.size();
        }

        double avIn = sumIn/_numVertices;
        double avOut = sumOut/_numVertices;

        averageInOut.add(avIn);
        averageInOut.add(avOut);

        return averageInOut;
    }

    public List<LinkedList<Integer>> getOutDegree() {
        return new ArrayList<LinkedList<Integer>>(_outDegree);
    }

    public List<LinkedList<Integer>> getInDegree() {
        return new ArrayList<LinkedList<Integer>>(_inDegree);
    }

    public int getNumVertices() {
        return _numVertices;
    }
}
