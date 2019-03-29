package airplane;
//航班接口
public interface FlightInterface {
	public int[] reserve(String[] names);//预定航班座位
	public boolean cancle(int bookingNumber);//取消预定
	public Passenger[] getPassengerList();//返回旅客列表

}
