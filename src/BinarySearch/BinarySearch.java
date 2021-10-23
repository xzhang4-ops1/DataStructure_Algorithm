package BinarySearch;



public class BinarySearch<T extends Comparable<T>> {

    /*
     * Given a sorted 2D matrix A (sorted in all columns and rows) and a target key, implement
     * the search method to find and return the Element with the key that matches the target
     * within the range [minX, maxX]x[minY, maxY], otherwise return null.
     * You must use binary search with proper recursion in the columns and rows of A simultaneously.
     *
     * @param A is a sorted 2d array, such that A[i][0].key < ...< A[i][n-1].key and A[0][j].key < ...< A[n-1][j].key for all i, j
     * @param minX is the minimum index in the first coordinate to be searched in A
     * @param maxX is the maximum index in the first coordinate to be searched in A
     * @param minY is the minimum index in the second coordinate to be searched in A
     * @param maxY is the maximum index in the second coordinate to be searched in A
     * @param target is the target key
     * @return the object with the matched key if exist, otherwise return null.
     */
    public Element<T> search(Element<T>[][] A, int minX, int maxX, int minY, int maxY, T target) {

        int cast_to_int = (Integer) target;
        int firstdigit = cast_to_int / 10;
        if (firstdigit >= 10)
            return null;
        int second_digit = cast_to_int - firstdigit * 10;
        //如果相等进二次循环.
        if (firstdigit == (minY + maxY) / 2) {
            if (second_digit < (maxX + minX) / 2) {
                maxX = (maxX + minX) / 2;// 往中间靠的方法
                return this.search(A, minX, maxX, minY, maxY, target);
            }
            if (second_digit > (maxX + minX) / 2) {
                minX = (minX + maxX) / 2;
                return this.search(A, minX, maxX, minY, maxY, target);
            }
            if (second_digit == (minX + maxX) / 2) {
                Integer neereturn = firstdigit * 10 + second_digit + 1;
                return new Element<>(target, neereturn);
            }
        } else if (firstdigit < (maxY + minY) / 2) {
            maxY = (maxY + minY) / 2;
            return this.search(A, minX, maxX, minY, maxY, target);
        } else if (firstdigit > (maxY + minY) / 2) {
            minY = (maxY + minY) / 2;
            return this.search(A, minX, maxX, minY, maxY, target);
        }
        return null;
    }
}