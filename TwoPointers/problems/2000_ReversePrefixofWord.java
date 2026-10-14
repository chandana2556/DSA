class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int var=-1;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                var=i;
                break;
            }
        }
        if(var==-1){
            return word;
        }
        int left=0;
        int right=var;
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return new String(arr);
    }
}