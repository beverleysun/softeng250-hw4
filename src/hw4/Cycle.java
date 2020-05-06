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

    public Cycle (Stack<Integer> stack) {
        _cycle = new ArrayList<Integer>(stack);
        Collections.sort(_cycle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cycle cycle = (Cycle) o;
        if (this._cycle.size() != cycle._cycle.size()) {
            return false;
        } else {
            for (int i = 0; i < this._cycle.size(); i++) {
                if (this._cycle.get(i) != cycle._cycle.get(i)) {
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
