import java.util.Comparator;
import java.util.TreeSet; 
public class Lambda { 
    public static void main(String[] args) 
    { 
		  	
    	TreeSet<String> tree_set = new TreeSet<String>((str1,str2)->str1.length()-str2.length()); 
    	tree_set.add("asdasd"); 
        tree_set.add("aaaaaaaaaa"); 
        tree_set.add("as"); 
        tree_set.add("das"); 
        tree_set.add("sddddddddddd"); 
        tree_set.add("asd"); 
        System.out.println("Set before using the comparator: "+ 
        tree_set); 
        for (String element : tree_set) 
            System.out.print(element + " "); 
    }      
} 