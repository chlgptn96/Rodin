package rodin.controller.io;

import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rodin.filetransfer.FileClient;

@Controller
@RequestMapping("/client")
public class AnalysisController {
	
	@RequestMapping
	@ResponseBody
	public String imageClient() throws UnknownHostException, IOException {
		FileClient fc = new FileClient("localhost", 5000);
		return "Client!";
	}
		


}
