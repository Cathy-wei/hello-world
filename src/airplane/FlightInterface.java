package airplane;
//����ӿ�
public interface FlightInterface {
	public int[] reserve(String[] names);//Ԥ��������λ
	public boolean cancle(int bookingNumber);//ȡ��Ԥ��
	public Passenger[] getPassengerList();//�����ÿ��б�

}
