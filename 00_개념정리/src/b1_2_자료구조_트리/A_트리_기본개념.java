package b1_2_자료구조_트리;

import java.util.*;

public class A_트리_기본개념 {
	/*
	 * [트리(Tree)]
	 *  - 그래프의 일종
	 *  - 특수한 조건을 만족하는 그래프
	 *  - 자료들 사이에 계층적 관계를 나타내는데 사용하는 자료구조
	 *  - 그래프와의 차이점, 트리의 특징
	 *   . 루트 노드 존재
	 *   . 사이클 존재X
	 *   . 어떤 정점에서 다른 저점으로 가는 경로가 유일함
	 *   . 정점의 수를 V라 하면 간선의 수는 V-1
	 *   . 루트 노드를 제외한 모든 노드의 입력 차수(in-degree)는 1
	 *   . 트리는 재귀적 속성을 가짐
	 *   
	 *  - 용어
	 *   . 루트 노드(root): 부모 노드가 없는 트리의 최상위 노드
	 *   . 부모 노드: 자신보다 상위에 있는 노드
	 *   . 자식 노드: 자신보다 하위에 있는 노드
	 *   . 단말 노드(leaf): 자식이 없는 최하위 노드
	 *   . 형재 노드: 같은 부모를 갖는 노드
	 *   . 조상 노드: 해당 노드에서 루트 노느까지 가는 경로에 있는 모든 노드
	 *   . 자손 노드: 자신의 자식 노드와 그 자식 노드들
	 *   . 깊이: 루트 노드에서 해당 노드까지의 거리
	 *   . 높이: 트리에서 가장 깊이 있는 노드의 깊이
	 *  
	 * [이진탐색트리(BST: Binery Search Tree)]
	 *  - 모든 원소는 키를 가지며, 키는 전체 트리에서 유일한 값을 가짐
	 *  - 왼쪽 자식의 키 값은 부모보다 작아야함
	 *  - 오른쪽 자식의 키 값은 부모보다 커야함
	 *  - BST는 그 부분트리도 BST
	 *  - Java 자료구조: TreeSet, TreeMap
	 *   . Set: key값으로 많은 자료를 저장하고 특정 자료의 검색을 빠르게 할때 사용
	 *   . Map: 역할이 비슷하지만 key값에 따라 value를 저장하는 <key, value> 구조
	 *   * BST로 구현된 Map,Set 자료구조는 노드 추가 및 삭제에 걸리는 시간복잡도가 logN으로 일반적으로 HashMap보다 느림
	 */
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		});
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
			
		});
		
		int keys[] = {1,4,2,5,7,3,1};
		int values[] = {2,3,1,5,1,4,1};
		
		for (int i = 0; i < keys.length; i++) {
			set.add(keys[i]);
			map.put(keys[i], values[i]);
		}
		
		if(set.contains(1)) {
			set.remove(1);
		}
		
		for (int key : set) {
			System.out.print(key + " ");
		}
		System.out.println();
		
		if(map.containsKey(5)) {
			map.remove(5);
		}
		
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			Integer value = map.get(key);
					
			System.out.print("(" + key + ", " + value + ")");
		}
		
	}

}
