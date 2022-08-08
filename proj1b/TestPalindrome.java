import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset. */
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("c"));
        assertTrue(palindrome.isPalindrome("cc"));
        assertTrue(palindrome.isPalindrome("cac"));
        assertTrue(palindrome.isPalindrome("caac"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("aab"));
        assertFalse(palindrome.isPalindrome("aaab"));
        assertFalse(palindrome.isPalindrome("De"));
        assertFalse(palindrome.isPalindrome("Dad"));
        assertFalse(palindrome.isPalindrome("Dd"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
    }

    @Test
    public void testIsPalindrome2() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("c", cc));
        assertTrue(palindrome.isPalindrome("cad", cc));
        assertTrue(palindrome.isPalindrome("DaC", cc));
        assertTrue(palindrome.isPalindrome("cdcd", cc));
        assertTrue(palindrome.isPalindrome("AcdcdB", cc));
        assertFalse(palindrome.isPalindrome("cccd", cc));
        assertFalse(palindrome.isPalindrome("dccd", cc));
        assertFalse(palindrome.isPalindrome("Dccd", cc));
        assertFalse(palindrome.isPalindrome("ddccd", cc));
        assertFalse(palindrome.isPalindrome("DDccd", cc));
    }


}
