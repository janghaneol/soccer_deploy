let arr  =["articleId","writer","groupNo","levelNo","orderNo"];
document.querySelector(".comment-div").addEventListener("click",function(event) {
    if(event.target && event.target.classList.contains("write-reply")){
        let lipart = event.target.parentElement.parentElement; //li를 가지고 옴      
        console.log(lipart.dataset.orderno);
        console.log(lipart);
        
        let div_first = document.createElement("div"); 
        let strong = document.createElement("strong");
        let myId = document.querySelector("#myid").value;
        let strtext = document.createTextNode(myId);
        let div_second = document.createElement("div");
        
        div_first.classList.add("comment-write-reply");        
        div_second.classList.add("comment-writer") 
        
        strong.appendChild(strtext);
        div_second.appendChild(strong);

        //나중에 controller 주소와 post인지 get인지 넣어주면 동작
        let form = document.createElement("form");
        form.action ="#";
        form.method = "post"

        let textarea = document.createElement("textarea");
        textarea.name="content";
        textarea.id = "comment";
        textarea.placeholder="댓글을 입력하세요.";
        //article id        
        let input1 = document.createElement("input");
        input1.type ="hidden";
        input1.name = arr[0];
        input1.value = lipart.parentElement.dataset.article;
        // 작성자 아이디
        let input2 = document.createElement("input");
        input2.type ="hidden";
        input2.name = arr[1];
        input2.value = myId;

        let input3 = document.createElement("input");
        input3.type ="hidden";
        input3.name = arr[2];
        input3.value = lipart.parentElement.dataset.article;

        let input4 = document.createElement("input");
        input4.type ="hidden";
        input4.name = arr[3];
        input4.value = 2;

        let input5 = document.createElement("input");
        input5.type ="hidden";
        input5.name = arr[4];
        input5.value = lipart.dataset.orderno;





        let form_div_first = document.createElement("div");
        form_div_first.classList.add("comment-reg");
        let button = document.createElement("button");
        button.type="submit";
        button.classList.add("comment-reg-btn");
        let btntext = document.createTextNode("등록");
        button.appendChild(btntext);
        form_div_first.appendChild(button);
        form.appendChild(textarea);
        form.appendChild(form_div_first);

        form.appendChild(input1);
        form.appendChild(input2);
        form.appendChild(input3);
        form.appendChild(input4);
        form.appendChild(input5);



        div_first.appendChild(div_second);
        div_first.appendChild(form);
        if(document.querySelector(".comment-write-reply")){
            document.querySelector(".comment-write-reply").remove();
        }
        lipart.after(div_first);
        
    }
    
})