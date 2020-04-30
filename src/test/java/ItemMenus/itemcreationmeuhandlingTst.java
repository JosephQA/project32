package ItemMenus;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import logicClasses.Item_;

public class itemcreationmeuhandlingTst {
Item_ i = new Item_("name", 101, 101, 101);

@Test
public void handleaddingitem() {
	ItemCreationMenuHandling icmhM = Mockito.mock(ItemCreationMenuHandling.class);
	Mockito.when(icmhM.createitem(Matchers.anyString(), Matchers.anyDouble(), Matchers.anyInt())).thenReturn(i).thenReturn(null);
	Mockito.when(icmhM.handleAddingItem(Matchers.anyString(), Matchers.anyDouble(), Matchers.anyInt())).thenCallRealMethod();
	assert(101 == icmhM.handleAddingItem("ww", 22.0, 22));
	assert(-1 == icmhM.handleAddingItem("ww", 22.0, 22));
}
}
