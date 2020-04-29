package OrderMenus;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.internal.stubbing.defaultanswers.ReturnsDeepStubs;

import InitClass.Factory;
import InitClass.ScannerHandling;
import logicClasses.Database_;
import logicClasses.Database_handling;
import logicClasses.OrderLine_;
import logicClasses.OrderLine_handling;
import logicClasses.Order_;
import logicClasses.Order_Handling;

//@RunWith(PowerMockRunner.class)
////@PrepareForTest(Factory.class)
//@PrepareEverythingForTest
public class OrderViewTst {
	// @Mock
	// Factory fm ;//= Mockito.mock(Factory.class);
	@Mock
	OrderMenu ordM;// =Mockito.mock(OrderMenu.class);
	@Mock
	OrderViewMenu ordVM;// = Mockito.mock(OrderViewMenu.class);
	@Mock
	Order_Handling ordhM;
	@Mock
	OrderLine_handling orlinhM;
	@InjectMocks
	Factory f;
//	Order_Handling ordhM;
	OrderLine_handling linhM;

	// Factory f;
	// OrderMenu ordM;
	OrderViewMenu ordV;

	Factory factM;
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

	@Test
	public void handleviewone() {
//		System.out.println("a");

		
	}

	@Test
	public void handleviewall() {
		System.out.println("b");

//		System.out.println("b");
//		when(Factory.getOrderlinehandler()).thenReturn(linhM);
//		System.out.println("b");
//		when(ordhM.getAllOrder()).thenReturn(orderList);
//		System.out.println("b");
//		assertEquals(2, ordvmh.viewAll().size());
//		System.out.println("b");
	}

}
