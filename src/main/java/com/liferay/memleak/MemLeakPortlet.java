package com.liferay.memleak; /**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p/>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPoolUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Miroslav Ligas
 */
public class MemLeakPortlet extends MVCPortlet {

	public void addItems(ActionRequest request, ActionResponse response) {
		int amount = ParamUtil.getInteger(request, "amount", 100000);
		for (int i = 0; i < amount; i++) {
			MEM_LEAK_LIST.add("Filling the memory");
		}

	}

	public void fullGC(ActionRequest request, ActionResponse response){
		System.gc();
		GC++;
	}

	public void killReference(ActionRequest request, ActionResponse response){
		MEM_LEAK_LIST = new ArrayList<String>();
	}

	public void cacheMiss(ActionRequest request, ActionResponse response){
		final PortalCache<Serializable, Object> cache = SingleVMPoolUtil.getCache("com.liferay.portal.servlet.filters.sso.ntlm.NtlmFilter");
		for (int i = 0; i < 1000; i++) {
	    	cache.get(UUID.randomUUID().toString());
		}

	}

	public void cacheHit(ActionRequest request, ActionResponse response){
		final PortalCache<Serializable, Object> cache = SingleVMPoolUtil.getCache("com.liferay.portal.servlet.filters.sso.ntlm.NtlmFilter");
		cache.put("test","test");
		for (int i = 0; i < 1000; i++) {
			cache.get("test");
		}

	}

	public static List<String> MEM_LEAK_LIST = new ArrayList<String>();
	public static int GC = 0;
}
