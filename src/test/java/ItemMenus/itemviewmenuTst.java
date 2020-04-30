package ItemMenus;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import ItemMenus.ItemViewMenuHandling;
import javafx.beans.binding.When;
import logicClasses.Item_;

public class itemviewmenuTst {
Item_ i1,i2;
ArrayList<Item_> itemlist = new ArrayList<Item_>();
@Before
public void befro() {
	i1 = new Item_("ss", 1, 10, 10);
	i2 = new Item_("qq",2,20,20);
	itemlist.add(i1);itemlist.add(i2);
}
@After
public void aftre() {
	i1 = i2 = null; itemlist.clear();
}
@Test
public void testviewonw() {
	ItemViewMenuHandling ivmhM =Mockito.mock(ItemViewMenuHandling.class);
	Mockito.when(ivmhM.getitem(Matchers.anyInt())).thenReturn(i1);
	Mockito.when(ivmhM.handleViewOne(Matchers.anyInt())).thenCallRealMethod();
	String itemstr = "Name: "+i1.getItemName()+
			"\nID  : "+i1.getItemId()+ //TODO rewirte
			"\ncost: "+i1.getItemPrice()+"\n";
	assertEquals(itemstr, ivmhM.handleViewOne(12));
}
@Test
public void testviewall() {
	ItemViewMenuHandling ivmhM =Mockito.mock(ItemViewMenuHandling.class);
	Mockito.when(ivmhM.getallitems()).thenReturn(itemlist);
	Mockito.when(ivmhM.handleViewAll()).thenCallRealMethod();
	assert(2 == ivmhM.handleViewAll().size());
}
}

