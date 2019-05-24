package control;

public class Test {
	public static void main(String[] args) {

		int curPerPageGroup = 3;// 표현할 페이지 수
		int currentPage = 5;// 현재 페이지 위치
		int index =(currentPage-1)/curPerPageGroup;
	
		int startPage = index*curPerPageGroup +1;//- (curPerPageGroup/2);
		int endPage = (index+1)*curPerPageGroup ; //+ (int)Math.ceil((float)curPerPageGroup/2);
		
		for (int i = startPage; i <= endPage; i++) {
			System.out.print(i + " ");
		}
		
		 
	}
}
