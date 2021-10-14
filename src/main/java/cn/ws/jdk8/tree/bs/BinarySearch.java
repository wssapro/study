package cn.ws.jdk8.tree.bs;

/**
 * <p>
 * 二分查找树-BinarySearchTree
 * </p>
 *
 * @author shun
 * @date 2020-06-02 19:02
 */
public class BinarySearch<T extends Comparable<T>> {

    public Node<T> root;

    public static class Node<T extends Comparable<T>> {
        public T value;
        public Node left;
        public Node right;
        public Node parent;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node left, Node right, Node parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    public void  preOrder(Node<T> root) {
        if(root != null){
            System.out.println(root.value);
            if(root.left!=null){
                preOrder(root.left);
            }
            if(root.right!=null){
                preOrder(root.right);
            }
        }
    }
    public void  inOrder(Node<T> root) {
        if(root != null){
            if(root.left!=null){
                inOrder(root.left);
            }
            System.out.println(root.value);
            if(root.right!=null){
                inOrder(root.right);
            }
        }
    }
    public void  afterOrder(Node<T> root) {
        if(root != null){
            if(root.left!=null){
                afterOrder(root.left);
            }
            if(root.right!=null){
                afterOrder(root.right);
            }
            System.out.println(root.value);
        }
    }

    public Node<T> search(Node<T> root, T key) {
        Node<T> result = null;
        if(root!=null){
            if(root.value==key){
                result = root;
            }else{
                if(key.compareTo(root.value)<0){
                    result = search(root.left,key);
                }
                if(key.compareTo(root.value)>0){
                    result = search(root.right,key);
                }
            }
        }
        return result;
    }


    public Node<T> max(Node<T> root){
        if(root != null){
            while(root.right!=null){
                root = max(root.right);
            }
        }
        return root;
    }

    public Node<T> min(Node<T> root){
        if(root != null){
            while(root.left!=null){
                root = min(root.left);
            }
        }
        return root;
    }

    /**
     *  查找前驱节点
     */
    public Node<T> predecessor(Node<T> root){
        //如果有左子节点，前驱节点为左子树最大节点
        if(root.left!=null){
            return max(root.left);
        }
        //如果为右子节点，前驱为父节点
        //如果为左子节点，前驱为
        Node<T> parent = root.parent;
        while(parent!=null && root==parent.left){
            root = root.parent;
            parent = parent.parent;
        }
        return parent;
    }
    public Node<T> successor(Node<T> root){
        //如果有右子节点，后驱节点为右子树最小节点
        if(root.right!=null){
            return min(root.right);
        }
        Node<T> result = root.parent;
        while(result!=null && root==result.right){
            root = result;
            result = result.parent;
        }
        return result;
    }
    public void insert(Node<T> root,Node<T> newNode){

    }
}


