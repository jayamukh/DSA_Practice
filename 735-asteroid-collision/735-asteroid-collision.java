class Solution {
    public int[] asteroidCollision(int[] asteroids) {
     Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (!st.isEmpty()) {
                int top = st.peek();
                if (!oppositeSigns(asteroids[i], top)) {
                    st.push(asteroids[i]);
                }
                else if (top > 0 && asteroids[i] < 0) {

                    int res = 0;
                    if (Math.abs(asteroids[i]) > Math.abs(top))
                        res = asteroids[i];
                    else if (Math.abs(top) > Math.abs(asteroids[i]))
                        res = top;
                    st.pop();
                    while (!st.isEmpty() && st.peek() > 0 && res < 0) {
                        if (Math.abs(st.peek()) > Math.abs(res))
                            res = st.peek();
                        else if (Math.abs(st.peek()) == Math.abs(res))
                            res = 0;
                        st.pop();
                    }
                    if (res != 0)
                        st.push(res);
                }
                else {
                    st.push(asteroids[i]);
                }

            }
            else {
                st.push(asteroids[i]);
            }

        }
        List<Integer> lst = new ArrayList<Integer>();
        Stack<Integer> newSt = new Stack<>();

        while (st.size() > 0) {
            newSt.push(st.pop());
        }

        while (newSt.size() > 0) {
            lst.add(newSt.pop());
        }
        return lst.isEmpty() ? new int[] {
        } : lst.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean oppositeSigns(int x, int y) {
        return ((x ^ y) < 0);
    }
}