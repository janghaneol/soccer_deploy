import {vali} from "/js/vali.js";

document.querySelector(".table").addEventListener("input", function (event) {
    let a;
    let b;
    if (event.target && event.target.id == "goal") {
        if(vali.Limit(event.target.value)){
            console.log(!vali.Limit(event.target.value));
            event.target.value = event.target.value.replace(event.target.value,"");
        }
        if(vali.Zero(event.target.value)){
            event.target.value = event.target.value.replace(event.target.value,"");
        }
        b = event.target.parentElement.parentElement.children[3].lastElementChild.value;
        console.log(b);
        a = +b+ event.target.value * 2;
        event.target.parentElement.parentElement.lastElementChild.lastElementChild.value = a;
    }
    else if (event.target && event.target.id == "assist") {
        if(vali.Limit(event.target.value)){
            console.log(!vali.Limit(event.target.value));
            event.target.value = event.target.value.replace(event.target.value,"");
        }
        if(vali.Zero(event.target.value)){
            event.target.value = event.target.value.replace(event.target.value,"");
        }
        console.log(event.target.parentElement.parentElement.children[2]);
        b = event.target.parentElement.parentElement.children[2].lastElementChild.value;
        a = +b * 2 + +event.target.value;

        event.target.parentElement.parentElement.lastElementChild.lastElementChild.value = a;
    }
});

document.querySelector(".table").addEventListener("blur", function (event) {
    if (event.target && event.target.id == "goal") {
        if(event.target.value == ""){
            event.target.value = 0;
        }
    }
    else if (event.target && event.target.id == "assist") {
        if(event.target.value == ""){
            event.target.value = 0;
        }
    }
},true);