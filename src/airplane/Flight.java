package airplane;

public class Flight implements FlightInterface{
	private String flightNmae;//������
	private int row;//��λ����
	private int rowLength;//ÿ����λ��
	private int[] fail= {-1};//����Ԥ����
	private Passenger[] passengerList;//Ԥ����λ���ÿ�
	public Flight(String FlightName,int rows,int rowLength) throws Exception{
		if(FlightName==null || FlightName.trim().length()==0 || rows<=0 || rowLength<=0)
			throw new Exception("Error!");
		else {
			this.flightNmae=FlightName;
			this.row=rows;
			this.rowLength=rowLength;
			this.passengerList=new Passenger[row*rowLength];//����������λ
			for(int i=0;i<row*rowLength;i++)
				passengerList[i]=null;//������λû�б�Ԥ��
		}
	}
	@Override
	public int[] reserve(String[] names) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public boolean cancle(int bookingNumber) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public Passenger[] getPassengerList() {
		// TODO �Զ����ɵķ������
		return null;
	}

	

}
