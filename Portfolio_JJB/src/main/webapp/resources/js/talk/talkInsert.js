/**
 * 
 */

$(document).ready(function(){
	$("input[value=업로드]").click(function(){
		var form= $("form[name=uploadForm]")[0];
		var formData = new FormData(form);
		
		console.log(form)
		console.log(formData)
		
		if(form==""){
			alert("파일을 넣어주세요.")
			return false;
		}
		
		$.ajax({
			url : '../menu/talk',
			type:'post',
			data: formData,
			contentType:false,
			processData:false,
			success:function(data){
				var imgnum = $(opener.document).find('#countImg').val()*1;
				alert(imgnum)
				if(imgnum >1){
					$(opener.document).find('#brback'+(imgnum-1)).remove();
				}
				var str = "<br id='brfront"+imgnum+"'><div class='deleteDiv"+imgnum+"' contentEditable='false' onclick='checkImg()'><img class='imgSample' id='getImage"+imgnum+"' style='width:200px;height:200px; vertical-align: bottom'></img><input type='button' value='삭제' onclick='deleteImg("+'"'+data+'"'+','+imgnum+")'></div><br id='brback"+imgnum+"'>";
				//var str = "<br><div class='deleteDiv"+imgnum+"'><img class='imgSample' id='getImage"+imgnum+"' style='width:200px;height:200px;'></img><a onclick='deleteImg("+'"'+data+'"'+','+imgnum+")' style='cursor:pointer'>x</a></div><br>";

				//insertHtmlAtCursor(str);
				$(opener.document).find('.temporaryTag').before(str);
				$(opener.document).find('#getImage'+imgnum).attr("src","talk/displayFile?fileName="+data);
				if(imgnum==1){
					$(opener.document).find('input[name=imgname]').val("talk/displayFile?fileName="+data);
				}
				$(opener.document).find('#countImg').val(imgnum+1);
				window.close();
			}
		
		})
	})
})