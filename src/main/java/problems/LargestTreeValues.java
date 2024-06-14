package problems;

import dataStructures.Tree;

import java.util.ArrayList;
import java.util.List;

public class LargestTreeValues {
    public static List<Integer> largestValues(Tree tree) {
        var list = new ArrayList<Integer>();
        solveTree(tree.root, 0, list);

        return list;
    }

    private static void solveTree(
        Tree.Node node,
        int level,
        ArrayList<Integer> list
    ) {
        if (node == null) return;

        if (level == list.size()) {
            list.add(node.value);
        } else {
            list.set(level, Math.max(list.get(level), node.value));
        }

        solveTree(node.left, level + 1, list);
        solveTree(node.right, level + 1, list);
    }
}
