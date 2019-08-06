package problems.interviewbit.trees;

import java.util.*;

public class VerticalOrderTraversal {


    //TODO:: check.. not sure why this soln is not working in interviewbit
    Map<Integer, ArrayList<Integer>> res = new TreeMap<>(Comparator.reverseOrder());

    public int traverse(TreeNode A, Integer i){

        if(A==null|| A.val==-1) {

            return i - 1;
        }
        res.putIfAbsent(i,new ArrayList<>());
        res.merge(i, new ArrayList<>(Arrays.asList(A.val)),(val1, val2)-> {val1.add(val2.get(0)); return val1;});

        traverse(A.left, i+1);
        traverse(A.right, i-1);
        return i;
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        traverse(A,0);
        return  new ArrayList<>(res.values());
    }

   /* public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(A == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> levelNodeMap = new HashMap<>();
        Queue<Integer> levels = new LinkedList<>();

        queue.offer(A);
        levels.offer(0);
        Integer minLevel=0;
        Integer maxLevel=0;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            Integer level = levels.poll();
            minLevel = Math.min(level, minLevel);
            maxLevel = Math.max(maxLevel, level);

            if(!levelNodeMap.containsKey(level)){
                levelNodeMap.put(level, new ArrayList<Integer>());
            }
            levelNodeMap.get(level).add(node.val);
            if(node.left != null) {
                queue.offer(node.left);
                levels.offer(level - 1);
            }
            if(node.right != null) {
                queue.offer(node.right);
                levels.offer(level + 1);
            }
        }

        for(int level = minLevel; level <= maxLevel; ++level){
            if(levelNodeMap.containsKey(level)){
                result.add(levelNodeMap.get(level));
            }
        }

        return result;
    }*/

    public static void main(String[] args) {
        //818 -1 2510 212 -1 -1 9881 -1 -1
        TreeNode A= new TreeNode(460);
        A.left = new TreeNode(3871);
        A.left.left = new TreeNode(8399);
        A.left.right = new TreeNode(504);

        A.right=  new TreeNode(4698);
        A.right.left=  new TreeNode(4421);
        A.right.right=  new TreeNode(7515);
        System.out.println(new VerticalOrderTraversal().verticalOrderTraversal(A));
    }
}
