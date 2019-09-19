package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreePreOrderTraversal {

    class Tree{
        public int val;
        public List<Tree> children;
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Tree root) {
        if(root==null){
            return res;
        }
        res.add(root.val);
        for(Tree child : root.children) {
            preorder(child);
        }
        return res;
    }
}
