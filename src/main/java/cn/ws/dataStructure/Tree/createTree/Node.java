package cn.ws.dataStructure.Tree.createTree;

/**
 * @author wangshun
 * @date 2019/3/26 10:03
 */
public class Node {
    private Node leftNode;
    private int value;
    private Node rightNode;
    //前序遍历
    public void frontShow(){
        System.out.println(this.value);
        if(this.leftNode!=null){
            this.leftNode.frontShow();
        }
        if(this.rightNode!=null){
            this.rightNode.frontShow();
        }
    }
    //中序遍历
    public void midShow(){
        if(this.leftNode!=null){
            this.leftNode.midShow();
        }
        System.out.println(this.value);
        if(this.rightNode!=null){
            this.rightNode.midShow();
        }
    }
    //中序遍历
    public void afterShow(){
        if(this.leftNode!=null){
            this.leftNode.afterShow();
        }
        if(this.rightNode!=null){
            this.rightNode.afterShow();
        }
        System.out.println(this.value);
    }
    //前序查找
    public Node frontSearch(int i){
        Node targer = null;
        if(this.value == i){
            return this;
        }else{
            if(this.leftNode!=null){
                targer = this.leftNode.frontSearch(i);
            }
            if(targer !=null){
                return targer;
            }
            if(this.rightNode!=null){
                targer = this.rightNode.frontSearch(i);
            }
            if(targer!=null){
                return targer;
            }
        }
        return targer;
    }
    public void delete(int i) {
        Node parent = this;
        //判断左儿子
        if(parent.leftNode!=null&&parent.leftNode.value==i) {
            parent.leftNode=null;
            return;
        }
        //判断右儿子
        if(parent.rightNode!=null&&parent.rightNode.value==i) {
            parent.rightNode=null;
            return;
        }
        //递归检查并删除左儿子
        parent=leftNode;
        if(parent!=null) {
            parent.delete(i);
        }
        //递归检查并删除右儿子
        parent=rightNode;
        if(parent!=null) {
            parent.delete(i);
        }
    }
    public Node(int value) {
        this.value = value;
    }
    public Node getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Node getRightNode() {
        return rightNode;
    }
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
