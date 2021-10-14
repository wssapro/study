package cn.ws.dataStructure.Tree.binarySortTree;

/**
 * @author wangshun
 * @date 2019/3/27 17:41
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {7,3,10,12,5,1,9};
        //创建一颗二叉排序树
        BinarySortTree bst = new BinarySortTree();
        //循环添加
        for(int i:arr) {
            bst.add(new Node(i));
        }
        //中序遍历
        bst.midShow();
        //查找
        System.out.println(bst.search(10).value);

    }
}
