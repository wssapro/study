package cn.ws.dataStructure.graph.udn;

/**
 * @author wangshun
 * @date 2019/3/15 23:53
 */
public class AMGraph {

    public String vexs[] = new String[32767];
    public int arcs[][] = new int[100][100];
    public int vexnum;
    public int arcnum;

    public AMGraph(int vexnum, int arcnum) {
        this.vexnum = vexnum;
        this.arcnum = arcnum;
    }
}
