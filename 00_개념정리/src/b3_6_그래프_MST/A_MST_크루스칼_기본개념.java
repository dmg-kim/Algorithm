package b3_6_그래프_MST;

public class A_MST_크루스칼_기본개념 {
	/*
	 * [크루스칼(Kruskal)]
	 *  - 시간복잡도: O(ElogV) (V: 정점의 수, E: 간선의 수)
	 *  - 간선을 선택하여 구성
	 *   : 사이클 확인 필요 => 유니온-파인드
	 *  - 절차
	 *   1. 간선들을 가중치 순으로 오름차순 정렬
	 *   2. 정렬 순으로 간선들을 뽑아내 양쪽 정점을 포함한 컴포넌트가 연결되어 있지 않으면(Group 대표값이 다르면) 그룹핑
	 *   3. 간선 V-1개가 뽑혔을때 그 간선들과 정점들이 이루는 그래프가 MST
	 *   
	 *  - 절차
	 *   1. 간선 값 기준으로 오름차순 정렬
	 *   2. 정렬 순으로 간선 선택(사이클 발새시 미선택) 후 그룹핑
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
