package OrderMenus;

public class OrderViewTst {
	Order_Handling ordhM = mock(Order_Handling.class);
	OrderLine_handling linhM = mock(OrderLine_handling.class);
	OrderViewMenu ordVM = mock(OrderViewMenu.class);

	OrderMenu ordM = mock(OrderMenu.class);
	OrderViewMenu ordV = new OrderViewMenu(ScannerHandling.getScanner(), ordM);
	OrderViewMenuHandling ordvmh = new OrderViewMenuHandling(ScannerHandling.getScanner(), ordVM);
	Factory factM = mock(Factory.class);
	ArrayList<Order_> orderList = new ArrayList<Order_>();
	ArrayList<OrderLine_> lineList = new ArrayList<OrderLine_>();
	OrderLine_ l1, l2;
	Order_ o1, o2;

	@Before
	public void befro() {

		o1 = new Order_(101, 101);
		o2 = new Order_(102, 102);
		orderList.add(o1);
		orderList.add(o2);
		l1 = new OrderLine_(101, 1, 101, 12, "test");
		l2 = new OrderLine_(101, 1, 102, 31, "test");
		lineList.add(l1);
		lineList.add(l2);

	}

	@After
	public void aftre() {
		orderList.clear();
		lineList.clear();
	}

	@Test
	public void handleviewone() {
		System.out.println("a");
		when(Factory.getOrderHandler()).thenReturn(ordhM);

		when(ordhM.getOrderbyId(anyInt())).thenReturn(o1);
		when(Factory.getOrderlinehandler().getLinesbyOrder(anyInt())).thenReturn(lineList);
		assert (36 < ordvmh.handleViewOne(101).length());

	}

	@Test
	public void handleviewall() {
		System.out.println("b");
		when(Factory.getOrderHandler()).thenReturn(mock(Order_Handling.class));
		System.out.println("b");
		when(Factory.getOrderlinehandler()).thenReturn(linhM);
		System.out.println("b");
		when(ordhM.getAllOrder()).thenReturn(orderList);
		System.out.println("b");
		assertEquals(2, ordvmh.viewAll().size());
		System.out.println("b");
	}

}
