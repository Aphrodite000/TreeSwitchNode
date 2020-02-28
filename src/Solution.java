public class Solution {
    //二叉搜索树肯定每个结点的度都为2啊，除了叶子结点也可能左边为空，右边不可能为空
    TreeNode leftHead=null;
    TreeNode rightHead=null;
    //链表的两个方向
    public TreeNode Convert(TreeNode pRootOfTree) {
        //递归调用叶子节点的左右节点返回null
        if(pRootOfTree==null) return null;
        //第一次运行时，它会使最左边叶子节点为链表第一个节点
        Convert(pRootOfTree.left);
        if(rightHead==null){
            leftHead= rightHead = pRootOfTree;
        }else{
            //把根节点插入到双向链表右边，rightHead向后移动
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        //把右叶子节点也插入到双向链表（rightHead已确定，直接插入）
        Convert(pRootOfTree.right);
        //返回左边头结点
        return leftHead;
    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
