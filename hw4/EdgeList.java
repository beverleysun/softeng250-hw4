package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads from a text file of edges and puts each edge into and inDegree list and outDegree list
 * See more info on the contents of the text file in hw4.pdf
 */
public class EdgeList {

    List<List<Integer>> _inDegree = new ArrayList<List<Integer>>();
    List<List<Integer>> _outDegree = new ArrayList<List<Integer>>();

    int _numVertices;

    public EdgeList(String fileName) throws FileNotFoundException{

        File input = new File(fileName);
        Scanner readFile = new Scanner(input);
        _numVertices = Integer.parseInt(readFile.nextLine());

        // new array list for each vertex in the graph
        for (int i = 0; i < _numVertices; i++) {
            _inDegree.add(new ArrayList<Integer>());
            _outDegree.add(new ArrayList<Integer>());
        }


        // adds edges to the lists where an edge starts from vOrigin and ends at vDestination
        while (readFile.hasNextLine()){
            String pair = readFile.nextLine();
            int vOrigin = Integer.parseInt(pair.substring(0,1));
            int vDestination = Integer.parseInt(pair.substring(2));

            _inDegree.get(vDestination).add(vOrigin);
            _outDegree.get(vOrigin).add(vDestination);
        }
        readFile.close();
    }
}
