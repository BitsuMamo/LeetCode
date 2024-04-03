import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){

        HashMap<String, List<String>> grouping = new HashMap<>();

        for(int i = 0; i < strs.length; i ++){
          var charArray = strs[i].toCharArray();
          Arrays.sort(charArray);

          String key = new String(charArray);

          grouping.putIfAbsent(key, new ArrayList<>());

          var prevList = grouping.get(key);
          var newList = new ArrayList<>(prevList);
          newList.add(strs[i]);

          grouping.put(key, newList);

        }


        return new ArrayList<>(grouping.values());
    }
}
