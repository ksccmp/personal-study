import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_길찾기게임 {
	public static void main(String[] args) {
		int res[][] = solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
		System.out.println(Arrays.toString(res[0]));
		System.out.println(Arrays.toString(res[1]));
	}
	
	static int idx;
    public static int[][] solution(int[][] nodeinfo) {
    	
    	List<Data> list = new ArrayList<Data>();
    	for(int i=0; i<nodeinfo.length; i++) {
    		list.add(new Data(nodeinfo[i][0], nodeinfo[i][1], i+1));
    	}
    	
        Node root = Sort(0, nodeinfo.length-1, list);
        int res[][] = new int[2][nodeinfo.length];
        
        idx = 0;
        pre(root, res);
        idx = 0;
        post(root, res);
        
        return res;
    }
    
    public static void pre(Node root, int res[][]) {
        if(root == null) {
            return;
        }
        
        res[0][idx++] = root.index;
        pre(root.left, res);
        pre(root.right, res);
    }
    
    public static void post(Node root, int res[][]) {
        if(root == null) {
            return;
        }
        
        post(root.left, res);
        post(root.right, res);
        res[1][idx++] = root.index;
    }
    
    public static Node Sort(int start, int end, List<Data> list) {
        if(start > end) {
            return null;
        }
        
        int pivot = partition(start, end, list);
        Node root = new Node(list.get(pivot).index, null, null);
        root.left = Sort(start, pivot-1, list);
        root.right = Sort(pivot+1, end, list);
        return root;
    }
    
    public static int partition(int start, int end, List<Data> list) {
        int maxVal = -1;
        for(int i=start; i<=end; i++) {
        	if(maxVal == -1) {
        		maxVal = i;
        	} else if(list.get(maxVal).y < list.get(i).y) {
                maxVal = i;
            }
        }
        
        int temp1 = list.get(maxVal).x;
        int temp2 = list.get(maxVal).y;
        int temp3 = list.get(maxVal).index;
        list.get(maxVal).x = list.get(end).x;
        list.get(maxVal).y = list.get(end).y;
        list.get(maxVal).index = list.get(end).index;
        list.get(end).x = temp1;
        list.get(end).y = temp2;
        list.get(end).index = temp3;
        
        int pivot = start-1;
        for(int i=start; i<end; i++) {
            if(list.get(end).x > list.get(i).x) {
                temp1 = list.get(++pivot).x;
                temp2 = list.get(pivot).y;
                temp3 = list.get(pivot).index;
                list.get(pivot).x = list.get(i).x;
                list.get(pivot).y = list.get(i).y;
                list.get(pivot).index = list.get(i).index;
                list.get(i).x = temp1;
                list.get(i).y = temp2;
                list.get(i).index = temp3;
            }
        }
        
        temp1 = list.get(++pivot).x;
        temp2 = list.get(pivot).y;
        temp3 = list.get(pivot).index;
        list.get(pivot).x = list.get(end).x;
        list.get(pivot).y = list.get(end).y;
        list.get(pivot).index = list.get(end).index;
        list.get(end).x = temp1;
        list.get(end).y = temp2;
        list.get(end).index = temp3;
        
        return pivot;
    }
    
    private static class Node {
    	int index;
        Node left, right;
        public Node(int index, Node left, Node right) {
        	this.index = index;
            this.left = left;
            this.right = right;
        }
    }
    
    private static class Data {
    	int x, y, index;
    	public Data(int x, int y, int index) {
    		this.x = x;
    		this.y = y;
    		this.index = index;
    	}
    }
}
