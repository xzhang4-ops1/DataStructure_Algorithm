package BinarySearchChanged;

/**
 三维数组二分搜索方法。
 */

public class BinarySearch<T extends Comparable<T>>{

    /*
	 * Given a sorted 3D matrix A (sorted in every coordinate in ascending order) and a target key, implement 
	 * the binary search method to find and return the Element with the key that matches the target 
	 * within the range [minX, maxX]x[minY, maxY]x[minZ, maxZ], otherwise return null.
     * You must use binary search with proper recursion in the columns and rows of A simultaneously.      
	 * 
     * @param A is a sorted 3D array, such that 
	 *    A[x][y][0].key < ...< A[x][y][n-1].key and A[0][y][z].key < ...< A[n-1][y][z].key 
	 *       and A[x][0][z].key < ...< A[x][n-1][z].key, for all x, y, z in {0,...,n-1}.
     * @param minX is the minimum index in the first coordinate to be searched in A
     * @param maxX is the maximum index in the first coordinate to be searched in A
     * @param minY is the minimum index in the second coordinate to be searched in A
     * @param maxY is the maximum index in the second coordinate to be searched in A
     * @param minZ is the minimum index in the third coordinate to be searched in A
     * @param maxZ is the maximum index in the third coordinate to be searched in A	 
     * @param target is the target key
     * @return the object with the matched key if exist, otherwise return null.
     */
    public Element<T> search(Element<T>[][][] A, int minX, int maxX, int minY, int maxY, int minZ, int maxZ, T target){
		int cast_to_int = (Integer) target;
		if (cast_to_int<0)
			return null;
		int firstdigit = cast_to_int / 100;
		if (firstdigit >= 10)
			return null;
		int second_digit = (cast_to_int - firstdigit * 100)/10;
		int third_digit=cast_to_int-firstdigit*100-second_digit*10;
		if (firstdigit == (minY + maxY) / 2) {
			if (second_digit < (maxX + minX) / 2) {
				maxX = (maxX + minX) / 2;// 往中间靠的方法
				return this.search(A, minX, maxX, minY, maxY, minZ,maxZ,target);
			}
			if (second_digit > (maxX + minX) / 2) {
				minX = (minX + maxX) / 2;
				return this.search(A, minX, maxX, minY, maxY,minZ,maxZ, target);
			}
			if (second_digit == (minX + maxX) / 2) {
				if (third_digit < (maxZ + minZ) / 2) {
					maxZ = (maxZ + minZ) / 2;// 往中间靠的方法
					return this.search(A, minX, maxX, minY, maxY, minZ,maxZ,target);
				}
				if (third_digit >(maxZ + minZ) / 2) {
					minZ = (maxZ + minZ) / 2;// 往中间靠的方法
					return this.search(A, minX, maxX, minY, maxY, minZ,maxZ,target);
				}
				if (third_digit==(minZ+maxZ)/2) {
					Integer neereturn = firstdigit * 100 + second_digit*10 + third_digit+1;
					return new Element<>(target, neereturn);
				}
			}
		} else if (firstdigit < (maxY + minY) / 2) {
			maxY = (maxY + minY) / 2;
			return this.search(A, minX, maxX, minY, maxY, minZ,maxZ,target);
		} else if (firstdigit > (maxY + minY) / 2) {
			minY = (maxY + minY) / 2;
			return this.search(A, minX, maxX, minY, maxY, minZ,maxZ,target);
		}
		return null;

    }
}