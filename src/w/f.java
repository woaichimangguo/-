package w;

import java.util.Scanner;

public class f {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner input=new Scanner(System.in);
			int n;
			System.out.println("������Ҫ������ٵ��⣺\n");
			n=input.nextInt();
				a bTree;
				System.out.println("\n");
				System.out.println("ѧ�ţ�201571030335");
				System.out.println("---------------------------");
				for(int i = 0; i < n; i++){
					bTree = new a(2);
					bTree.createBTree();
					String result = bTree.CalAndVal();
					System.out.println(bTree.toString() + "=" + result);
				}
				System.out.println("---------------------------");
			}
	}