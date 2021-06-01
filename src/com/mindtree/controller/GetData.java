package com.mindtree.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.services.PersonServices;
import com.mindtree.services.impl.PersonServicesImpl;

@WebServlet("/getmydata")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		String jsonData = "";
		try {
			inputStreamReader = new InputStreamReader(request.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);
			if (bufferedReader != null) {
				jsonData = bufferedReader.readLine();

			}
			PersonServices personServices = new PersonServicesImpl();
			personServices.parsePersonJsonData(jsonData);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
				if (inputStreamReader != null)
					inputStreamReader.close();
			} catch (Exception e2) {
				System.out.println("Resources:BufferedReader and InputStreamReader are not closed properly");
			}
		}
	}

}
