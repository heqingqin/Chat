package Chat_Server.Server_View;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP:瀹氫綅涓�涓妭鐐�:璁＄畻鏈恒�佽矾鐢便�侀�氳璁惧绛�
 * InetAddress: 澶氫釜闈欐�佹柟娉�
 * 1銆乬etLocalHost:鏈満
 * 2銆乬etByName:鏍规嵁鍩熷悕DNS |  IP鍦板潃 -->IP
 * 
 * 涓や釜鎴愬憳鏂规硶
 * 1銆乬etHostAddress: 杩斿洖鍦板潃
 * 2銆乬etHostName:杩斿洖璁＄畻鏈哄悕
 * @author 瑁存柊 QQ:3401997271 
 *
 */
public class IPTest {

	public static void main(String[] args) throws UnknownHostException {
		//浣跨敤getLocalHost鏂规硶鍒涘缓InetAddress瀵硅薄  鏈満
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());  //杩斿洖锛�192.168.1.110
		System.out.println(addr.getHostName());  //杈撳嚭璁＄畻鏈哄悕
		
		//鏍规嵁鍩熷悕寰楀埌InetAddress瀵硅薄
		addr = InetAddress.getByName("www.shsxt.com"); 
		System.out.println(addr.getHostAddress());  //杩斿洖 shsxt鏈嶅姟鍣ㄧ殑ip:
		System.out.println(addr.getHostName());  //杈撳嚭锛歸ww.shsxt.com
		
		//鏍规嵁ip寰楀埌InetAddress瀵硅薄
		addr = InetAddress.getByName("123.56.138.176"); 
		System.out.println(addr.getHostAddress());  //杩斿洖 shsxt鐨刬p:123.56.138.176
		System.out.println(addr.getHostName());  //杈撳嚭ip鑰屼笉鏄煙鍚嶃�傚鏋滆繖涓狪P鍦� 鍧�涓嶅瓨鍦ㄦ垨DNS鏈嶅姟鍣ㄤ笉鍏佽杩涜IP鍦板潃鍜屽煙鍚嶇殑鏄犲皠锛�

				


	}

}
