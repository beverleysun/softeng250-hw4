package src.hw4;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.util.Objects;

/**
 * Represents one cycle of a graph
 */
public class Cycle {
    private final List<Integer> _cycle;
    private final List<Integer> _sortedCycle;

    public Cycle (Stack<Integer> stack) {
        _cycle = new ArrayList<Integer>(stack);
        _sortedCycle = new ArrayList<Integer>(stack);
        Collections.sort(_sortedCycle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cycle otherCycle = (Cycle) o;
        if (this._sortedCycle.size() != otherCycle._sortedCycle.size()) {
            return false;
        } else {
            for (int i = 0; i < this._sortedCycle.size(); i++) {
                if (this._sortedCycle.get(i) != otherCycle._sortedCycle.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(_cycle);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Integer integer : _cycle) {
            str.append(integer + " ");
        }

        return str.toString().trim();
    }
}
