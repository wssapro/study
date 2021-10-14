package cn.ws.dataStructure.Tree.huffmanTree;

/**
 * @author wangshun
 * @date 2019/3/27 14:46
 */
public class Node implements Comparable<Node> {
    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public int getvalue() {
        return value;
    }
    public void setvalue(int value) {
        this.value = value;
    }
    public Node getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
    public Node getRightNode() {
        return rightNode;
    }
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
    @Override
    public int compareTo(Node o) {
        return o.value-this.value;
    }
    @Override
    public String toString() {
        return "Node{value=" + value +'}';
    }
}
