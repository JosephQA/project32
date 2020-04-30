package OrderMenus;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import logicClasses.OrderLine_;
import logicClasses.Order_;

public class orderCreationTst {

	
	ArrayList<Order_> orderList = new ArrayList<Order_>();
	ArrayList<OrderLine_> lineList = new ArrayList<OrderLine_>();
	OrderLine_ l1, l2;
	Order_ o1, o2;

	@Before
	public void befro() {

//		ordhM = Mock(Order_Handling.class);
//		linhM = mock(OrderLine_handling.class);
//		ordVM = mock(OrderViewMenu.class);
//		ordM = mock(OrderMenu.class);
//		ordV = new OrderViewMenu(ScannerHandling.getScanner(), ordM);
//		ordvmh = new OrderViewMenuHandling(ScannerHandling.getScanner(), ordVM);
//		factM = mock(Factory.class);
		o1 = new Order_(101, 101);
		o2 = new Order_(102, 102);
		orderList.add(o1);
		orderList.add(o2);
		l1 = new OrderLine_(101, 1, 101, 12, "test");
		l2 = new OrderLine_(101, 1, 102, 31, "test");
		lineList.add(l1);
		lineList.add(l2);
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void aftre() {
		orderList.clear();
		lineList.clear();
	}
	
}
