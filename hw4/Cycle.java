package hw4;

import java.util.*;

public class Cycle {

    private List<Integer> _cycleList;
    public Cycle (Stack<Integer> stack) {
        _cycleList = new ArrayList<Integer>(stack);
        Collections.sort(_cycleList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cycle cycle = (Cycle) o;
        if (this._cycleList.size() != cycle._cycleList.size()) {
            return false;
        } else {
            for (int i = 0; i < this._cycleList.size(); i++) {
                if (this._cycleList.get(i) != cycle._cycleList.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(_cycleList);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Integer integer : _cycleList) {
            str.append(integer + " ");
        }

        return str.toString().trim();
    }
}
