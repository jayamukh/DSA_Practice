class Solution {
    public int calculate(String s) {
       
         Stack<Character> operators = new Stack<Character>();
        Stack<Integer> operands = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-' || c == '/' || c == '*') {
                while (operators.size() > 0 && prec(c) <= prec(operators.peek())) {
                    char op = operators.pop();

                    int op2 = operands.pop();
                    int op1 = operands.pop();

                    int res = calc(op1, op2, op);

                    operands.push(res);
                }
                operators.push(c);
            }
            else if (c >= '0' && c <= '9') {
                int currentNum = 0;
                int j = i;
                do {
                    currentNum = (currentNum * 10) + (c - '0');
                    if (j < s.length() - 1) {
                        j++;
                        c = s.charAt(j);
                    }
                    else {
                        break;
                    }
                } while (Character.isDigit(c));
                if (j == s.length() - 1) {
                    i = j;
                }
                else {
                    i = j - 1;
                }

                operands.push(currentNum);
            }

        }


        while (operators.size() > 0 && operands.size() > 0) {
            char op = operators.pop();

            int op2 = operands.pop();
            int op1 = operands.pop();

            int res = calc(op1, op2, op);

            operands.push(res);
        }

        return operands.peek();
    }
    
    public int prec(char c)
  {
    if (c == '+' || c == '-')
    {
      return 1;
    }
    else if (c == '*' || c == '/')
    {
      return 2;
    }
    return 0;
  }

  public int calc(int i, int j, char op)
  {
    if (op == '+')
    {
      return i + j;
    }
    else  if (op == '-')
    {
      return i - j;
    }
    else  if (op == '/')
    {
      return i / j;
    }
    else if (op == '*')
    {
      return i * j;
    }

    return 0;

  }
}