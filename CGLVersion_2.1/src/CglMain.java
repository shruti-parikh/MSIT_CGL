import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 */

/**
 * @author shruti parikh
 *
 */

public class CglMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading size of the Board
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        // Reading no. of initial live cells
        int m = sc.nextInt();
        int[][] l = new int[m][2];
        
        
 
        
        // Reading Live cells
         for (int i=0;i<m;i++){ 
            l[i][0] = sc.nextInt();
            l[i][1] = sc.nextInt();
        }
         Arrays.deepToString(l);
        System.out.print(Arrays.deepToString(l));
        Board b = new Board(n, l);
        b.board = b.createBoard(l);
        System.out.println("======CURRENT GENERATION=======");
        System.out.println(b.toString());
        
        Game g = new Game(k, b);
        g.kthGenerations();     
        sc.close();
    }

}
