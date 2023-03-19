package com.rubato.market.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class IamPortController {
	
	private IamportClient api;
	
	public IamPortController() {
		//REST API키와 REST API SECRET을 아래처럼 순서대로 입력한다.
		this.api = new IamportClient("8664784548603271", "rcaJhk0SFBIpqxNK1VhFrMIXIGmfX2cWbe7gEdx4kbI30Uvwg6DqJkBwyPvRItEIACAIGCcN8OmsX4Ad");
	}
	
	@ResponseBody
	@RequestMapping(value="/vertifyIamport/{imp_uid}")
	public IamportResponse<Payment> paymentByImUid(Model model, Locale locale, HttpSession session,
													@PathVariable(value="imp_uid") String imp_uid) throws IamportResponseException, IOException{
		return api.paymentByImpUid(imp_uid);
	}
}
