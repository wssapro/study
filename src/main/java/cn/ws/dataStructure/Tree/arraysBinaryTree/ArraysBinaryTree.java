package cn.ws.dataStructure.Tree.arraysBinaryTree;

/**
 * @author wangshun
 * @date 2019/3/26 14:11
 */
public class ArraysBinaryTree {
    private int [] data;
    public ArraysBinaryTree(int[] data) {
        this.data = data;
    }
    public void frontShow(){
        frontShow(0);
    }
    public void frontShow(int index){
        if(data==null||data.length==0){
            return;
        }
        System.out.println(data[index]);
        if(2*index+1<data.length){
            frontShow(2*index+1);
        }
        if(2*index+2<data.length){
            frontShow(2*index+2);
        }
    }
}
