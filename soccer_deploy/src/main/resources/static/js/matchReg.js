document.querySelector("#matchReg").addEventListener("click",function(event){
			if(document.querySelector("#matchReg").dataset.line == "false"){
				event.preventDefault();
				document.querySelector(".pop").style.display = "flex";	
			}
		})
document.querySelector(".check").addEventListener("click",function(event){
	document.querySelector(".pop").style.display="";
})