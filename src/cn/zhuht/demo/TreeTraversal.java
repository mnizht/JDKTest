package cn.zhuht.demo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuht
 * @date 2021/8/21 8:48
 */
public class TreeTraversal {

  public static void main(String[] args) {
    Node node = initNode();

    List<Integer> preorderRes = preorderTraversal2(node);
    System.out.println(preorderRes);

    List<Integer> inorderRes = inorderTraversal(node);
    List<Integer> inorderRes2 = inorderTraversal2(node);
    System.out.println(inorderRes);
    System.out.println(inorderRes2);

    List<Integer> postorderRes = postorderTraversal(node);
    List<Integer> postorderRes2 = postorderTraversal2(node);
    System.out.println(postorderRes);
    System.out.println(postorderRes2);
  }

  // region init node
  public static Node initNode() {
    Node six = new Node(6, null, null);
    Node five = new Node(5, null, null);
    Node four = new Node(4, null, null);
    Node three = new Node(3, five, six);
    Node two = new Node(2, null, four);
    Node one = new Node(1, two, three);

    return one;
  }
  // endregion


  // region preorder

  /**
   * 递归先序遍历，根 -> 左 -> 右
   *
   * @param root 根节点
   * @return
   */
  public static List<Integer> preorderTraversal(Node root) {
    List<Integer> res = new ArrayList<>();
    preorder(root, res);
    return res;

  }

  public static void preorder(Node node, List<Integer> res) {
    if (node == null) {
      return;
    }
    res.add(node.getId());
    preorder(node.getLeft(), res);
    preorder(node.getRight(), res);
  }

  /**
   * 迭代先序遍历
   *
   * @param root
   * @return
   */
  public static List<Integer> preorderTraversal2(Node root) {

    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Deque<Node> stack = new LinkedList<Node>();
    Node node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        res.add(node.getId());
        stack.push(node);
        node = node.getLeft();
      }
      node = stack.pop();
      node = node.getRight();
    }

    return res;
  }


  // endregion


  // region inorder

  /**
   * 中序遍历 左 -> 根 -> 右
   *
   * @param root
   * @return
   */
  public static List<Integer> inorderTraversal(Node root) {
    List<Integer> res = new ArrayList<>();
    inorder(root, res);
    return res;
  }

  public static void inorder(Node node, List<Integer> res) {
    if (node != null) {
      inorder(node.getLeft(), res);
      res.add(node.getId());
      inorder(node.getRight(), res);
    }
  }

  /**
   * 迭代 中序遍历
   *
   * @param root
   * @return
   */
  public static List<Integer> inorderTraversal2(Node root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<Node> stack = new LinkedList<>();
    Node node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.getLeft();
      }
      node = stack.pop();
      res.add(node.getId());
      node = node.getRight();
    }
    return res;
  }
  // endregion


  // region postorder

  /**
   * 后序遍历 左 -> 右 -> 根
   *
   * @param root
   * @return
   */
  public static List<Integer> postorderTraversal(Node root) {
    List<Integer> res = new ArrayList<>();
    postorder(root, res);
    return res;
  }

  public static void postorder(Node node, List<Integer> res) {
    if (node != null) {
      postorder(node.getLeft(), res);
      postorder(node.getRight(), res);
      res.add(node.getId());
    }
  }

  /**
   * 迭代 后序遍历
   *
   * @param root
   * @return
   */
  public static List<Integer> postorderTraversal2(Node root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<Node> stack = new LinkedList<>();
    Node node = root;
    Node prev = null;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.getLeft();
      }
      node = stack.pop();
      if (node.getRight() == null || node.getRight() == prev) {
        res.add(node.getId());
        prev = node;
        node = null;
      } else {
        stack.push(node);
        node = node.getRight();
      }
    }
    return res;
  }

  // endregion

}


class Node {
  public Node(Integer id, Node left, Node right) {
    Id = id;
    this.left = left;
    this.right = right;
  }

  public Integer getId() {
    return Id;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  private Integer Id;
  private Node left;
  private Node right;
}