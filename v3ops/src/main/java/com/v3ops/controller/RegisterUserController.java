package com.v3ops.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.singletons.RegisterUser;

@Controller
@RequestMapping("/user")
public class RegisterUserController {
	private final String USER_AGENT = "Mozilla/5.0";
	
	@RequestMapping(value = "/myregister", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String Dashboard(@RequestBody RegisterUser user) throws Exception {
		
		
		String url = "http://52.90.29.67/index.php/customer/account/createpost";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("enctype","multipart/form-data");

		/*<input type="hidden" name="success_url" value="">
        <input type="hidden" name="error_url" value="">
        <input type="hidden" name="form_key" value="2gcgBVlzuCuOrrP1">*/
		//success_url=&error_url=&form_key=2gcgBVlzuCuOrrP1&
		String urlParameters = "firstname=testfirst&middlename=testmiddle&lastname=testlast&email=lsfjsd@gmail.com&password=123456&confirmation=123456";
		

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		return "Tested";
		
		
		
		
		
		
		
	}

}
