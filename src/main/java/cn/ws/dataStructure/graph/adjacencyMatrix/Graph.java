package cn.ws.dataStructure.graph.adjacencyMatrix;

/**
 * @author wangshun
 * @date 2019/3/29 8:49
 */
public class Graph {
    Vertex[] vertex;
    int currentSize;
    int adjMat[][];


    public Graph(int size) {
        vertex = new Vertex[size];
        adjMat = new int[size][size];
    }
    public void addVertex(Vertex v){
        vertex[currentSize++] = v;
    }
    public void addEdge(String v1,String v2){
        int index1=-1;
        int index2=-1;
        for (int i = 0; i < vertex.length; i++) {
            if(vertex[i].getValue().equals(v1)){
                index1=i;
            }
        }
        for (int i = 0; i < vertex.length; i++) {
            if(vertex[i].getValue().equals(v2)){
                index2=i;
            }
        }
        if(index1>-1&&index2>-1){
            adjMat[index1][index2]=1;
            adjMat[index2][index1]=1;
        }
    }
}
