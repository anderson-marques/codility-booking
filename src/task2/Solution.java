package task2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by anderson on 09/05/17.
 */
public class Solution {

    private static final int ARRAY_SIZE = 6;
    private static final int COORDINATE_RANGE_MIN = -10000;
    private static final int COORDINATE_RANGE_MAX = 10000;
    private static final int ARRAY_LENGTH_MIN = 0;
    private static final int ARRAY_LENGTH_MAX = 100000;

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Initialize array of points
        Point3D[] points = new Point3D[ARRAY_SIZE];

        // Populate array of points
        points[0] = new Point3D(0,  5,  4 );
        points[1] = new Point3D(0,  0,  -3);
        points[2] = new Point3D(-2, 1,  -6);
        points[3] = new Point3D(1,  -2, 2 );
        points[4] = new Point3D(1,  1,  1 );
        points[5] = new Point3D(4,  -4, 3 );

        System.out.println(solution.solution(points));
    }

    public int solution(Point3D[] A){
        validateLength(A);
        Set<Double> spheres = new HashSet<>();
        for (int i = 0 ; i < A.length ; i ++ ){
            Point3D point3D = A[i];
            validatePoint3D(point3D);
            spheres.add(Math.pow(point3D.x, 2)  + Math.pow(point3D.y, 2) + Math.pow(point3D.z, 2));
        }
        return spheres.size();
    }

    private void validatePoint3D(Point3D point3D) {
        if (point3D.x < COORDINATE_RANGE_MIN || point3D.x > COORDINATE_RANGE_MAX){
            throw new RuntimeException("Invalid point3D! Its coordinate x is not within the valid range [-10,000..10,000].");
        } else if (point3D.y < COORDINATE_RANGE_MIN || point3D.y > COORDINATE_RANGE_MAX){
            throw new RuntimeException("Invalid point3D! Its coordinate y is not within the valid range [-10,000..10,000].");
        } else if (point3D.z < COORDINATE_RANGE_MIN || point3D.z > COORDINATE_RANGE_MAX){
            throw new RuntimeException("Invalid point3D! Its coordinate z is not within the valid range  [-10,000..10,000].");
        }
    }

    private void validateLength(Point3D[] a) {
        if (a.length < ARRAY_LENGTH_MIN || a.length > ARRAY_LENGTH_MAX){
            throw new RuntimeException("Invalid array length! It should be a integer within the range  [0..100,000]");
        }
    }

    private static class Point3D{
        public int x;
        public int y;
        public int z;

        public Point3D(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}


