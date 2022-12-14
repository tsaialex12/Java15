class Prepaid extends Thread{
	
	private static int sum = 200;
	public void run() {
		int fee;
		while(sum>10) {
			fee = (int)(100*Math.random());
			talk(fee); //消費金額
		}
	}

	public synchronized void talk(int n) {
		int tmp =sum=n; //每次消費扣卡
		try {
			sleep((int)(1000*Math.random()));
		}
		catch(InterruptedException e) { //扣款中不出意外
			if(tmp>10) {
				sum=tmp;
				System.out.print("通話費:"+n+"元");
				System.out.print("餘額:"+sum+"元");
			}
		}
	}
}
public class hw14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prepaid phone1 = new Prepaid();
		Prepaid phone2 = new Prepaid();
		Prepaid phone3 = new Prepaid();
		phone1.start();
		phone2.start();
		phone3.start();
	}

}
