package b4_1_����_����_����;

import java.io.*;

public class G_0901_���Ǻ�� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine().trim()); 

		// (-) ���׿�����: n�� 2�� ����
		// n�� n�� 2�Ǻ����� & �����ϰ� �Ǹ� n�� ���� �������� 1�� �� => ����Ʈ���� ���
		// 2^k�� 1�� ��Ʈ�� �Ѱ�, �� ������ ��Ʈ�� 1�� �� == �ڱ��ڽ�
		if((n & -n) == n) System.out.println("Yes");
		else System.out.println("No");
	}

}
