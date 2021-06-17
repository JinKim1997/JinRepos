<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${title} : ${count}</title>

<link type="text/css" rel="stylesheet"
	href="resource/res/css/sample.css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javaScript" language="javascript" defer="defer">
	/* $(function(){
		for(var i =0;i<${count};i++)
			$("#tb").append('<tr><td align="center" class="listtd">1</td><td align="center" class="listtd"><a href="">C</a></td><td align="left" class="listtd">2?•™?…„&nbsp;</td><td align="center" class="listtd">Y&nbsp;</td><td align="center" class="listtd">ê¸°ì´ˆê³¼ëª©&nbsp;</td><td align="center" class="listtd">ê´?ë¦¬ì&nbsp;</td></tr>');
				
				
			
		

		
	}); */

	function boardDetail("id"){
		document.listForm.action="/boardDetail.do?id="+id;
		document.listForm.submit();
		
	}
    </script>
</head>

<body
	style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
	<form id="listForm" name="listForm" action="/sample/" method="post">
		<input type="hidden" name="selectedId" />
		<div id="content_pop">
			<!-- ????´??? -->
			<div id="title">
				<ul>
					<li><img src="/resource/res/img/title_dot.gif" alt="" />ê³¼ëª© ëª©ë¡ - ìµœê·¼ ?„ ?ƒê³¼ëª© : ${subTit}</li>
				</ul>
			</div>
			<!-- // ????´??? -->
			<div id="search">
				<ul>
					<li><label for="searchCondition" style="visibility: hidden;">ê²??ƒ‰?–´
							?„ ?ƒ</label> <select id="searchCondition" name="searchCondition"
						class="use">
							<option value="1">Name</option>
							<option value="0">ID</option>
					</select></li>
					<li><label for="searchKeyword"
						style="visibility: hidden; display: none;">ê²??ƒ‰?–´ ?…? ¥</label> <input
						id="searchKeyword" name="searchKeyword" class="txt" type="text"
						value="" /></li>
					<li><span class="btn_blue_l"> <a href="">ê²??ƒ‰</a> <img
							src="/resource/res/img/btn_bg_r.gif" style="margin-left: 6px;"
							alt="" />
					</span></li>
				</ul>
			</div>
			<!-- List -->
			<div id="table">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					summary="" id="tb">
					<caption style="visibility: hidden"></caption>
					<colgroup>
						<col width="40" />
						<col width="200" />
						<col width="50" />
						<col width="80" />
						<col width="?" />
						<col width="60" />
					</colgroup>
					<tr>
						<th align="center">No</th>
						<th align="center">ê³¼ëª©ëª?</th>
						<th align="center">?•™?…„</th>
						<th align="center">ê°œì„¤?—¬ë¶?</th>
						<th align="center">?„¤ëª?</th>
						<th align="center">?“±ë¡ì</th>
					</tr>
					<c:forEach var="result" items="${boardList}" varStatus="status">
						<tr>
							<td align="center" class="listtd">${result.id}</td>
							<td align="center" class="listtd"><a href="javascript:boardDetail('${result.id}')">${result.subject}</a></td>
							<td align="left" class="listtd">${result.grade}&nbsp;</td>
							<td align="center" class="listtd">${result.useYn}&nbsp;</td>
							<td align="center" class="listtd">${result.description}&nbsp;</td>
							<td align="center" class="listtd">${result.regUser}&nbsp;</td>
						</tr>
					</c:forEach>
					
				</table>
			</div>
			<!-- /List -->
			<div id="paging">
				<a href="#" onclick="; return false;"><image
						src=/resource/res/img/btn_page_pre10.gif border=0 /></a>&#160;<a
					href="#" onclick=""><image
						src=/resource/res/img/btn_page_pre1.gif border=0 /></a>&#160;<strong>1</strong>&#160;<a
					href="#" onclick="">2</a>&#160;<a href="#" onclick="">3</a>&#160;<a
					href="#" onclick="">4</a>&#160;<a href="#" onclick="">5</a>&#160;<a
					href="#" onclick="">6</a>&#160;<a href="#" onclick="">7</a>&#160;<a
					href="#" onclick="">8</a>&#160;<a href="#" onclick="">9</a>&#160;<a
					href="#" onclick="">10</a>&#160;<a href="#" onclick=""><image
						src=/resource/res/img/btn_page_next1.gif border=0 /></a>&#160;<a
					href="#" onclick=""><image
						src=/resource/res/img/btn_page_next10.gif border=0 /></a>&#160; <input
					id="pageIndex" name="pageIndex" type="hidden" value="1" />
			</div>
			<div id="sysbtn">
				<ul>
					<li><span class="btn_blue_l"> <a href="/regSubject.do">?“±ë¡?</a> <img
							src="/resource/res/img/btn_bg_r.gif" style="margin-left: 6px;"
							alt="" />
					</span></li>
				</ul>
			</div>
		</div>
	</form>
</body>
</html>
