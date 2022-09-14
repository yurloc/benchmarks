package io.github.yurloc.benchmarks;

import java.util.ArrayList;
import java.util.List;

public final class ListUtils {

    public static <T> List<T> copyAndReverse(List<T> leftSubListView) {
        ArrayList<T> copy = new ArrayList<>(leftSubListView.size());
        for (int i = leftSubListView.size() - 1; i >= 0; i--) {
            copy.add(leftSubListView.get(i));
        }
        return copy;
    }

    private ListUtils() {
    }
}
