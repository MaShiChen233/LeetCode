package Easy.SortTest;


/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *  
 *
 * 提示：
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 **/

/**
 * @author 马世臣
 * @// TODO: 2020/1/16  1030. 距离顺序排列矩阵单元格*/
public class allCellsDistOrder {

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] array=new int[R*C][2];
        int[][] point=new int[R][C];
        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                point[i][j]=-1;
            }
        }
        point[r0][c0]=1;
        array[0][0]=r0;
        array[0][1]=c0;
        int[] dx=new int[]{1,-1,-1,1};
        int[] dy=new int[]{1,1,-1,-1};
        int num=1,length=1,x,y,flag=0;
        while (flag==0){
            for (int k=0;k<=length;k++){
                x=k;
                y=length-k;
                for (int j=0;j<4;j++){
                    int xp=r0+x*dx[j];
                    int yp=c0+y*dy[j];
                    if((xp>=0&&xp<R)&&(yp>=0&&yp<C)){
                        if(point[xp][yp]==-1){
                            point[xp][yp]=1;
                            array[num][0]=xp;
                            array[num][1]=yp;
                            //System.out.println(xp+" "+yp);
                            num++;
                            if(num==R*C){
                                flag=1;
                                break;
                            }
                        }
                    }
                }
            }
            length++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] array=allCellsDistOrder(3,3,2,2);
        for (int i=0;i<array.length;i++){
            System.out.println(array[i][0]+" "+array[i][1]);
        }
    }
}
