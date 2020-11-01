package b1_2_�ڷᱸ��_Ʈ��;

import java.util.*;

public class A_Ʈ��_�⺻���� {
	/*
	 * [Ʈ��(Tree)]
	 *  - �׷����� ����
	 *  - Ư���� ������ �����ϴ� �׷���
	 *  - �ڷ�� ���̿� ������ ���踦 ��Ÿ���µ� ����ϴ� �ڷᱸ��
	 *  - �׷������� ������, Ʈ���� Ư¡
	 *   . ��Ʈ ��� ����
	 *   . ����Ŭ ����X
	 *   . � �������� �ٸ� �������� ���� ��ΰ� ������
	 *   . ������ ���� V�� �ϸ� ������ ���� V-1
	 *   . ��Ʈ ��带 ������ ��� ����� �Է� ����(in-degree)�� 1
	 *   . Ʈ���� ����� �Ӽ��� ����
	 *   
	 *  - ���
	 *   . ��Ʈ ���(root): �θ� ��尡 ���� Ʈ���� �ֻ��� ���
	 *   . �θ� ���: �ڽź��� ������ �ִ� ���
	 *   . �ڽ� ���: �ڽź��� ������ �ִ� ���
	 *   . �ܸ� ���(leaf): �ڽ��� ���� ������ ���
	 *   . ���� ���: ���� �θ� ���� ���
	 *   . ���� ���: �ش� ��忡�� ��Ʈ ������� ���� ��ο� �ִ� ��� ���
	 *   . �ڼ� ���: �ڽ��� �ڽ� ���� �� �ڽ� ����
	 *   . ����: ��Ʈ ��忡�� �ش� �������� �Ÿ�
	 *   . ����: Ʈ������ ���� ���� �ִ� ����� ����
	 *  
	 * [����Ž��Ʈ��(BST: Binery Search Tree)]
	 *  - ��� ���Ҵ� Ű�� ������, Ű�� ��ü Ʈ������ ������ ���� ����
	 *  - ���� �ڽ��� Ű ���� �θ𺸴� �۾ƾ���
	 *  - ������ �ڽ��� Ű ���� �θ𺸴� Ŀ����
	 *  - BST�� �� �κ�Ʈ���� BST
	 *  - Java �ڷᱸ��: TreeSet, TreeMap
	 *   . Set: key������ ���� �ڷḦ �����ϰ� Ư�� �ڷ��� �˻��� ������ �Ҷ� ���
	 *   . Map: ������ ��������� key���� ���� value�� �����ϴ� <key, value> ����
	 *   * BST�� ������ Map,Set �ڷᱸ���� ��� �߰� �� ������ �ɸ��� �ð����⵵�� logN���� �Ϲ������� HashMap���� ����
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
