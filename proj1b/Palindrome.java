public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> palDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            palDeque.addLast(ch);
        }
        return palDeque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> palDeque = wordToDeque(word);
        while (palDeque.size() > 0) {
            char l = palDeque.removeFirst();
            if (palDeque.size() > 0) {
                char r = palDeque.removeLast();
                if (l != r) {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> palDeque = wordToDeque(word);
        while (palDeque.size() > 0) {
            char l = palDeque.removeFirst();
            if (palDeque.size() > 0) {
                char r = palDeque.removeLast();
                if (!cc.equalChars(l, r)) {
                    return false;
                }
            } else {
                return true;
            }
        }
        return true;
    }
}
