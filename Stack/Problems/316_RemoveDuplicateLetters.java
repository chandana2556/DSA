# LeetCode 316 - Remove Duplicate Letters

Given a string `s`, remove duplicate letters so that every letter appears exactly once. Among all possible results, return the lexicographically smallest string while preserving the relative order of characters.

Example:

Input  : "bcabc"
Output : "abc"

============================================================
APPROACH 1 (Brute Force - Generate All Combinations)
============================================================

Approach:

• Store all positions (indices) of every character using a HashMap.
• Sort all unique characters in lexicographical order.
• Generate all possible combinations by choosing one occurrence of every unique character.
• For every combination:
    - Sort the selected indices.
    - Build the corresponding subsequence.
    - Compare it with the current best answer.
• Return the lexicographically smallest valid subsequence.

Example:

Input:

"bcabc"

Possible Candidates:

bca

bac

abc

cab

Output:

abc

Time Complexity:

Exponential

Reason:
• Every occurrence of every unique character is tried.
• The total number of possible combinations grows exponentially.

Space Complexity:

O(n)

Reason:
• Extra space is used for the HashMap, recursion stack, and temporary arrays.

Edge Cases:

• "a" → "a"
• "aaaa" → "a"
• "bcabc" → "abc"
• "cbacdcbc" → "acdb"
• "abacb" → "abc"

Code:

class Solution {
    public String removeDuplicateLetters(String s) {
        // Find positions of each character
        Map<Character, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            positions.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }

        List<Character> chars = new ArrayList<>(positions.keySet());
        Collections.sort(chars);
        String[] best = {null};

        // Try all combinations of picking one position per character
        generateCombinations(chars, positions, 0, new int[chars.size()], -1, best, s);
        return best[0];
    }

    private void generateCombinations(List<Character> chars, Map<Character, List<Integer>> positions,
                                       int idx, int[] chosen, int lastPos, String[] best, String s) {
        if (idx == chars.size()) {
            int[] sorted = chosen.clone();
            Arrays.sort(sorted);
            StringBuilder sb = new StringBuilder();
            for (int pos : sorted) {
                sb.append(s.charAt(pos));
            }
            String candidate = sb.toString();
            if (best[0] == null || candidate.compareTo(best[0]) < 0) {
                best[0] = candidate;
            }
            return;
        }

        for (int pos : positions.get(chars.get(idx))) {
            chosen[idx] = pos;
            generateCombinations(chars, positions, idx + 1, chosen, lastPos, best, s);
        }
    }
}

============================================================
APPROACH 2 (Optimal - Greedy + Stack)
============================================================

Approach:

• Store the last occurrence index of every character.
• Create a boolean array to track whether a character is already present in the stack.
• Use a StringBuilder as a stack.
• Traverse the string character by character.
• If the current character is already present in the stack, skip it.
• Otherwise, while:
    - the stack is not empty,
    - the top character is lexicographically larger than the current character,
    - and the top character appears again later,
  remove the top character from the stack.
• Push the current character into the stack and mark it as visited.
• After processing all characters, the stack contains the required answer.

Example:

Input:

"cbacdcbc"

Process:

Read c → Push

Read b → Pop c, Push b

Read a → Pop b, Push a

Read c → Push

Read d → Push

Read c → Skip

Read b → Push

Read c → Skip

Output:

acdb

Time Complexity:

O(n)

Reason:
• Every character is pushed into the stack at most once and popped at most once.

Space Complexity:

O(n)

Reason:
• Extra space is used for the stack, lastIndex array, and visited array.

Edge Cases:

• "a" → "a"
• "aaaa" → "a"
• "bcabc" → "abc"
• "cbacdcbc" → "acdb"
• "abacb" → "abc"

Code:

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        boolean [] inStack = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(inStack[ch-'a']) continue;

            while(stack.length()>0 && stack.charAt(stack.length()-1)>ch &&
            lastIndex[stack.charAt(stack.length()-1)-'a']>i){
                inStack[stack.charAt(stack.length()-1)-'a']=false;
                stack.deleteCharAt(stack.length()-1);
            }
 