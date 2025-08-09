public class  Learning{
    public static void main(String[] args){
        //System.out.print("HelloWorld");

        String[] words = {"aa","dd"};

        BoldString("aabbaaccdd", words);
        //"<aa/>bbcc<dd/>"

    }
    public static String BoldString(String s, String[] words)
    {
        String temp = "";

        for (int j = 0; j < words.length; j++)
        {
            int i = 0;
            while (i <= s.length()-words[j].length())
            {
                if (s.substring(i, i + words[j].length()).equals(words[j])){
                    temp += "<b>" + words[j] + "</b>";
                    i = i + words[j].length();
                }
                else{
                    if (j == 0)
                    {
                        temp +=  s.substring(i,i+1);
                    }
                    i++;
                    
                }
            }
        }
        System.out.println(temp);
        

        return "test";
    }

}

