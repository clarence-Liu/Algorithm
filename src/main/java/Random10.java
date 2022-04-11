import java.util.Scanner;

/**
 * Given the API rand7() that generates a uniform random integer in the range [1, 7],
 * write a function rand10() that generates a uniform random integer in the range [1, 10].
 * You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.
 *
 * Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing.
 * Note that this is not an argument passed to rand10().
 *
 * Follow up:
 *      What is the expected value for the number of calls to rand7() function?
 *      Could you minimize the number of calls to rand7()?
 */
/*
Example 1:
Input: n = 1
Output: [2]

Example 2:
Input: n = 2
Output: [2,8]

Example 3:
Input: n = 3
Output: [3,8,10]
 */
public class Random10 {

    public int rand7(){
        return (int)(Math.random() * 7) + 1;
    }

    public int rand10() {
        return rand7() * 10 / 7;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Random10 random = new Random10();
        while (n > 0) {
            System.out.println(random.rand10());
            n--;
        }
        Math.random();
    }
}
