package problems.leetcode.contest;

public class RemoveAllAdjacentDuplicates {

    public String removeDuplicates(String s, int k) {
        String res=s;
        String prev;
        do{
            prev=res;
            if(s.length()>0){
                StringBuilder sb = new StringBuilder("");
                for(int i=0; i < res.length(); i++){
                    char ch = res.charAt(i);
                    if(i+k <= res.length()) {
                        int j = i + 1;
                        for (; j < i+ k; j++) {
                            if (ch != res.charAt(j)) {
                                break;
                            }
                        }
                        if ((j- i)== k) {
                            i += k-1;
                        } else
                            sb.append(ch);
                    }else
                        sb.append(ch);
                }
                res=sb.toString();
            }
        }while(prev.length()!=res.length());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicates()
                .removeDuplicates("deeedbbcccbdaa",3));
    }
}
