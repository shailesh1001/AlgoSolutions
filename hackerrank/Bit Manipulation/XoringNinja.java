/*
 * Problem Statement

Given a list containing N integers, calculate the XorSum of all the non-empty
subsets of the list and print the value of XorSum % (109+7).

XOR operation on a list is defined as the xor (��), of all the elements present
in it, e.g., 
XOR({A,B,C})=A��B��C.

XorSum of a list is the sum of the XORs of every possible non-empty subset of 
the list. 
For example, for list X={x1,x2,x3} all possible non-empty subsets are [{x1},
{x2},{x3},{x1,x2},{x1,x3},{x2,x3},{x1,x2,x3}] 
XorSum(X)=x1+x2+x3+(x1��x2)+(x1��x3)+(x2��x3)+(x1��x2��x3)
Input Format 
An integer T, denoting the number of testcases. 2��T lines follow.
Each testcase contains two lines, first line will contains an integer N
followed by second line containing N integers, a1,a2,��,aN, separated by a 
single space.

Output Format 
T lines, ith line containing the output of the ith testcase.

Constraints

1��T��5
1��N��105
0��ai��109, i��[1,n]
Sample Input #00

1
3
1 2 3
Sample Output #00

12
Explanation 
The given case will have 7 non-empty subsets whose XOR is given below

1=1
2=2
3=3
1��2=3
2��3=1
3��1=2
1��2��3=0
So sum of all such XORs is 12.
 */
public class XoringNinja {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; ++j) {
                a[j] = in.nextInt();
            }
            long sum = xoringNinja(a);
            System.out.println(sum % (1000000007));
        }
    }
    
    public static BigInteger xoringNinja(int[] a) {

    }

    public static long xoringNinja(int[] a) {
        long sum = 0;
        for (int i = 0; i < 1 << a.length; ++i) {
            int xor = 0;
            for (int j = 0; j < a.length; ++j) {
                if ((i & 1 << j) != 0) {
                    xor ^= a[j];
                }
            }
            sum += xor;
        }
        return sum;
    }

    public static long xoringNinja(int[] a) {
        long sum = 0;
        for (int i = 0; i < a.length; ++i) {
            sum |= a[i];
        }
        return sum * (1 << a.length - 1);
    }

}
