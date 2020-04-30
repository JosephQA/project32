package OrderMenus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.internal.stubbing.defaultanswers.ReturnsDeepStubs;

import InitClass.ScannerHandling;
import logicClasses.OrderLine_;
import logicClasses.Order_;

public class ordercalccosthandlingTst {
	Order_ o1, o2;
	ArrayList<OrderLine_> lineList = new ArrayList<OrderLine_>();
	OrderLine_ l1, l2;

	@Before
	public void befro() {
		o1 = new Order_(101, 101);
		o2 = new Order_(102, 102);
		l1 = new OrderLine_(101, 1, 101, 12, "test");
		l2 = new OrderLine_(101, 1, 102, 31, "test");
		lineList.add(l1);
		lineList.add(l2);
	}

	@After
	public void aftre() {
		o1 = o2 = null;
	}

	@Test
	public void handlemenuintput() {
		OrderCalcCostMenuHandling tstme = Mockito.mock(OrderCalcCostMenuHandling.class);// new
																						// OrderCalcCostMenuHandling(ScannerHandling.getScanner()
																						// , ordCCM);
		Mockito.when(tstme.getOrder(2)).thenReturn(o1);
		Mockito.when(tstme.handleMenuIntput(anyInt())).thenCallRealMethod();
		assertEquals(o1, tstme.handleMenuIntput(2));
		assert (tstme.handleMenuIntput(44) == null);
	}

	@Test
	public void fetchcost() {
		OrderCalcCostMenuHandling tstme = Mockito.mock(OrderCalcCostMenuHandling.class);//new OrderCalcCostMenuHandling(ScannerHandling.getScanner()	, ordCCM);
		when(tstme.getList(Matchers.anyObject())).thenReturn(lineList);
		when(tstme.getlinePrice(Matchers.any())).thenReturn(12.00).thenReturn(10.00);
		when(tstme.fetchCost(o1)).thenCallRealMethod();
		assertEquals("22.0", tstme.fetchCost(o1));
		
	}

}
