package com.it.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetApiController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/getRequest")  
    public String getRequest(){
        return "this is getRequest";
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/ApiDTO")
	public ApiDTO usedModelGetApi(ApiDTO ApiDTO){
	    return ApiDTO;
	}
	
	
}
