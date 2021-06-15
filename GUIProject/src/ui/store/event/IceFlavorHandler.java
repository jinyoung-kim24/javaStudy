package ui.store.event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.JCheckBox;

import ui.store.IcecreamStoreFrame9;

// 외부 공통 이벤트 처리 전용 클래스 정의 
public class IceFlavorHandler implements ItemListener {

	//IcecreamStoreFrame8 frm;
	IcecreamStoreFrame9 frm;
	
	public IceFlavorHandler(IcecreamStoreFrame9 frm) {
		this.frm = frm; // 창(프레임)과 연결점.. (주소)
	}
	
	// 아이템의 상태가 변경될 때마다 즉시 실행되는 이벤트 핸들러.
	// 11개의 아이스크림 체크박스가 이 함수 공유
	// 선택된 상태 이벤트라면.. 장바구니 add(),
	// 선택취소하는 상태 이벤트라면.. 장바구니 remove()..
	@Override
	public void itemStateChanged(ItemEvent ie) {
		System.out.println("아이템 상태가 바뀌었습니다! " 
				+ new Date());
		JCheckBox cb = (JCheckBox)ie.getItemSelectable();
		for (int i = 0; i < frm.cbIceFlavors.length; i++) {
			if( cb == frm.cbIceFlavors[i] ) { // 동일성 비교
				System.out.print(i + "번째 아이스크림 체크박스 ");
				if( ie.getStateChange() == ItemEvent.SELECTED ) {
					System.out.println(
						IcecreamStoreFrame9.ICE_NAMES[i] + " 장바구니에 추가됨~~~~");
					frm.selIcecreamList.add(i);
				} else if( ie.getStateChange() == ItemEvent.DESELECTED ) {
					System.out.println(
						IcecreamStoreFrame9.ICE_NAMES[i] + " 장바구니에 삭제됨~~~~");
					int rmPos = -1;
					rmPos = frm.selIcecreamList.indexOf(i);
					frm.selIcecreamList.remove(rmPos);
				} else {
					System.out.println("????");
				}
				frm.lbStatus.setText(">> 선택된 아이스크림 개수: "
						+frm.selIcecreamList.size()+"개");
			}
		}
	}

}
