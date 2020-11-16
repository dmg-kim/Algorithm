package b5_1_DP;

public class A_DP_기본개념 {
	/*
	 * [동적계획법]
	 *  - 어렵거나 큰 문제를 간단하고 작은 여러 개의 문제로 나누어서 풀고
	 *    작은  문제들의 답들을 이용하여 원래 문제의 답을 구하는 방식
	 *  1) 최적 부분 구조
	 *   : 문제의 정답이 작은 문제에 대해서도 정답
	 *  2) 부분문제 반복
	 *   : 문제를 여러개의 작은 문제로 나눌 수 있음
	 *  - 메모이제이션
	 *   : 미리 구해둔 정답을 메모해 놓고 필요시 가져다 씀
	 *  - 하향식
	 *   : 큰 문제를 풀수 있는 작은 문제가 될때까지 나눈 후, 
	 *     작은 문제들의 정답들을 합쳐가며 큰 문제의 답 구하는 방식
	 *     (재귀함수 사용)
	 *  - 상향식
	 *   : 작은 문제부터 시작하여 차례대로 풀어나가는 방식
	 *     (For문)
	 *     
	 * # DP 정의  및 3요소
	 *  - 큰 문제 -> 작은문제로 단순화 -> 점화식 유도 -> 재귀(하향식)/루프(상향식)으로 결과값 결합 -> 큰 문제 해결 
	 *   . 점화식으로 해결 못하는 작은 문제 -> 초기화
	 *   . 중복 계산 -> 메모이제이션
	 *  - 3요소: 점화식, 초기화, 메모이제이션
	 * # 점화식 유도 Tip
	 *  - 가장 작은 문제부터 확장해가며 결과값을 넣어보고
	 *    해당 결과값이 어떻게 나왔는지 규칙 찾기
	 *   . DP[0], DP[1], DP[2], ... 손으로 계산 가능할 때까지
	 *   . 확장된 문제에서 작은 문제의 결과값을 꼭 이용할 수 있도록 함
	 *  - DP 배열을 1, 2차원으로 선언하고 한글로 명확히 정의함
	 *   . DP[i][j]: i번째 보석까지 고려했고 가방에 j(kg)을 채웠을때 얻을 수 있는 최대 보석 가치 합
	 *    -> 정의의 마지막은 보통 문제에서 원하는 정답으로 정의
	 *       i와 j를 문제에서 주어진 변수들 중에 어떤 값을 사용할지 고민
	 *  - 입력값 -> 점화식 바로 유도(쉬운 경우)
	 *    입력값 -> 전처리/중간 계산과정 -> 점화식 유도(어려운 경우) ex) [연습A-0029] 헬스보이 
	 * # 참고 - 시간/공간 복잡도
	 *  - 작은 문제 -> 큰 문제까지 해결하기 위해 보통 DP 배열 전체를 채워야함.
	 *   . 배열 사이즈가 시간 복잡도이자 공간 복잡도
	 *   . 3차원까지 가면 제한시간을 초과하게 될 것이므로 점화식을 개선하여 차원수를 낮추자.
	 *    : 3차원 -> 2차원(거의필수), 2차원 -> 1차원(가능한 경우) ex) [기출P-0061] 보석줍기    
	 *    
	 *    
	 *  1. 부분문제 정의
	 *   - 무슨값을 정할지 => Table 정의
	 *  2. 점화식 구하기
	 *   - 그 값을 어떻게 구할지 계산식
	 *  3. 문제해결
	 *   - 값을 직접구하는 코드 작성
	 */
	
	public static void main(String[] args) {
		int res = 0;
		long start, end;
		
		// 1. 하향식
		start = System.currentTimeMillis();
		res = fibo_topdown(35);
		end = System.currentTimeMillis();
		System.out.println("1. 하향식(재귀): " + res + " (" + (end-start)/1000 + "." + (end-start)%1000+" sec)" );
		
		// 2. 상향식
		start = System.currentTimeMillis();
		res = fibo_bottomup(35);
		end = System.currentTimeMillis();
		System.out.println("2. 상향식(for): " + res + " (" + (end-start)/1000 + "." + (end-start)%1000+" sec)" );
		
		// 3. 하향식(재귀) + 메모
		start = System.currentTimeMillis();
		res = fibo_topdown_new(35);
		end = System.currentTimeMillis();
		System.out.println("3. 하향식(재귀+메모): " + res + " (" + (end-start)/1000 + "." + (end-start)%1000+" sec)" );
		
		
	}

	private static int fibo_topdown_new(int n) {
		int dp[] = new int [100];
		
		if(n <= 1) return dp[n] = 1;
		
		if(dp[n] > 0) return dp[n];
		else return dp[n] = fibo_topdown_new(n-1) + fibo_topdown_new(n-2);
	}

	private static int fibo_bottomup(int n) {
		int dp[] = new int[100];
		dp[0] = dp[1] =1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
		
	}

	private static int fibo_topdown(int n) {
		if(n <= 1) return 1;
		return n = fibo_topdown(n-1) + fibo_topdown(n-2);
	}
	
	
}
