package ZoomQuickSummary;

//import java.io.BufferedReader;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.io.IOException;
//import java.io.InputStream;
//
//import com.squareup.okhttp.MediaType;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.RequestBody;
//import com.squareup.okhttp.Response;
//import java.awt.Desktop;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.net.URLConnection;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.Scanner;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

public class ZoomAPI {
	
//	public static final int DEFAULT_BUFFER_SIZE = 8192;
//	
//	private static String makeMeetingRequest() {
//		String clientId = "nJd15hLCQj2o3ynXszpsDw";
//		String clientSecret = "lwVNrTQPxcffVsJkjWE6r4SuMsKhLve1";
//		String authBaseURL = "https://zoom.us/oauth/authorize?response_type=code&client_id="+ clientId +"&redirect_uri=https://localhost:3000";
//		
//		if (Desktop.isDesktopSupported()) {
//			Desktop desktop = Desktop.getDesktop();
//			try {
//				URI uriObj = new URI(authBaseURL); 
//				desktop.browse(uriObj);
//			} catch (IOException | URISyntaxException e) {
//				e.printStackTrace();
//			}
//		}
//		else {
//			Runtime runtime = Runtime.getRuntime();
//			try {
//				runtime.exec("xdg-open " + authBaseURL);
//				System.out.println("authBaseURL: " + authBaseURL);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		ServerSocket serverSocket;
//		try {
//			serverSocket = new ServerSocket(3000);
//			Socket socket = serverSocket.accept();
//			
//			InputStream inputStream = socket.getInputStream();
//			String thisIsIt = convertInputStreamToString(inputStream);
//			
//			System.out.println(thisIsIt);
//			
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		// END OF STEP 1. CANNOT COMPLETE STEP 2 WITHOUT AUTH CODE FROM URI.
//		
//		
//		String clientIdAndSecret = clientId + ":" + clientSecret;
//		String base64ClientIdAndSecret = "Basic " + Base64.getEncoder().encodeToString(clientIdAndSecret.getBytes());
////		System.out.println(base64ClientIdAndSecret); // for DEBUG
//		
//		OkHttpClient client = new OkHttpClient();
//		Request request = new Request.Builder()
//			.url("https://zoom.us/oauth/token")
//			.addHeader("Authorization", base64ClientIdAndSecret)
//			.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), "code=" + "l1nk34Wuwh_I_r6fmeZSRaNiKoRE0LtzA" + "&grant_type=authorization_code&redirect_uri=https://localhost:3000"))
//			.build();
//		
//		try {
//			Response response = client.newCall(request).execute();
//			String token = response.body().string();
//			JSONArray result = new JSONArray();
////			result = response.body().string();
////			String token = result.get("access_token");
//			return token;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("POST request returned: " + makeMeetingRequest());
//	}
//	
//	private static String convertInputStreamToString(InputStream inputStream)
//            throws IOException {
//
//      String newLine = System.getProperty("line.separator");
//      StringBuilder result = new StringBuilder();
//      try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//          String line;
//          while ((line = reader.readLine()) != null) {
//              result
//                      .append(line)
//                      .append(newLine);
//          }
//      }
//      return result.toString();
//
//  }
}
