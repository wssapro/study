package cn.ws.dataStructure.Tree.createTree;

/**
 * @author wangshun
 * @date 2019/3/26 10:03
 */
public class BinaryTree {
    private Node root;
    //前序遍历
    public void frontShow() {
        if(root!=null) {
            root.frontShow();
        }
    }
    //中序遍历
    public void midShow() {
        if(root!=null) {
            root.midShow();
        }
    }
    //后序遍历
    public void afterShow() {
        if(root!=null) {
            root.afterShow();
        }
    }
    //前序查找
    public Node frontSearch(int i){
        return root.frontSearch(i);
    }
    public void delete(int i) {
        if(root.getValue()==i) {
            root=null;
        }else {
            root.delete(i);
        }
    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
}
