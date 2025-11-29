public class Codec {

    // Encodes a tree to a single string.
    void ser(TreeNode root,StringBuilder str)
    {
        if(root==null)
            return;
        str.append(root.val);
        if (root.left!=null || root.right!=null)
        {
            str.append('(');
            if(root.left!=null)
                ser(root.left,str);
            str.append(',');

            if(root.right!=null)
                ser(root.right,str);
            str.append(')');
        }
    }
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder(200);
        ser(root,str);
        return  str.toString();
    }
    // Decodes your encoded data to tree.
    /*
     StringBuilder str=new StringBuilder(4);
        while (index<arr.length && Character.isDigit(arr[index]))
            str.append(arr[index++]);
     */
    TreeNode der(int[] index, char[] arr) {
        if (index[0] >= arr.length || arr[index[0]] == ',' || arr[index[0]] == ')') {
            return null;
        }

        StringBuilder numStr = new StringBuilder();
        while (index[0] < arr.length && (Character.isDigit(arr[index[0]]) || arr[index[0]] == '-')) {
            numStr.append(arr[index[0]++]);
        }

        TreeNode node = new TreeNode(Integer.parseInt(numStr.toString()));

        if (index[0] < arr.length && arr[index[0]] == '(') {
            index[0]++; 
            node.left = der(index, arr);
            index[0]++; 
            node.right = der(index, arr);
            index[0]++; 
        }

        return node;
    }
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        char[] arr = data.toCharArray();
        int[] index = new int[1];
        return der(index, arr);
    }
}