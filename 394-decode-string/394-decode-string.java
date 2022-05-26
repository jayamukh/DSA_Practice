class Solution {
    public String decodeString(String s) {
        
        
      
        Stack<String> sc = new Stack<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                //st.push(c - '0');
                StringBuilder val = new StringBuilder();
                while (c != '[') {
                    val.append(c);
                    i++;
                    c = s.charAt(i);
                }
                sc.push(c + "");
                int num = Integer.parseInt(val.toString());
                st.push(num);

            }
            else if (c == ']') {
                String ch = sc.peek();
                StringBuilder str = new StringBuilder();
                while (!ch.equals("[")) {
                    str.insert(0, sc.pop());
                    ch = sc.peek();
                }
                sc.pop();
                // String str = str1.reverse().toString();
                //sc.push(str);
                StringBuilder ans = new StringBuilder();
                int num = st.pop();
                for (int idx = 0; idx < num; idx++) {
                    ans.append(str.toString());
                }

                sc.push(ans.toString());
            }
            else {
                sc.push(c + "");
            }

        }

        if (sc.size() == 1) {
            return sc.pop();
        }

        StringBuilder decode = new StringBuilder();


        while (!sc.isEmpty()) {
            String st1 = sc.pop();
            decode.insert(0, st1);

        }

        return decode.toString();
    }
}