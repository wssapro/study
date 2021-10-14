package cn.ws.jdk8.tree.bs;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-02 19:09
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();


        BinarySearch.Node<Integer> n3 = new BinarySearch.Node<>(2);
        BinarySearch.Node<Integer> n7 = new BinarySearch.Node<>(7);
        BinarySearch.Node<Integer> n11 = new BinarySearch.Node<>(11);
        BinarySearch.Node<Integer> n13 = new BinarySearch.Node<>(13);
        BinarySearch.Node<Integer> n17 = new BinarySearch.Node<>(17);
        BinarySearch.Node<Integer> n4 = new BinarySearch.Node<>(4);
        BinarySearch.Node<Integer> n8 = new BinarySearch.Node<>(8);
        BinarySearch.Node<Integer> n12 = new BinarySearch.Node<>(12);
        BinarySearch.Node<Integer> n20 = new BinarySearch.Node<>(20);
        BinarySearch.Node<Integer> n5 = new BinarySearch.Node<>(5);
        BinarySearch.Node<Integer> n15 = new BinarySearch.Node<>(15);
        BinarySearch.Node<Integer> root = new BinarySearch.Node<>(10);


        n3.parent = n4;
        n7.parent = n8;
        n11.parent = n12;
        n13.parent = n12;
        n17.parent = n20;


        n4.parent = n5;
        n4.left = n3;
        n8.parent = n5;
        n8.left =






        binarySearch.root = root;
//        bs.preOrder(bs.root);
//        bs.inOrder(bs.root);
//        bs.afterOrder(bs.root);
        binarySearch.search(root,2);
        binarySearch.max(root);
        binarySearch.min(root);
    }
}
