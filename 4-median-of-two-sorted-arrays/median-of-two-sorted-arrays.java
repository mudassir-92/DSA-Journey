class Solution {
    public double findMedianSortedArrays(int[] arr, int[] arr2) {
        int [] arr3= new int[arr.length+arr2.length];
        int i=0;
        for(int j=0;j<arr.length;j++)
        {
            arr3[i]=arr[j];
            i++;
        }
        for(int j=0;j<arr2.length;j++)
        {
            arr3[i]=arr2[j];
            i++;
        }
       Arrays.sort(arr3);
        int l=arr3.length;
        if(l%2!=0)
            return arr3[l/2];
        else
        {
            return (arr3[l/2-1]+arr3[l/2])/2.0;
        }
        
    }
}