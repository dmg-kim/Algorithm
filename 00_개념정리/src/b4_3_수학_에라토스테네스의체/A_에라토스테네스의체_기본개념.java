package b4_3_수학_에라토스테네스의체;

public class A_에라토스테네스의체_기본개념 {
	/*
	 * [에라토스테네스의 체]
	 *  - 비교적 작은 구간(10^8이하)에서 소수를 빠르게 찾는 방법 중 하나
	 *  - 절자
	 *   1. 2부터 소수를 구하고자 하는 구간의 모든 수만큼 배열 선언
	 *   2. 2는 소수이므로 2를 제외한 2의 배수 모두 지우기
	 *   3. 지워진 수를 제외한 수부터 자기 자신을 제외한 수의 배수를 모두 지우기
	 *   4. 3과정 반복하면 구하는 구간의 모든 소수가 남음
	 *  - 주의점: 배열 크기로 선언할 수 없는 구간의 소수인지 유의
	 *  
	 *  - 예제: 100 이하의 소수 출력
	 */
	public static void main(String[] args) throws Exception {
		boolean prime[] = new boolean[101];
		
		prime[0] = prime[1] = true;	// 0과 1은 소수가 아니므로 제외
		
		for (int i = 2; i * i <= 100; i++) {	// 100의 제곱근인 10까지의 작은 수의 배수들만 지워도 충분함
			if(!prime[i]) {
				for (int j = i * i; j <= 100; j+=i) {	// 배수들을 모두 제외
					prime[j] = true;
				}
			}
		}
		
		for (int i = 1; i <= 100; i++) {
			if(!prime[i]) System.out.print(i + " ");
		}
	}
}
