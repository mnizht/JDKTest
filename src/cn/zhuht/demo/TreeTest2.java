package cn.zhuht.demo;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author zhuht
 * @date 2021/8/23 22:40
 */
public class TreeTest2 {

  public static void main(String[] args) {

    System.out.println(treeJudge(initTree()));
    System.out.println(treeJudge(initNonTree()));
    System.out.println(treeJudge(initCircle()));
    System.out.println(treeJudge(initCustom()));
  }

  public static String treeJudge(TreeNode root) {

    Set<TreeNode> passed = new HashSet<>(); // 已走过的节点
    Deque<TreeNode> stack = new LinkedList<>(); // 走过的路径

    String type = "Tree";

    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        if (passed.add(node)) {
          // 正常添加
          stack.push(node);
          node = node.left;
        } else {
          // 如果没添加成功，说明走过这个点，判断当前路径中是否有这个点
          if (stack.contains(node)) {
            return "Circle";
          } else {
            // 说明目前有会重复的节点，由于Circle的优先级高于，Non-Tree, 此处暂时把 type 置为 Non-Tree
            type = "Non-Tree";
          }
          node = null;
        }
      }
      node = stack.pollFirst();
      if (node == null) {
        break;
      }
      node = node.right;

    }

    return type;
  }


  public static TreeNode initTree() {
    TreeNode three = new TreeNode(3, null, null);
    TreeNode four = new TreeNode(4, null, null);
    TreeNode five = new TreeNode(5, null, null);
    TreeNode two = new TreeNode(2, three, four);
    TreeNode one = new TreeNode(1, two, five);
    return one;
  }

  public static TreeNode initNonTree() {
    TreeNode three = new TreeNode(3, null, null);
    TreeNode six = new TreeNode(6, null, null);
    TreeNode five = new TreeNode(5, null, null);
    TreeNode four = new TreeNode(4, five, six);
    TreeNode two = new TreeNode(2, three, four);
    TreeNode one = new TreeNode(1, two, four);
    return one;
  }

  public static TreeNode initCircle() {
    TreeNode three = new TreeNode(3, null, null);
    TreeNode four = new TreeNode(4, null, null);
    TreeNode six = new TreeNode(6, null, null);
    TreeNode five = new TreeNode(5, six, null);
    TreeNode two = new TreeNode(2, three, four);
    TreeNode one = new TreeNode(1, two, five);
    three.left = one;
    return one;
  }

  public static TreeNode initCustom() {
    TreeNode three = new TreeNode(3, null, null);
    TreeNode four = new TreeNode(4, null, null);
    TreeNode six = new TreeNode(6, null, null);
    TreeNode five = new TreeNode(5, six, null);
    TreeNode two = new TreeNode(2, three, four);
    TreeNode one = new TreeNode(1, two, null);
    three.right = four;
//    six.left = five;
    four.left = five;
    return one;
  }

}
