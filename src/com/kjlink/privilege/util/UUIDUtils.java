﻿package com.kjlink.privilege.util;

import java.util.UUID;

public class UUIDUtils {

	/**
	 * 随机生成id
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase(); 
	}
	
	
}
