import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nodes = new int[11];
		for(int i=1 ; i<11 ; i++) {
			nodes[i] = i;
		}

		union(nodes, 1, 2);
		union(nodes, 2, 3);
		union(nodes, 3, 4);
		union(nodes, 5, 6);
		union(nodes, 6, 7);
		union(nodes, 7, 8);
		union(nodes, 8, 9);
		union(nodes, 9, 10);

		System.out.println("1 and 4 is connected? = " + find(nodes, 1, 4));
		System.out.println("3 and 9 is connected? = " + find(nodes, 3, 9));
		union(nodes, 4, 5);
		System.out.println("3 and 9 is connected? = " + find(nodes, 3, 9));

    }

    private static int getParent(int[] nodes, int node) {
        if(nodes[node] == node) {
            return node;
        }
        return nodes[node] = getParent(nodes, nodes[node]);
    }

    private static void union(int[] nodes, int nodeA, int nodeB) {
        int parentOfNodeA = getParent(nodes, nodeA);
        int parentOfNodeB = getParent(nodes, nodeB);
        if(parentOfNodeA < parentOfNodeB) {
            nodes[parentOfNodeB] = parentOfNodeA;
        } else {
            nodes[parentOfNodeA] = parentOfNodeB;
        }
    }

    private static boolean find(int[] nodes, int nodeA, int nodeB) {
        return getParent(nodes, nodeA) == getParent(nodes, nodeB);
    }
}