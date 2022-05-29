class Solution {
    public void rotate(int[] arr, int k) {
        k = k% arr.length;
        
        int i = 0;
        int j = arr.length - k -1;
        while(i<j)
        {
           int temp = arr[j];
           arr[j] = arr[i];
           arr[i] = temp;
            i++;
                j--;
        }
        
        i = arr.length - k;
        j = arr.length -1;
        while(i<j)
        {
            int temp = arr[j];
           arr[j] = arr[i];
           arr[i] = temp;
            i++;
                j--;
        }
        
        i = 0;
         j = arr.length -1;
        while(i<j)
        {
            int temp = arr[j];
           arr[j] = arr[i];
           arr[i] = temp;
            i++;
                j--;
        }
    }
}