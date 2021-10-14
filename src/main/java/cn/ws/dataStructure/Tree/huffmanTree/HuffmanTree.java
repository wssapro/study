package cn.ws.dataStructure.Tree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangshun
 * @date 2019/3/27 14:47
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = new int[]{3,7,8,29,5,11,23,14};
        System.out.println(create(arr));
    }

    public static Node create(int arr[]){
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }

        while(nodes.size()>1){
            Collections.sort(nodes);
            Node left = nodes.get(nodes.size()-1);
            Node right = nodes.get(nodes.size()-2);
            Node parent = new Node(left.getvalue()+right.getvalue());
            parent.setLeftNode(left);
            parent.setRightNode(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
