<%@ page import="com.liferay.memleak.MemLeakPortlet" %>
<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

Current map size: <%= MemLeakPortlet.MEM_LEAK_LIST.size()%><br/>

Add items to map:<br/>
<a href="<portlet:actionURL name="addItems"><portlet:param name="amount" value="100000000"/></portlet:actionURL>">100 000 000</a><br/>
<a href="<portlet:actionURL name="addItems"><portlet:param name="amount" value="10000000"/></portlet:actionURL>">10 000 000</a><br/>
<a href="<portlet:actionURL name="addItems"><portlet:param name="amount" value="1000000"/></portlet:actionURL>">1 000 000</a><br/>
<a href="<portlet:actionURL name="addItems"><portlet:param name="amount" value="100000"/></portlet:actionURL>">100 000</a><br/>
<a href="<portlet:actionURL name="addItems"><portlet:param name="amount" value="10000"/></portlet:actionURL>">10 000</a><br/>
<hr/>
GC count: <%=MemLeakPortlet.GC%><br/>
<a href="<portlet:actionURL name="fullGC"/>">GC</a><br/>
<hr/>
Reinitialize the reference<br/>
<a href="<portlet:actionURL name="killReference"/>">Re-init Map</a><br/>
<hr/>
Cache<br/>
<a href="<portlet:actionURL name="cacheMiss"/>">Cache Miss</a><br/>
<a href="<portlet:actionURL name="cacheHit"/>">Cache Hit</a><br/>