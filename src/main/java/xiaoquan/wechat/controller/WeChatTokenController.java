package xiaoquan.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xiaoquan.wechat.util.Check;

@Controller
public class WeChatTokenController {
	@RequestMapping("/")
	@ResponseBody
	public void weChat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("laile,laodi");
		String signature = request.getParameter("signature");// 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce");// 随机数
		String echostr = request.getParameter("echostr");// 随机字符串
		System.out.println("signature:"+signature+"--timestamp:"+timestamp+"--:nonce"+nonce+"--echostr:"+echostr);
		if(StringUtils.isEmpty(signature)) {
			throw new RuntimeException("服务器异常,请求失败");
		}
		PrintWriter out = response.getWriter();
		
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败 
		if (Check.checkSignature(signature, timestamp, nonce)) {
			System.out.println(echostr);
			out.print(echostr);
		}
		out.close();
	}
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "hello,world";
		
	}
}
