package ch11_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetCoin {
	public static void main(String[] args) {
		String url = "https://api.upbit.com/v1/market/all";

		Scanner scan = new Scanner(System.in);
		
		try {
			URL call_url = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)call_url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			if(connection.getResponseCode() != 200) {
				throw new RuntimeException("failed:"+ connection.getResponseCode());
			}
			BufferedReader br = new BufferedReader
					(new InputStreamReader(connection.getInputStream()));
			StringBuilder result = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				result.append(line);
			}
			// JSONParser를 이용해 파싱
			System.out.println("JSON response: "+result.toString());
			JSONParser parser = new JSONParser();
			JSONArray arr;
			try {
				arr = (JSONArray) parser.parse(result.toString());
				System.out.println("JSONArray: " +arr.toJSONString());
				for(Object obj : arr) {
					JSONObject jsonObj = (JSONObject) obj;
					System.out.println(jsonObj.get("korean_name")+":"+jsonObj.get("market"));
 				}
				System.out.println("코인의 키 값을 입력해주세요");
				System.out.print(">>>");
				String keyName = scan.nextLine();
				
				String url_detail = "https://api.upbit.com/v1/ticker?markets="+keyName;
				
				URL call_url_detail = new URL(url_detail);
				HttpURLConnection connection_detail = (HttpURLConnection)call_url_detail.openConnection();
				connection_detail.setRequestMethod("GET");
				connection_detail.setRequestProperty("Accept", "application/json");
				if(connection_detail.getResponseCode() != 200) {
					throw new RuntimeException("failed:"+ connection_detail.getResponseCode());
				}
				BufferedReader br_detail = new BufferedReader
						(new InputStreamReader(connection_detail.getInputStream()));
				StringBuilder result_detail = new StringBuilder();
				String line_detail;
				while((line_detail = br_detail.readLine()) != null) {
					result_detail.append(line_detail);
				}
				// JSONParser를 이용해 파싱
				System.out.println("JSON response: "+result_detail.toString());
				JSONParser parser_detail = new JSONParser();
				JSONArray arr_detail= (JSONArray) parser_detail.parse(result_detail.toString());
					System.out.println("JSONArray: " +arr_detail.toJSONString());
					for(Object obj : arr_detail) {
						JSONObject jsonObj = (JSONObject) obj;
						System.out.println(jsonObj.get("trade_price"));
	 				}
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
