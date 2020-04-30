package OrderMenus;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import logicClasses.Item_;
import logicClasses.Item_Handling;
import logicClasses.OrderLine_;
import logicClasses.OrderLine_handling;
import logicClasses.Order_;

public class orderadditemTst {
	OrderLine_ l1 = new OrderLine_(101, 1, 101, 12, "test");
	Order_ o1;
	@Before
	public void befro() {
		o1 = new Order_(101, 101);
		 
	}

	@After
	public void aftre() {

	}

	@Test
	public void orderinit() {

	}

	@Test
	public void additemtoorder() {
		OrderAddItemMenuHandling oaimhM = Mockito.mock(OrderAddItemMenuHandling.class);
		Mockito.when(oaimhM.getlinehandler()).thenReturn(Mockito.mock(OrderLine_handling.class));
		Mockito.when(oaimhM.createline(Matchers.any(OrderLine_handling.class), Matchers.any(Order_.class),
				Matchers.anyInt(), Matchers.anyInt())).thenReturn(l1).thenReturn(null);
		Mockito.when(oaimhM.addItemtoOrder(o1, 101, 101)).thenCallRealMethod();
		assertEquals(true, oaimhM.addItemtoOrder(o1, 101, 101));
		assertEquals(false, oaimhM.addItemtoOrder(o1, 101, 101)) ;
	}
}
