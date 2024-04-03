import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    public String encode(List<String> strs){
        StringBuilder output = new StringBuilder();

        for(String str: strs){
            int size = str.length();
            output.append(size);
            output.append(str);
        }

        return output.toString();

    }

    public List<String> decode(String str){
        int sizeWord = 0;
        List<String> output = new ArrayList<>();
        while(sizeWord <= str.length()){
            output.add(str.substring(sizeWord, str.charAt(sizeWord)));
            sizeWord = str.charAt(sizeWord);
        }

        return output;
    }

}
