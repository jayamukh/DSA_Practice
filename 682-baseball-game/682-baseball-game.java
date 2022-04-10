class Solution {
    public int calPoints(String[] ops) {
        List<Integer> arr = new ArrayList<Integer>();
        int k =0;
        for(int i=0; i< ops.length; i++ )
        {
           int c  = ops[i].charAt(0);
            
            System.out.println(c);
            if(c >=48 && c<=57 || c == 45){
                int val = Integer.parseInt(ops[i]);
                arr.add(val);
                k++;
            } 
            else if(c == 67)
            {
                arr.remove(k-1);
                k--;
            }
            else if(c == 68)
            {
                arr.add(arr.get(k-1) *2);
                k++;
            }
            else if(c == 43)
            {
                arr.add(arr.get(k-1) + arr.get(k-2));
                k++;
            }
        }
        
      int sum = 0;
for(int i = 0; i < arr.size(); i++)
    sum += arr.get(i);
return sum;
    }
}