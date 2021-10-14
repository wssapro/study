package cn.ws.dataStructure.graph.udn;

/**
 * @author wangshun
 * @date 2019/3/15 23:52
 */
public class CreateUDN {
    public static void main(String[] args) {
        AMGraph g = new AMGraph(5,10);

        for (int i = 0; i <g.vexnum; i++) {
            g.vexs[i]=i+"";
        }


    }

}
