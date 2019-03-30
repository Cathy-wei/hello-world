package airplane;

public class Flight implements FlightInterface{
	private String flightNmae;//������
	private int row;//��λ����
	private int rowLength;//ÿ����λ��
	private int[] fail= {-1};//����Ԥ����
	private Passenger[] passengerList;//Ԥ����λ���ÿ�
//--------------------��ʼ��������Ϣ--------------------//
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
//--------------------Ԥ��������Ϣ--------------------//
	public int[] reserve(String[] names) {
		if(names.length>rowLength)//�˿���������һ�ŵ���λ�������ܰ�����λ
			return fail;
		int i=0,j=0,k=0;
		boolean flag=false;
		labelA:for(i=0;i<=row-1;i++) {//����row-1����λ
			for(j=0;j<=rowLength-names.length;j++) {
				for(k=j;k<=j+names.length-1;k++) {//�ӵ�j��λ�ÿ�ʼ����һ���Ƿ���names.length�����ڵĿ���λ
					if(passengerList[i*rowLength+k]!=null)
						break;
				}
				if(k>j+names.length-1) {//���ҵ�
					flag=true;//���
					break labelA;//�˳�����lablelAѭ��
				}
			}
		}
			if(!flag)
				return fail;
			int[] bn=new int[names.length];//�ӵ�i�е�j��λ�ÿ�ʼ������λ
			for(k=j;k<=j+names.length-1;k++) {
				bn[k-j]=i*rowLength+k+1;//����Ԥ����
				passengerList[i*rowLength+k]=new Passenger(names[k-j],i*rowLength+k+1,i,k);//i,������k��λ��
			}
			return bn;
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
