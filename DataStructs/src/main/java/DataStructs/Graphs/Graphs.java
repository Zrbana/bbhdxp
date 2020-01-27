package DataStructs.Graphs;

import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;

public class Graphs {

    public static void main(String args[]) {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        assert graph.addEdge(1, 2);
        assert graph.addEdge(1, 5);
        assert graph.addEdge(2, 5);
        assert !graph.addEdge(1, 2);
        assert graph.addEdge(2, 3);
        assert graph.addEdge(3, 4);
        assert graph.addEdge(4, 1);
        assert !graph.addEdge(2, 3);
        System.out.println(graph);
    }

}

class AdjacencyListGraph<E extends Comparable<E>> {
    ArrayList<Vertex> vertices;

    private class Vertex {
        E data;
        ArrayList<Vertex> adjacentVerticies;

        public Vertex(E data) {
            adjacentVerticies = new ArrayList<>();
            this.data = data;
        }

        public boolean addAdjacentVertex(Vertex to) {
            for (Vertex v : adjacentVerticies) {
                if (v.data.compareTo(to.data) == 0) {
                    return false;
                }
            }
            return adjacentVerticies.add(to);
        }

        public boolean removeAdjacentVertex(E e) {

            for (int i = 0; i < adjacentVerticies.size(); i++) {
                if (adjacentVerticies.get(i).data.compareTo(e) == 0) {
                    adjacentVerticies.remove(i);

                    return true;
                }
            }
            return false;
        }


    }

    /**
     * 删除给定两个节点之间的连线
     *
     * @param from
     * @param to
     * @return
     */
    public boolean removeEdge(E from, E to) {
        Vertex fromV = null;
        for (Vertex v : vertices) {
            if (from.compareTo(v.data) == 0) {
                fromV = v;
                break;
            }
        }
        if (fromV == null)
            return false;
        return fromV.removeAdjacentVertex(to);
    }

    /**
     * 在两个特定的节点之间添加一条边
     *
     * @param from
     * @param to
     * @return
     */
    public boolean addEdge(E from, E to) {
        Vertex fromV = null;
        Vertex toV = null;
        for (Vertex v : vertices) {
            if (from.compareTo(v.data) == 0) {//起始节点是否存在
                fromV = v;
            } else if (to.compareTo(v.data) == 0) {//终止节点是否存在
                toV = v;
            }
            if (fromV != null && toV != null)
                break;//节点存在 停止搜索
        }
        if (fromV == null) {
            fromV = new Vertex(from);
            vertices.add(fromV);
        }
        if (toV == null) {
            toV = new Vertex(to);
            vertices.add(toV);
        }
        return fromV.addAdjacentVertex(toV);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : vertices) {
            sb.append("Vertex: ");
            sb.append(v.data);
            sb.append("\n");
            sb.append("Adjacent verticies: ");
            for (Vertex v2 : v.adjacentVerticies) {
                sb.append(v2.data);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}














