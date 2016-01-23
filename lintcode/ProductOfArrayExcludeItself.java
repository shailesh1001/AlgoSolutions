/*
 * Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], 
calculate B WITHOUT divide operation.

Example
For A = [1, 2, 3], return [6, 3, 2].
 */
public class ProductOfArrayExcludeItself {

    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        for (int i = 0; i < A.size(); ++i) {
            if (i == 0) {
                result.add(1L);
            } else {
                result.add(result.get(result.size() - 1) * A.get(i - 1));
            }
        }
        long product = 1L;
        for (int i = A.size() - 1; i >= 0; --i) {
            if (i < A.size() - 1) {
                product *= A.get(i + 1);
            }
            result.set(i, result.get(i) * product);
        }
        return result;
    }

    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        long product = 1L;
        for (int i = 0; i < A.size(); ++i) {
            product *= i == 0 ? 1 : A.get(i - 1);
            result.add(product);
        }
        product = 1L;
        for (int i = A.size() - 1; i >= 0; --i) {
            product *= i == A.size() - 1 ? 1 : A.get(i + 1);
            result.set(i, result.get(i) * product);
        }
        return result;
    }

}
