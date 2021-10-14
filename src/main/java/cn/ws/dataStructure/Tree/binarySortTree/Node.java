package cn.ws.dataStructure.Tree.binarySortTree;

/**
 * @author wangshun
 * @date 2019/3/27 17:33
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    //添加
    public void add(Node node){
        if(node==null){
            return ;
        }
        if(node.value<this.value){
            if(this.left == null){
                this.left = node;
            }else{
                this.left.add(node);
            }
        }else{
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }

    public void midShow(Node node) {
        if(node==null) {
            return;
        }
        midShow(node.left);
        System.out.print(node.value+" ");
        midShow(node.right);
    }

    public Node search(int value) {
        if(this.value == value){
            return this;
        }else if(this.value > value){
            if(left ==null){
                return null;
            }
            return left.search(value);
        }else{
            if(right ==null){
                return null;
            }
            return right.search(value);
        }
    }
    /**
     * 搜索父节点
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)) {
            return this;
        }else {
            if(this.value>value&&this.left!=null) {
                return this.left.searchParent(value);
            }else if(this.value<value&&this.right!=null){
                return this.right.searchParent(value);
            }
            return null;
        }
    }
}
