package shape.d2.tri;
/*
 *   > shape.d2.tri.MyRigthTriangle 클래스
  > 각 하나가 직각 90 PI/2 이면됨 (구체화된 특성)
  - 자신의 종류를 표현하는 String shapeType "직각각형"
 */
public class MyRigthTriangle extends MyTriangle{
	private boolean isRigthTriangle() {
		// > 각 하나가 직각 90 PI/2 이면됨 (구체화된 특성)
		// || 로 혹은 3 내각 중에서 단 하나라도 90라면 직각 삼각형
		return false;
		
		
	}
	
}
