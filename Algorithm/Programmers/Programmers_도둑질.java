
public class Programmers_도둑질 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,2,3,1}));
	}
	
	public static int solution(int[] money) {
		int res[][] = new int[money.length][2]; // 0: 첫번째 집 골랐을 때, 1: 첫번째 집 고르지 않았을 때
        res[0][0] = money[0];
        res[1][0] = Math.max(money[0], money[1]);
        res[1][1] = money[1];
        
        int max = Math.max(money[0], money[1]);
        
        for(int i=2; i<money.length-1; i++) {
            res[i][0] = Math.max(res[i-1][0], res[i-2][0] + money[i]);
            max = Math.max(max, res[i][0]);
        }
        
        for(int i=2; i<money.length; i++) {
            res[i][1] = Math.max(res[i-1][1], res[i-2][1] + money[i]);
            max = Math.max(max, res[i][1]);
        }
        
        return max;
    }
}

/*
집들을 방문하면서 i번째 집의 돈을 훔치기 위해서는 i-1번쩨는 방문하지 않고 i-2번째는 방문을 할 수 있다.
이에 대한 점화식으로 res[i] = MAX(res[i-1], res[i-2] + money[i])라는 식이 나온다.
한 가지 더 생각해야 되는 것은 원형 집으로 되어 있기 때문에 첫 번째 집과 마지막 집도 인접해 있는 것이다.
해당 상황을 구분하기 위해 첫 번째 집의 돈을 훔칠 때는 마지막 집의 돈은 훔치지 않는다.
첫 번째 집의 돈을 훔치지 않을 때는 마지막 집을 거치도록 하여 돈을 훔치게 한다.
res[money.length][0]일 경우는 첫 번째 집의 돈을 훔치고 마지막 집의 돈을 훔치지 않을 때 이고
res[money.length][1]일 경우는 첫 번째 집의 돈을 훔치지 않고 마지막 집의 돈을 훔칠 때 이다.
res[0][0] 같은 경우는 첫 번째 집의 돈을 훔칠 때 첫 번째 집까지 갔을 때의 최댓값이므로 money[0]과 동일하고
res[1][0] 같은 경우는 첫 번째 집의 돈을 훔칠 때 두 번째 집까지 갔을 때의 최댓값이므로 MAX(money[0], money[1])과 동일 하다.
res[0][1] 같은 경우는 첫 번째 집의 돈을 훔치지 않을 때 이므로 default 값인 0으로 두고
res[1][1] 같은 경우는 첫 번째 집의 돈을 훔치지 않을 때 두 번째 집까지 갔을 때의 최댓값이므로 money[1]과 동일하다.
이후로는 res[][0] 같은 경우는 마지막 집 전까지 점화식을 수행하고
res[][1] 같은 경우는 마지막 집까지 점화식을 수행하여 최댓값을 구한다. 
*/