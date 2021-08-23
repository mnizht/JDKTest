package cn.zhuht.demo;

import lombok.Data;

/**
 * @author zhuht
 * @date 2021/8/23 22:40
 */
public class TreeNode {
  public Integer val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(Integer val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
