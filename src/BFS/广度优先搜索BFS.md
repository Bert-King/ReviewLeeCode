### 广度优先搜索

[BFS的算法解题套路](https://labuladong.github.io/algo/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/BFS%E6%A1%86%E6%9E%B6.html)

掌握了BFS的模板，我们首先可以拿经典的[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)练手。
进一步的掌握[Leetcode的相关题目](https://leetcode-cn.com/tag/breadth-first-search/problemset/)。


### 1. 二叉树BFS的代码模板

我相信对于计算机专业相关的朋友，可能依稀记得[BFS]()和[DFS]()在数据结构中的《图》章节进行引入介绍的。
其实对于这两种遍历方式，真正需要我们关注的是：核心思想和使用场景。

这里仅仅介绍一下用于遍历二叉树的BFS模板，后面再深入讲解其它地方的使用：
```java
//第一步: 要使用『队列』这种数据结构
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root); // 这里需要注意判空

while(!queue.isEmpty()){
   int size = queue.size();
   // 注意这里采用while，有时候采用for()更加方便，随机应变
   while(size > 0){
    // 在这个while里面处理的就是每一层的逻辑
       TreeNode cur = queue.poll();
        // 这里进行相关逻辑处理(一般)
                
       if(cur.left != null){
           queue.offer(cur.left);
       }

       if(cur.right != null){
           queue.offer(cur.right);
       }

      size--;
   }
}


```

下面有兴趣的话，跟着我来验证一下上面的模板吧！！！

---

### 2. 实战环节
根据我的刷题经验，在这里将合适的刷题顺序总结如下：

第1道：[102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
> 品尝一下模板有多香。

* [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)
* [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)
* [LintCode - 69 · 二叉树的层次遍历](https://www.lintcode.com/problem/69/)

第2道：[107. 二叉树的层序遍历 II](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
> 自底向上的层序遍历。最low的办法就是按照正常的层次遍历来解，最后翻转一下即可。但是这都2021年啦
> ArrayList的add(0,E)实现头插法，或者LinkedList的addFirst().

* [LintCode - 70 · 二叉树的层次遍历 II](https://www.lintcode.com/problem/70/)


第3道：[103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
> 如果不习惯处理下标，那么可以考虑LinkedList的addLast()和addFirst()
* [剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)
* [LintCode - 71 · 二叉树的锯齿形层次遍历](https://www.lintcode.com/problem/71/)

第4道：[199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)
> 看懂题意的话，只需要判断一下是否是每层的最后一下即可
* [LintCode - 760 · 二叉树的右视图](https://www.lintcode.com/problem/760/)

第4道：[515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)
> 每行的内容我都知道了，求个**最大值**而已，这个给道开胃菜...

* [LintCode - 297 · 寻找最大值](https://www.lintcode.com/problem/297/) 
* [LintCode - 1195 · 找出树中每行的最大值](https://www.lintcode.com/problem/1195/)

第5道：[637. 二叉树的层平均值](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/)
> 最大值咱都可以搞定，平均值？闹呢...
* [LintCode - 1115 · 二叉树每层的平均数](https://www.lintcode.com/problem/1115/)


---
### 杂记：
上面的基本都是遍历题目，下面这些是略有差别的，是需要在遍历的过程中，搞明白退出条件的

[111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)
>背景知识： 广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
>
> 退出条件：找到一个叶子节点，直接返回这个叶子节点的深度

