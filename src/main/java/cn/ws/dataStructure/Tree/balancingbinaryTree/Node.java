package cn.ws.dataStructure.Tree.balancingbinaryTree;

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
    //查看高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }
    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
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
        if(leftHeight()-rightHeight()>1){
            if(this.left!=null && this.left.leftHeight()<this.left.rightHeight()){
                this.left.leftrotate();
                this.rightrotate();
            }else{
                this.rightrotate();
            }
        }else if(rightHeight()-leftHeight()>1){
            if(this.right!=null && this.right.leftHeight()>this.right.rightHeight()){
                this.left.rightrotate();
                this.leftrotate();
            }else{
                this.leftrotate();
            }
        }
    }
    //左旋转
    public void leftrotate(){
        Node oldroot = new Node(value);
        oldroot.left = left;
        oldroot.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = oldroot;
    }
    //右旋转
    public void rightrotate(){
        Node oldroot = new Node(value);
        oldroot.right = right;
        oldroot.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = oldroot;
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
