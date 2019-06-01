<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript">

	var ziplistView;
	
	function selectZip(z, a){
		console.log("selectZip");
		console.log(document.getElementById("zipcode"));
		console.log(document.getElementById("address"));
		console.log(z);
		console.log(a);
		document.getElementById("zipcode").value = z;
		document.getElementById("address").value = a;
		$("#zipModal").modal("hide");
		$("#doro").val ="";
		$("#zip_codeList").empty();
	}
	function zipSearch() {
		console.log("집서치가 호출됩니다.")
		ziplistView = document.getElementById("zip_codeList");
		var doro = document.getElementById("doro").value;
		if (doro.length == 0) {
			alert("검색 도로명을 입력!!")
			return;
		}else{
			var params ="act=zipsearch&doro=" + doro;
			//괜찮은 에러 실행시점에는 임포트에의해 정상 실행됨
			sendRequest("${pageContext.request.contextPath}/user", params, zipsearchResult, "GET");
			window.console.log("zipsearchResult 검색결과 전달합니다.");
		}
	}

	function zipsearchResult() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var result = httpRequest.responseXML;
				/* xml 안의 문자는 엘리먼트이다 */
				var ziplist = result.getElementsByTagName("zip");
				var len = ziplist.length;
				var view="";
				for(var i=0; i<len; i++){
					if(i ==1){
						console.log("zip코드가 읽혀집니다.");
					}
					var zipcode =ziplist[i].getElementsByTagName('zipcode')[0].firstChild.data;
					var address =ziplist[i].getElementsByTagName('address')[0].firstChild.data
					view +="<tr>\n";
					view +="	<td>" +zipcode+ "</td>\n";
					view +="	<td align='left'>" ;
					view +='	<a href="javascript:selectZip(\''+zipcode+'\', \''+address+'\');">';
					view +=  	address+"</a>";
					view +="</td>\n";
					view +="</tr>\n";
				}
				ziplistView.innerHTML= view;
			} else {
				//에러페이지
			}
		} else {
			ziplistView.innerHTML="<img src='${pageContext.request.contextPath}/img/loading.gif' width='80'>";
			console.log("이미지를 띄웁니다.");
			//로딩중...
		}
	}
</script>
<div id="zipModal" class="modal fade" role="dialog">
	<!-- <h5 class="modal-title" id="myModalLabel">우편번호검색</h5> -->
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body text-center">
				<!-- <form id="zip_codeForm"> -->
				<div align="center">
					<label>도로명 주소검색</label>
				</div>
				<div class="input-group" align="left">
					<input type="text" class="form-control" id="doro" name="doro" placeholder="검색 할 도로명 입력(예: 구로디지털로, 여수울로)"> <span class="input-group-btn"> <input type="button" class="btn btn-warning" value="검색" id="searchBtn" onclick="javascript:zipSearch();">
					</span>
				</div>
				<!-- 	</form> -->
				<div style="width: 100%; height: 200px; overflow: auto">
					<table class="table text-center">
						<thead>
							<tr>
								<th style="width: 150px;">우편번호</th>
								<th style="width: 600px;">주소</th>
							</tr>
						</thead>
						<tbody id="zip_codeList"></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
