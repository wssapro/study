package cn.ws.dataStructure.graph.adjacencyMatrix;

/**
 * @author wangshun
 * @date 2019/3/29 8:49
 */
public class Vertex {
    private String value;
    public boolean visited;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Vertex(String value) {
        super();
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
