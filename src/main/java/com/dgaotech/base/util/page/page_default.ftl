<div class="${styleClass[0]?default("")}">
	<#if (currentPage > 1)>
		<#if handleScript?has_content>
			<a href="javascript:${handleScript}('${url}&currentPage=1')">${firstName}</a>&nbsp;&nbsp;<a href="javascript:${handleScript}('${url}&currentPage=${prePage}')">${preName}</a>&nbsp;&nbsp;
		<#else>
			<a href="${url}&currentPage=1">${firstName}</a>&nbsp;&nbsp;<a href="${url}&currentPage=${prePage}">${preName}</a>&nbsp;&nbsp;
		</#if>
	<#else>
		${firstName}&nbsp;&nbsp;${preName}&nbsp;&nbsp;
	</#if>
	<#if (pageScope?size > 0)>
		<#list pageScope as page_index>
			<#if (currentPage != page_index)>
				<a href="<#if handleScript?has_content>javascript:${handleScript}('</#if>${url}&currentPage=${page_index}<#if handleScript?has_content>')</#if>">${page_index}</a>
			<#else>
				<span class="${styleClass[1]}">${page_index}</span>
			</#if>
			&nbsp;<#if (page_index_has_next)>|</#if>&nbsp;
		</#list>
	</#if>
	<#if (totalPages > currentPage)>
		<#if handleScript?has_content>
			<a href="javascript:${handleScript}('${url}&currentPage=${nextPage}')">${nextName}</a>&nbsp;&nbsp;<a href="javascript:${handleScript}('${url}&currentPage=${lastPage}')">${lastName}</a>&nbsp;&nbsp;
		<#else>
			<a href="${url}&currentPage=${nextPage}">${nextName}</a>&nbsp;&nbsp;<a href="${url}&currentPage=${lastPage}">${lastName}</a>&nbsp;&nbsp;
		</#if>
	<#else>
		${nextName}&nbsp;&nbsp;${lastName}&nbsp;&nbsp;
	</#if>
	${pageInfo}
	<#if goFlag>
		${goBtnTo}<input type="text" id="goPageNo" name="goPageNo" class="${styleClass[2]}" value="" />${goBtnPage}
		<a href="javascript:checkPageScope('goPageNo',${totalPages},'${url}')">${goBtnText}</a>&nbsp;&nbsp;
		<script language="javascript">
			function checkPageScope(id, maxPageNo, url){
				if (!isIntDigit(id)) {
					alert("${txtInputNumMsg}[1-" + maxPageNo + "]");
					return;
				}
				var pageNo = document.getElementById(id).value;
				if (pageNo < 1 || pageNo > maxPageNo) {
					alert("${txtInputNumScopeMsg}[1-" + maxPageNo + "]");
				} else {
					goToPage(url);
				}
            }
        </script>
	</#if>
	<#if pageSizeFlag>
		${pageSizeText}
		<select id="rcPerPage" name="rcPerPage" onchange="javascript:changePageSize('${url1}', this.value)">
			<option value=""></option>
		<#if (pageSizeArray?size > 0)>
			<#list pageSizeArray as tmpPageSize>
				<option value="${tmpPageSize}" <#if (pageSize == tmpPageSize?number)>selected</#if>>${tmpPageSize}</option>
			</#list>
		</#if>
		</select>
	</#if>
	
</div>