package airplane;

public class Flight implements FlightInterface{
	private String flightNmae;//航班名
	private int row;//座位排数
	private int rowLength;//每排座位数
	private int[] fail= {-1};//返回预订号
	private Passenger[] passengerList;//预订座位的旅客
	public Flight(String FlightName,int rows,int rowLength) throws Exception{
		if(FlightName==null || FlightName.trim().length()==0 || rows<=0 || rowLength<=0)
			throw new Exception("Error!");
		else {
			this.flightNmae=FlightName;
			this.row=rows;
			this.rowLength=rowLength;
			this.passengerList=new Passenger[row*rowLength];//创建航班座位
			for(int i=0;i<row*rowLength;i++)
				passengerList[i]=null;//所有座位没有被预订
		}
	}
	@Override
	public int[] reserve(String[] names) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public boolean cancle(int bookingNumber) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public Passenger[] getPassengerList() {
		// TODO 自动生成的方法存根
		return null;
	}

	

}
