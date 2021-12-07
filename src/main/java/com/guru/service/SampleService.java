package com.guru.service;

import com.guru.util.MyFinalUtil;
import com.guru.util.Myutil;

public class SampleService {
	public String getmessage(String msg) {
	    return Myutil.notify(msg);
	}
	
	public  String getfinalmessage(String msg) {
	    return Myutil.finalmethod(msg);
	}
	
	public  String getfinalmesg(String msg) {
		MyFinalUtil util = new MyFinalUtil();
	    return util.sendResp(msg);
	}
	
}


