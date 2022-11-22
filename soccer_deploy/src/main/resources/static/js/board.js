document.querySelector("#file").addEventListener("change",function(event){
    let filename = document.querySelector("#filenames");
    console.log(11);
    if(this.files[0]== undefined){
        filename.innerText="선택된 파일없음";
        return;
    }else if(this.files.length > 1){
        
        filename.innerText = `${this.files[0].name} 외 ${this.files.length - 1}개`;    
    }else{
        filename.innerText = this.files[0].name;
    }
    
});