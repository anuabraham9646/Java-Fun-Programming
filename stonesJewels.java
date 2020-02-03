import java.util.*;  
class Solution {
    public int numJewelsInStones(String J, String S) {
        int jewel=0;
        HashMap<Character,Integer> stones= new HashMap<Character,Integer>();
        for(Character c : S.toCharArray()){
            stones.put(c,stones.getOrDefault(c,0)+1)    ;        
        }
        for(Character j: J.toCharArray()){
            if(stones.containsKey(j)){
                jewel+=stones.get(j);
            }
        }
        return jewel;
        
    }
}







//most optimised



/*
class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || S == null || J.length() == 0 || S.length() == 0) return 0;
        
        boolean[] jewel = new boolean[128];
        for(char c : J.toCharArray())
            jewel[c] = true;
        
        int res = 0;
        for(char c : S.toCharArray()) {
            if(jewel[c]) ++res;
        }
        
        return res;
    }
}
*/