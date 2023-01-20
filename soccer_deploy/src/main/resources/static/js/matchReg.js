document.querySelector("#matchReg").addEventListener("click",function(event){
			event.preventDefault();
			if(document.querySelector("#matchReg").dataset.line == "false"){
				document.querySelector(".pop").style.display = "flex";
			}
			
		})
document.querySelector(".check").addEventListener("click",function(event){
	document.querySelector(".pop").style.display="";
})