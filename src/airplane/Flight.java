package airplane;

public class Flight implements FlightInterface{
	private String flightNmae;//航班名
	private int row;//座位排数
	private int rowLength;//每排座位数
	private int[] fail= {-1};//返回预订号
	private Passenger[] passengerList;//预订座位的旅客
//--------------------初始化航班信息--------------------//
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
//--------------------预订航班信息--------------------//
	public int[] reserve(String[] names) {
		if(names.length>rowLength)//乘客人数大于一排的座位个数则不能安排座位
			return fail;
		int i=0,j=0,k=0;
		boolean flag=false;
		labelA:for(i=0;i<=row-1;i++) {//遍历row-1排座位
			for(j=0;j<=rowLength-names.length;j++) {
				for(k=j;k<=j+names.length-1;k++) {//从第j个位置开始查找一排是否有names.length个相邻的空座位
					if(passengerList[i*rowLength+k]!=null)
						break;
				}
				if(k>j+names.length-1) {//已找到
					flag=true;//标记
					break labelA;//退出整个lablelA循环
				}
			}
		}
			if(!flag)
				return fail;
			int[] bn=new int[names.length];//从第i行的j个位置开始分配座位
			for(k=j;k<=j+names.length-1;k++) {
				bn[k-j]=i*rowLength+k+1;//生成预订号
				passengerList[i*rowLength+k]=new Passenger(names[k-j],i*rowLength+k+1,i,k);//i,排数；k，位置
			}
			return bn;
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
