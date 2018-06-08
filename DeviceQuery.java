import java.util.*;
import util.HelloWorld;

import java.io.*;  
import java.net.*;
//import net.sf.json.JSONObject; 

public class DeviceQuery {
	public DeviceQuery(){
		;
	}
	public String getDevice(int theNo){
		return ("good" + theNo);
	}
	public String getDevice(String theWord){
		return ("good" + theWord);
	}
	public static void main(String[] args){
		DeviceQuery dq = new DeviceQuery();
		System.out.println(dq.getDevice(0));
		System.out.println(dq.getDevice("bad"));
		//HelloWorld hw = new Helloworld();
		//hw.output();
		Map<String, String> params = new HashMap<String, String>();
		params.put("paras", "{rid:8}");
		//JSONObject mapObject=JSONObject.fromObject(params);
		//System.out.println("mapObject"+mapObject.toString());
		String res = jsonPost("http://118.31.17.202/qipai/roommanlist.php?rid=8", params);
		//String res = jsonPost("http://www.cct.name/javatest.php", params);
		System.out.println(res);
	}
	
	public static String jsonPost(String strURL, Map<String, String> params) {  
		try {  
			URL url = new URL(strURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
			connection.setDoOutput(true);  
			connection.setDoInput(true);
			connection.setUseCaches(false);  
			connection.setInstanceFollowRedirects(true);  
			connection.setRequestMethod("POST"); 
			connection.setRequestProperty("Accept", "application/json"); 
			connection.setRequestProperty("Content-Type", "application/json"); 
			connection.connect();  
			//OutputStreamWriter outt = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); 
			//outt.append(JSONUtil.object2JsonString(params));
			//outt.append("1");
			//outt.flush();  
			//outt.close();  

			int code = connection.getResponseCode();  
			InputStream is = null;  
			if (code == 200) {  
				is = connection.getInputStream();  
			} else {  
				is = connection.getErrorStream();  
			}  

			int length = (int) connection.getContentLength();
			if (length != -1) {  
				byte[] data = new byte[length];  
				byte[] temp = new byte[512];  
				int readLen = 0;  
				int destPos = 0;  
				while ((readLen = is.read(temp)) > 0) {  
					System.arraycopy(temp, 0, data, destPos, readLen);  
					destPos += readLen;  
				}  
				String result = new String(data, "UTF-8");
				return result;  
			}  

		} catch (IOException e) {  
			//LOG.error("Exception occur when send http post request!", e);  
		}  
		return "error";
	}  
}