public class ValidPalindrome {
    public boolean isPalindrome(String s){
        String res = s.replaceAll("[^0-9a-zA-Z]+", "");
        res = res.toLowerCase();
        int start = 0;
        int end = res.length();
        while(start < end){
            if(res.charAt(start) != res.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
