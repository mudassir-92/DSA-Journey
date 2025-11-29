class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int l=s.length();
        char[] arr = s.toCharArray();
        int index=0;
        System.out.println(l);
        StringBuilder str=new StringBuilder(l);
        // let's build
        int cols=(l/numRows)/2+l/(Math.max(numRows-2,1))+500;
        // 10 for security
        int temp=cols;
        char [][] grid=new char[numRows][cols];
        int row=0,col=0;

        buildDown:
        while (true)
        {
            for (int i = row; i < numRows; i++) {
                grid[i][col]=arr[index++];
                if(index>=l) {
                    break ;
                }
            }

            // build up
            for (int i = numRows-2; i >=0 ; i--) {
//                System.out.println(i);
                if(index>=l) {
                    System.out.println(index);
                    break ;
                }
                grid[i][++col]=arr[index++];
            }
            row=1;
//            --col;
            if(index>=l)
            {
                break buildDown;
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < temp; j++) {
                if(grid[i][j]!=0)
                    str.append(grid[i][j]);
            }
        }

        return  str.toString();

    }
}