package cn.zhuht.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuht
 * @date 2021/8/22 14:03
 */
public class TreeTest {

  public static Set<Node> allNodes = new HashSet<>();
  public static Set<Node> repeatNodes = new HashSet<>();
  public static String type = "Non-Tree";

  public static void main(String[] args) {
    Node root = initTree();
    Node root2 = initNonTree();
    Node root3 = initCircle();
    // 遍历所有节点，找出所有重复节点
    preorder(root2);
    if (repeatNodes.isEmpty()) {
      // 没有重复节点
      type = "tree";
    }
    // 使用所有重复节点去遍历，看还能不能再回到自己
    for (Node node : repeatNodes) {
      preorder2(node, node);
    }

    System.out.println(type);
  }

  public static void preorder2(Node root, Node node) {
    if (node.getLeft() != null) {
      if (root == node.getLeft()) {
        type = "Circle";
        return;
      }
      preorder2(root, node.getLeft());
    }
    if (node.getRight() != null) {
      if (root == node.getRight()) {
        type = "Circle";
        return;
      }
      preorder2(root, node.getRight());
    }
  }

  public static void preorder(Node root) {
    if (root != null) {
      boolean add = allNodes.add(root);
      if (!add) {
        // 没添加成功，说明该节点已经遍历过
        repeatNodes.add(root);
        return;
      }
      preorder(root.getLeft());
      preorder(root.getRight());
    }
  }

  public static Node initTree() {
    Node three = new Node(3, null, null);
    Node four = new Node(4, null, null);
    Node five = new Node(5, null, null);
    Node two = new Node(2, three, four);
    Node one = new Node(1, two, five);
    return one;
  }

  public static Node initNonTree() {
    Node three = new Node(3, null, null);
    Node six = new Node(6, null, null);
    Node five = new Node(5, null, null);
    Node four = new Node(4, five, six);
    Node two = new Node(2, three, four);
    Node one = new Node(1, two, four);
    return one;
  }

  public static Node initCircle() {
    Node three = new Node(3, null, null);
    Node four = new Node(4, null, null);
    Node six = new Node(6, null, null);
    Node five = new Node(5, six, null);
    Node two = new Node(2, three, four);
    Node one = new Node(1, two, five);
    three.setLeft(one);
    return one;
  }

}

