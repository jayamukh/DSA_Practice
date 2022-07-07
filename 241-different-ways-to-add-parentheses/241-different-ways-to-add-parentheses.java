class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ret  = new LinkedList<Integer>();
        for(int i = 0; i < expression.length(); i++)
        {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
           List<Integer> retpart1 =  diffWaysToCompute(expression.substring(0,i));
                List<Integer> retpart2 =  diffWaysToCompute(expression.substring(i+1)); 
                
                
                for(Integer p1: retpart1)
                {
                    for(Integer p2: retpart2)
                    {
                        int c = 0;
                        switch(expression.charAt(i))
                        {
                            case '+': c= p1 + p2;
                                break;
                                case '-': c= p1 - p2;
                                break;
                                case '*': c= p1 * p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(expression));
        }
        return ret;
        
    }
}